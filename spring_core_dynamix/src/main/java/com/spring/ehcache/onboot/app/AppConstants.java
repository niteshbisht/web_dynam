package com.spring.ehcache.onboot.app;

public enum AppConstants {
	APP_QT("APP_QT","select * from tree"), 
	TRAV_CIQT("TRAV_CIQT", "select * from tree2"),
	JENKINS_QT("JENKINS_QT","select * from tree3");
	private String appType;
	private String query;

	private AppConstants(String appType, String query) {
		this.appType = appType;
		this.query = query;
	}

	@Override
	public String toString() {
		return appType;
	}

	public String getQuery() {
		return query;
	}

}
