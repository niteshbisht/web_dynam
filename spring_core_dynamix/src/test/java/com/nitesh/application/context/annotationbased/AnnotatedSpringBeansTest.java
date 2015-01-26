package com.nitesh.application.context.annotationbased;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnnotatedSpringBeansTest {

//	@Test
//	public void test() {
//		/*fail("Not yet implemented");*/
//	}
	
	@Test
	public void testDoAnnotatedDemo(){
		AnnotatedSpringBeans ano = new AnnotatedSpringBeans();
		boolean result = ano.doAnnotatedDemo();
		assertTrue(result);
	}

}
