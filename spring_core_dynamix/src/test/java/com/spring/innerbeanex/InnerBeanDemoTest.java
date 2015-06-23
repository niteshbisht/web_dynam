package com.spring.innerbeanex;

import junit.framework.Assert;

import org.junit.Test;

public class InnerBeanDemoTest {

	@Test
	public void testInrBean(){
		InnerBeanDemo ibn = new InnerBeanDemo();
		Assert.assertTrue(ibn.innerBeanDemo());
	}
}
