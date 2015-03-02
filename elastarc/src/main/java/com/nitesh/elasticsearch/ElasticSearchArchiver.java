package com.nitesh.elasticsearch;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthStatus;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsResponse;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.alias.IndicesAliasesRequest;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.base.Preconditions;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.joda.time.DateTime;

import com.github.rholder.retry.RetryException;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.StopStrategy;
import com.github.rholder.retry.WaitStrategies;
import com.github.rholder.retry.WaitStrategy;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

public class ElasticSearchArchiver implements Plugin {

	public class ThrowableHandler implements Predicate<Throwable> {
		@Override
		public boolean apply(Throwable throwable) {
			boolean status = false;
			LOG.info("Calling Rollover Reconnect");
			if (throwable instanceof ElasticsearchException) {
				status = true; // should retry based on elastic search exception
				reconnectRollOverEsClient();
				LOG.info("RollOver Reconnect Status " + status);
			}
			return status;
		}
	}

	public class RetryRoll implements Callable<Boolean> {
		private final String newIndex;

		public RetryRoll(String newIndex) {
			this.newIndex = newIndex;
		}

		@Override
		public Boolean call() throws Exception {
			LOG.info("Creating new index with name " + newIndex + " and alias "
					+ indexName);
			Optional<String> indexMapping = retrieveIndexMapping();
			CreateIndexRequest createreq = new CreateIndexRequest(newIndex)
					.alias(new Alias(indexName));
			if (indexMapping.isPresent()) {
				createreq.mapping("_default_", indexMapping.get());
			}
			CreateIndexResponse indexResponse = esClient.admin().indices()
					.create(createreq).actionGet();
			boolean response = indexResponse.isAcknowledged();
			LOG.info("New Index Name : " + newIndex
					+ " , New Index created status :" + response);
			return response;
		}
	}

	public class InitializePluginThrowableHandler implements
			Predicate<Throwable> {
		@Override
		public boolean apply(Throwable throwable) {
			boolean status = false;
			if (throwable instanceof ElasticsearchException) {
				initCounter++;
				isConnected = reconnectRollOverEsClient();
				status = true;
			}
			return status;
		}

	}

	public class InitializeEsIndices implements Callable<Boolean> {

		@Override
		public Boolean call() throws Exception {
			boolean result = false;
			//LOG.info("Intialize Esindices InitCounter is " + initCounter);
			LOG.info("\n");
			indexName = "cda_te3";
			Preconditions.checkState(StringUtils.isNotBlank(indexName),
					"Index name configuration option is not specified.");
			currentIndexName = createIndexName();
			indexInitialization(currentIndexName, indexName);
			String rollingFrequency = "DAY";
			if (StringUtils.isNotBlank(rollingFrequency)) {
				try {
					LOG.info("Calling Rollover Thread " + initCounter);
					rolloverFrequency = FrequencyType.valueOf(rollingFrequency);
					startRolloverThread();
					LOG.info("Initialization completed after : " + initCounter);
					result = true;
				} catch (IllegalArgumentException e) {
					LOG.info("rolling.frequency specified "
							+ rollingFrequency
							+ " is not valid.  Valid values are DAY, HOUR, MINUTE");
				}
			}
			return result;
		}

	}

	public class ReconnectClientThread implements Runnable {
		public ReconnectClientThread() {
			esClient = getClientInstance();
		}

		@Override
		public void run() {
			isConnected = false;
			LOG.info("ReconnectClientThread Retryer started for initializing indices");
			Retryer<Boolean> retryer = RetryerBuilder
					.<Boolean> newBuilder()
					.retryIfException(new InitializePluginThrowableHandler())
					.withWaitStrategy(getFixedWaitStrategy(1, TimeUnit.SECONDS))
					.withStopStrategy(getInitializeStopStrategy()).build();
			try {
				retryer.call(new InitializeEsIndices());
				LOG.info("ReconnectClientThread Retryer completed for initializing indices Number of Attempts : "
						+ initCounter);
			} catch (RetryException e) {
				LOG.info("Stopping EsIndices Initializer Thread due to RetryException: "
						+ e);
				throw new RuntimeException(
						"Stopping EsIndices Initializer Thread due to RetryException : "
								+ e);
			} catch (ExecutionException e) {
				LOG.info("Stopping EsIndices Initializer Thread due to ExecutionException : "
						+ e);
				throw new RuntimeException(
						"Stopping EsIndices Initializer Thread due to ExecutionException : ",
						e);
			}
		}
	}

	int initCounter = 0;
	private static final Logger LOG = Logger.getLogger("ElasticSearchArchiver");

	private static final long DAY = 86400000;
	private static final long HOUR = 3600000;
	private static final long MINUTE = 60000;
	private static final long WAIT_INTERVAL = 1000;
	private static final long RETRY_MAX_TIME = 8;
	private static final long STANDARD_TIMER = 60000L;
	protected static final String ROLLING_FREQUENCY_KEY = "rolling.frequency";
	protected static final String HOSTS_KEY = "es-hosts";
	protected static final String INDEX_KEY = "index";
	protected static final String INDEX_SUFFIX_KEY = "index.suffix.pattern";
	protected static final String ES_CLUSTER_NAME_KEY = "cluster.name";
	protected static final String INDEX_MAPPING_FILE_NAME_KEY = "index.mapping.file";

	protected static final int DEFAULT_PORT = 9300;

	private String indexName;
	private String currentIndexName;
	private boolean isInitialized;
	private Client esClient;
	private boolean isConnected;

	private ScheduledExecutorService rolloverExecutor;
	private ExecutorService initializeExecutor;
	private FrequencyType rolloverFrequency;
	private final Object lock = new Object();
	private volatile boolean isRolloverOccurring;

	public ElasticSearchArchiver() {
		this.currentIndexName = "cda_t3_20150227";
	}

	@Override
	public void initialize() {
		if (!isInitialized) {
			rolloverExecutor = Executors.newScheduledThreadPool(1);
			new Thread(new ReconnectClientThread()).start();
			isInitialized = true;
		}
	}

	public WaitStrategy getFixedWaitStrategy(long time, TimeUnit timeUnit) {
		return WaitStrategies.fixedWait(time, timeUnit);
	}

	public StopStrategy getInitializeStopStrategy() {
		return StopStrategies.neverStop();
	}

	protected String createIndexName() {
		String pattern = "yyyyMMdd";
		if (StringUtils.isNotBlank(pattern)) {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return String.format("%s_%s", indexName, sdf.format(new Date()));
		}
		return indexName;
	}

	protected void startRolloverThread() {
		LOG.info("Configuring Rollover Thread for frequency "+
				rolloverFrequency);
		long interval = -1;
		DateTime now = DateTime.now();
		DateTime nextInterval = null;
		TimeUnit unit = TimeUnit.MILLISECONDS;
		switch (rolloverFrequency) {
		case MINUTE:
			nextInterval = new DateTime(now).withMillisOfSecond(0)
					.withSecondOfMinute(0).plusMinutes(1);
			LOG.info("Creating period with start date :" + now
					+ " and end date " + nextInterval);
			interval = MINUTE;
			break;
		case HOUR:
			nextInterval = new DateTime(now).withMillisOfSecond(0)
					.withSecondOfMinute(0).withMinuteOfHour(0).plusHours(1);
			LOG.info("Creating period with start date " + now
					+ "  and end date " + nextInterval);
			interval = HOUR;
			break;
		case DAY:
			nextInterval = new DateTime(now).withHourOfDay(0)
					.withMinuteOfHour(0).withSecondOfMinute(0)
					.withMillisOfSecond(0).plusDays(1);
			LOG.info("Creating period with start date " + now
					+ " and end date " + nextInterval);
			interval = DAY;
			break;
		default:
			break;
		}
		if (unit == null || interval == -1) {
			return;
		}
		long delay = nextInterval.getMillis() - DateTime.now().getMillis();
		LOG.info("configuring thread with delay " + delay + " and interval "
				+ interval + " and unit " + unit.toString());
		rolloverExecutor.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				LOG.info("Rolling file");
				synchronized (lock) {
					isRolloverOccurring = true;
					currentIndexName = createIndexName();
					LOG.info("new index name is " + currentIndexName);
					roll(currentIndexName);
					LOG.info("RollOver Success for index : " + currentIndexName);
					isRolloverOccurring = false;
				}
			}
		}, delay, interval, unit);
	}

	@SuppressWarnings("unchecked")
	protected List<InetSocketTransportAddress> parseHosts() {
		List<InetSocketTransportAddress> esTransportAddresses = new ArrayList<InetSocketTransportAddress>();
		List<String> hosts = new ArrayList<String>();
		hosts.add("localhost");
		Preconditions.checkState(!hosts.isEmpty(),
				"No Elasticsearch hosts have been configured.");

		for (String host : hosts) {
			Preconditions.checkState(StringUtils.isNotBlank(host),
					"Empty host specified");
			String[] hostParts = host.split(":");
			esTransportAddresses.add(new InetSocketTransportAddress(
					hostParts[0], hostParts.length == 2 ? Integer
							.parseInt(hostParts[1]) : DEFAULT_PORT));
		}
		return esTransportAddresses;
	}

	public WaitStrategy getWaitStrategy(long multiplier, long maximumtime,
			TimeUnit timeUnit) {
		return WaitStrategies
				.exponentialWait(multiplier, maximumtime, timeUnit);
	}

	public StopStrategy getStopStrategy(int attempt) {
		return StopStrategies.stopAfterAttempt(attempt);
	}

	protected void roll(final String newIndex) {
		Retryer<Boolean> retryer = RetryerBuilder.<Boolean> newBuilder()
				.retryIfException(new ThrowableHandler())
				.withWaitStrategy(getWaitStrategy(1000, 10, TimeUnit.MINUTES))
				.withStopStrategy(getStopStrategy(6)).build();

		try {
			retryer.call(new RetryRoll(newIndex));
		} catch (RetryException e) {
			LOG.info("Stopping Roll : " + e);
			throw new RuntimeException(
					"Stopping RollOver due to RetryException ", e);
		} catch (ExecutionException e) {
			LOG.info("Stopping Roll : " + e);
			throw new RuntimeException(
					"Stopping RollOver due to ExecutionException ", e);
		}

	}

	protected void addIndexToAlias(final String name, final String alias) {
		esClient.admin().indices()
				.aliases(new IndicesAliasesRequest().addAlias(alias, name));
	}

	protected void indexInitialization(final String name, final String alias) {
		//LOG.info("Into Index Initialization");
		if (!doesIndexExist(name)) {
			roll(name);
		} else if (!isIndexAliased(name, alias)) {
			addIndexToAlias(name, alias);
		}

	}

	protected boolean doesIndexExist(final String name) {
		//LOG.info("Checking Index exists or not");
		IndicesExistsRequest req = new IndicesExistsRequestBuilder(esClient
				.admin().indices()).setIndices(name).request();
		return esClient.admin().indices().exists(req).actionGet().isExists();
	}

	protected boolean isIndexAliased(final String name, final String alias) {
		ImmutableOpenMap results = esClient.admin().indices()
				.getAliases(new GetAliasesRequest().indices(name)).actionGet()
				.getAliases();
		return results.containsKey(alias);
	}

	protected Optional<String> retrieveIndexMapping() {
		/*
		 * String fileName = ""; if (StringUtils.isBlank(fileName)) { return
		 * Optional.fromNullable(null); } try { return Optional.of("one"); }
		 * catch (IOException e) {
		 * LOG.error("Could not load mapping file named {}", fileName, e); }
		 */
		return Optional.fromNullable(null);
	}

	/*
	 * @Override protected void processMessage(Message message) { while
	 * (isRolloverOccurring) {
	 * LOG.info("Rollover in progress.  Pausing message processing."); try {
	 * Thread.sleep(WAIT_INTERVAL); } catch (InterruptedException e) {
	 * LOG.error("Could not sleep thread", e.getMessage()); } } String
	 * clientCode = message.getProperty(Message.CDA_CLIENT_CODE); if
	 * (StringUtils.isBlank(clientCode)) { LOG.info(
	 * "Message will not be inserted into Elasticsearch because the client code is not present in the Message Header"
	 * ); return; } String msgText = message.getText(); if
	 * (!msgText.contains("HeartbeatDtm")) {
	 * LOG.debug("Writing message to index {}", currentIndexName); try {
	 * esClient.prepareIndex(currentIndexName, clientCode)
	 * .setSource(msgText).execute().actionGet(); } catch
	 * (NoNodeAvailableException e) {
	 * LOG.info("No Node Available Exception Caught. Re-connect to ElasticSearch"
	 * ); boolean successConnect = false; successConnect = reconnectEsClient();
	 * if (successConnect) { LOG.info(
	 * "Connection established with elastic search. Start processing the messages"
	 * ); throw new ElasticsearchException(
	 * "No Node Available Exception Caught. Connection Established to elastic search."
	 * , e); } else { throw new ElasticsearchException(
	 * "No Node Available Exception Caught. Elastic Search Server is not Running."
	 * , e); } } } }
	 */

	@SuppressWarnings("resource")
	private Client getClientInstance() {
		List<InetSocketTransportAddress> esTransportAddresses = parseHosts();
		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", "elastdb").build();
		Client esClient = new TransportClient(settings)
				.addTransportAddresses(esTransportAddresses
						.toArray(new InetSocketTransportAddress[esTransportAddresses
								.size()]));
		return esClient;
	}

	protected boolean reconnectRollOverEsClient() {
		int count = 0;
		this.esClient.close();
		this.esClient = null;
		this.esClient = getClientInstance();
		ClusterHealthStatus clstrstats = ClusterHealthStatus.RED;
		try {
			ClusterStatsResponse response = this.esClient.admin().cluster()
					.prepareClusterStats().get();
			count = response.getNodesStats().getCounts().getTotal();

			clstrstats = this.esClient.admin().cluster().prepareClusterStats()
					.get().getStatus();
			LOG.info("cluster Health is : " + clstrstats.value());

		} catch (ElasticsearchException e) {
			LOG.info("ElasticSearch Exception in cluster stats response " + e.getDetailedMessage());
			LOG.info("ElasticSearch Exception Node Count = "+count);
		} catch (Exception e) {
			LOG.info("Normal Exception in cluster stats response " + e.getStackTrace());
			LOG.info("Normal Exception Node Count = "+count);
		}

		LOG.info("fetched the node counts : " + count
				+ " Elastic Search Nodes are available : " + (count > 0));
		LOG.info("\n");
		return count > 0 && !clstrstats.equals(ClusterHealthStatus.RED) ? true
				: false;
	}

	protected boolean reconnectEsClient() {
		int count = 0;
		long ctr = 1;
		while ((!(count > 0)) && (ctr <= RETRY_MAX_TIME)) {
			this.esClient.close();
			this.esClient = null;
			this.esClient = getClientInstance();
			try {
				Thread.sleep(ctr * STANDARD_TIMER);
				ClusterStatsResponse response = this.esClient.admin().cluster()
						.prepareClusterStats().get();
				count = response.getNodesStats().getCounts().getTotal();
			} catch (ElasticsearchException e) {

				LOG.info("Root Cause in reconnect " + e.getRootCause());
			} catch (Exception e) {
				LOG.info("Root Cause in reconnect " + e.getCause());
			}
			ctr *= 2;
		}

		LOG.info("fetched the node counts : " + count
				+ " Elastic Search Nodes are available : {}" + (count > 0));
		return count > 0 ? true : false;
	}

	@Override
	public void stop() {
		esClient.close();
	}

}
