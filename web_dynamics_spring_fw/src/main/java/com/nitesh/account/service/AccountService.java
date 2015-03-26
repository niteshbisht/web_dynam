package com.nitesh.account.service;

import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import com.nitesh.elast.nodeservice.ElastNodeService;

public class AccountService {

	public Account login(String username, String password) {
		boolean validLogin = validateFromElastDb(username, password);
		Account account = null;
		if (validLogin)
			account = new Account(username, password);
		return account;
	}

	private boolean validateFromElastDb(String username, String password) {
		ElastNodeService eNodeService = DbInstancer.getElastNodeService();
		Client c = eNodeService.getTClient();
		SearchHit[] searchHit = c.prepareSearch("users")
				.setQuery(QueryBuilders.matchQuery("UserName", username))
				.execute().actionGet().getHits().getHits();
		for (SearchHit hit : searchHit) {

		}

		return searchHit.length > 0;
	}

}
