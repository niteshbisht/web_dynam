package com.nitesh.application.context.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nitesh.application.context.annotationbased.AnnotationConfig;

public class ContextLoader {
	public boolean doContextDemo() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext("beandef.xml");
		ParentBean pb = ctxt.getBean("parentbean", ParentBean.class);
		System.out.println(pb.childOne.hashCode());
		if(pb.childOne.hashCode()!=0){
			return true;
		}
		return false;
	}
}
