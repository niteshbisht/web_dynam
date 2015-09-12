package com.spring.ehcache.onboot.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppLoader {
	private static ApplicationContext ctxt;

	public static void main(String[] args) {
		ctxt = new ClassPathXmlApplicationContext("ehcache/ehcache-beandef.xml");
		MyCacheManager mcm = ctxt.getBean("mycacheClass", MyCacheManager.class);
		Employee eu = ctxt.getBean("empbean", Employee.class);
		InformationEmployee ie = eu.getInfo();
		InformationEmployee ie2 = eu.getInfo();
		System.out.println(ie == ie2);
		System.out.println(ie.hashCode());
		System.out.println(ie2.hashCode());
	}

}
