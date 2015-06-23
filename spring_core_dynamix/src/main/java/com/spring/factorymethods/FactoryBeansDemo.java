package com.spring.factorymethods;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeansDemo {

	public boolean factoryBeanDemo() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(
				"factorybeans.xml");
		FactoryBeans fb = ctxt.getBean("factoryBeans", FactoryBeans.class);
		if (FactoryBeans.createInstance() != null) {
			return true;
		}
		return false;
	}
}
