package com.nitesh.application.context.annotationbased;

import java.util.logging.Logger;

public class MyBeanExampleImpl implements CommonBeanInterface {

	Logger LOG = Logger.getLogger("MyBeanExampleImpl");
	
	@Override
	public void show() {
		LOG.info("hey I am inside the MyBeanExampleIMPL");
	}

}
