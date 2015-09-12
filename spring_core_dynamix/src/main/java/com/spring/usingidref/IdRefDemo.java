package com.spring.usingidref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IdRefDemo {

	public boolean getIdRefDemo() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(
				"idref.xml");
		IdRefAction idrefact = ctxt.getBean("idRefAction", IdRefAction.class);
		if (idrefact.insideObj.data > 0) {
			return true;
		}
		return false;
	}
}
