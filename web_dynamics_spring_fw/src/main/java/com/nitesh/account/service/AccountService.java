package com.nitesh.account.service;

public class AccountService {

	public Account login(String username, String password) {
		boolean validLogin=validateFromElastDb(username, password);
		Account account=null;
		if(validLogin)
			account = new Account(username, password);
		return account;
	}
	
	private boolean validateFromElastDb(String username, String password){
		
		return false;
	}

}
