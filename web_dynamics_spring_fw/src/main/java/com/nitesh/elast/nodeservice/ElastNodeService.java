package com.nitesh.elast.nodeservice;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.net.InetAddresses;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

public class ElastNodeService {
	private TransportClient tclient;
	private String clusterName;

	public ElastNodeService(String clusterName) {
		this.clusterName = clusterName;
		tclient = (TransportClient) initiateClient();
	}

	private Client initiateClient() {
		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", clusterName).build();
		Client client = new TransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(
						"localhost", 9300));
		return client;
	}

	public TransportClient getTClient() {
		return tclient;
	}
}
