package com.nitesh.elasticsearch;

public enum FrequencyType {
	DAY("DAY"),
	HOUR("HOUR"),
	MINUTE("MINUTE");
	
	String val;
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	private FrequencyType(String val) {
		this.val = val;
	}
	
	
}
