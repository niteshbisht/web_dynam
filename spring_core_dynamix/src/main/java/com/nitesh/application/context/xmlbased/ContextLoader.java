package com.nitesh.application.context.xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nitesh.application.context.annotationbased.AnnotationConfig;

public class ContextLoader {
	public boolean doContextDemo() {
		ApplicationContext ctxt = new ClassPathXmlApplicationContext(new String[] {"beandef.xml", "childone.xml", "childone.xml"});
	
		ParentBean pb = ctxt.getBean("parentbean", ParentBean.class);
		System.out.println(pb.childOne.hashCode());
		return true;
//		boolean ret1 = doWork(ctxt);
//		boolean ret2 = doWorkReal(ctxt);
//		if (ret1 && ret2)
//			return true;
//		else
//			return false;
	}
}
