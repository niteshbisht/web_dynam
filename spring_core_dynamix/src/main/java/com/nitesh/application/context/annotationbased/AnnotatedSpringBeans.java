package com.nitesh.application.context.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotatedSpringBeans {
	public boolean doAnnotatedDemo() {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(
				AnnotationConfig.class);
		boolean ret1 = doWork(ctxt);
		boolean ret2 = doWorkReal(ctxt);
		if (ret1 && ret2)
			return true;
		else
			return false;
	}

	public static boolean doWork(ApplicationContext ctxt) {
		CommonBeanInterface mbean = ctxt.getBean("myBeanExample",
				CommonBeanInterface.class);
		return mbean.show();
	}

	public static boolean doWorkReal(ApplicationContext ctxt) {
		CommonBeanInterface mbean = ctxt.getBean("myRealBean",
				CommonBeanInterface.class);
		return mbean.show();
	}

}
