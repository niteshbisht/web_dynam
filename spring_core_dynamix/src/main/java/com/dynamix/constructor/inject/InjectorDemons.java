package com.dynamix.constructor.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectorDemons {
	public Object[] loadBeansByConstructor() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(
				"constructorinject.xml");
		BaseClassInject bs = ctxt
				.getBean("baseInjector", BaseClassInject.class);
		System.out.println(bs.childA.childAname);
		System.out.println(bs.childB.childBname);

		Object[] object = new Object[2];
		object[0] = bs.childA;
		object[1] = bs.childB;
		return object;
	}
}
