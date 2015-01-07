package com.web.authenticate_user;

import org.apache.commons.configuration.CompositeConfiguration;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.web.config.loader.PropertiesLoader;

public class ElasticSearchDb {

	private static ElasticSearchDb INSTANCE = null;
	private Client client;

	public static ElasticSearchDb getElastDbInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ElasticSearchDb();
		}
		return INSTANCE;
	}

	private ElasticSearchDb() {
		// for preventing invocation of constructor from outside world
		CompositeConfiguration config = PropertiesLoader.getPropertyConfig();
		Settings settings = ImmutableSettings
				.settingsBuilder()
				.put("cluster.name",
						config.getString("elasticsearch.server.clustername"))
				.build();
		this.client = new TransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(config
						.getString("elasticsearch.server.host"), config
						.getInt("elasticsearch.server.port")));
	}

	public static Client getEsClient() {
		return getElastDbInstance().client;
	}
}
