package com.znitesh.start_test;

import org.apache.commons.configuration.CompositeConfiguration;

import com.web.config.loader.PropertiesLoader;

public class TestMain {

	public static void main(String[] args) {
		
		CompositeConfiguration cc;
		cc =PropertiesLoader.getPropertyConfig();
	}

}
