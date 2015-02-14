package com.nitesh.application.context.xmlbased;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.nitesh.application.context.annotationbased.AnnotatedSpringBeans;

public class ContextBasedBeanLoader {

	@Test
	public void testDoXmlContextInit(){
		ContextLoader ano = new ContextLoader();
		boolean result = ano.doContextDemo();
		assertTrue(result);
	}
}
