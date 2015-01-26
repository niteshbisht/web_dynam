package com.nitesh.application.context.annotationbased;

import java.util.logging.Logger;

public class MyBeanExample implements CommonBeanInterface {

	Logger LOG = Logger.getLogger("MyBeanExample");

	@Override
	public boolean show() {
		LOG.info("hey I am inside the MyBeanExample");
		return true;
	}

}
