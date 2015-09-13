package com.spring.ehcache.onboot.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.base.mysql.tree.traversal.TreeStructure;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ehcache.onboot.app.caches.AppQTCache;
import com.spring.ehcache.onboot.app.caches.JenkinsQTCache;
import com.spring.ehcache.onboot.app.caches.TravisQTCache;

public class AppLoader2 {
	private static ApplicationContext ctxt;

	public static void main(String[] args) {
		ctxt = new ClassPathXmlApplicationContext("ehcache/ehcache-beandef2.xml");
		/*
		 * MyCacheManager mcm = ctxt.getBean("mycacheClass",
		 * MyCacheManager.class); Employee eu = ctxt.getBean("empbean",
		 * Employee.class); InformationEmployee ie = eu.getInfo();
		 * InformationEmployee ie2 = eu.getInfo(); System.out.println(ie ==
		 * ie2); System.out.println(ie.hashCode());
		 * System.out.println(ie2.hashCode());
		 */

		//MyBootstrapCacheLoaderFactory mbt = ctxt.getBean("", MyBootstrapCacheLoaderFactory.class);
		AppQTCache aqt = ctxt.getBean("appQt", AppQTCache.class);
		TravisQTCache tqt = ctxt.getBean("travisQt", TravisQTCache.class);
		JenkinsQTCache jqt = ctxt.getBean("jenkinsQt", JenkinsQTCache.class);

		TreeStructure aqtTR = aqt.getTreeStructureIface();
		TreeStructure tqtTR = tqt.getTreeStructureIface();
		TreeStructure jqtTR = jqt.getTreeStructureIface();
		ObjectMapper om = new ObjectMapper();
		TreeStructure[] ti = new TreeStructure[3];
		ti[0] = aqtTR;
		ti[1] = tqtTR;
		ti[2] = jqtTR;
		for (int i = 0; i < 3; i++) {
			System.out.println();
			try {
				System.out.println(om.writeValueAsString(ti[i]));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		}
		
		aqtTR = aqt.getTreeStructureIface();
		tqtTR = tqt.getTreeStructureIface();
		jqtTR = jqt.getTreeStructureIface();
	
		System.out.println("Second Time");
		
		ti[0] = aqtTR;
		ti[1] = tqtTR;
		ti[2] = jqtTR;
		for (int i = 0; i < 3; i++) {
			System.out.println();
			try {
				System.out.println(om.writeValueAsString(ti[i]));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		}
	}

}
