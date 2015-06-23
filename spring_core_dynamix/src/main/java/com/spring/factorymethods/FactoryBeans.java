package com.spring.factorymethods;

public class FactoryBeans {
	private static FactoryBeans clientFactory = new FactoryBeans();

	private FactoryBeans() {
	}

	public static FactoryBeans createInstance() {
		return clientFactory;
	}
}