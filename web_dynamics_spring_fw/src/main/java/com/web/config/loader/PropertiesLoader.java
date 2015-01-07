package com.web.config.loader;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesLoader {
	CompositeConfiguration config;
	private static PropertiesLoader INSTANCE = null;
		
	private PropertiesLoader(){
		this.config = new CompositeConfiguration();
		//config.addConfiguration(new SystemConfiguration());
		try {
			config.addConfiguration(new PropertiesConfiguration("src/main/resources/dbconfig.properties"));
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CompositeConfiguration getPropertyConfig(){
		if(INSTANCE==null){
			INSTANCE = new PropertiesLoader();
		}
		return INSTANCE.config;
	}
			
}
