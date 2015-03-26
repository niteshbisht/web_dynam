package com.nitesh.account.service;

import com.nitesh.elast.nodeservice.ElastNodeService;

public class DbInstancer {
	static ElastNodeService enode;
	public DbInstancer(ElastNodeService elastNode) {
		enode = elastNode;
	}
	
	public static ElastNodeService getElastNodeService() {
		return enode;
	}
}
