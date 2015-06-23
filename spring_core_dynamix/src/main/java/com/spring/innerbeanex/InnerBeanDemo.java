package com.spring.innerbeanex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerBeanDemo {
	boolean innerBeanDemo() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(
				"innerbeandef.xml");
		Outer ou = ctxt.getBean("outerbeandef", Outer.class);
		if (Outer.InnerSrc.innerdata > 0) {
			System.out.println(Outer.InnerSrc.innerdata);
			return true;
		}
		return false;
	}
}
