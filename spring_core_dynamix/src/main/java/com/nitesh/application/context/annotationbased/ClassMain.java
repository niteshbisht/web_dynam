package com.nitesh.application.context.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClassMain {
	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(
				AnnotationConfig.class);
		doWork(ctxt);
		doWorkReal(ctxt);
	}

	public static void doWork(ApplicationContext ctxt) {
		CommonBeanInterface mbean = ctxt.getBean("myBeanExample", CommonBeanInterface.class);
		mbean.show();
	}
	
	public static void doWorkReal(ApplicationContext ctxt) {
		CommonBeanInterface mbean = ctxt.getBean("myRealBean", CommonBeanInterface.class);
		mbean.show();
	}
	
}
