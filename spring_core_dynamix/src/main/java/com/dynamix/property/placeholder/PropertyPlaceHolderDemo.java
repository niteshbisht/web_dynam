package com.dynamix.property.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyPlaceHolderDemo {
	public Object[] loadBeansByConstructor() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(
				"propertplaceholderdemons.xml");
		PropertyRootClass bs = ctxt
				.getBean("propertyRoot", PropertyRootClass.class);
		System.out.println(bs.childpropA.hostnameA);
		System.out.println(bs.childpropB.hostnameB);

		Object[] object = new Object[2];
		object[0] = bs.childpropA;
		object[1] = bs.childpropB;
		return object;
	}
}
