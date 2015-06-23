package com.spring.factorymethods;

import org.junit.Test;

import junit.framework.Assert;

public class FactoryBeansDemoTest {

	@Test
	public void testFactoryBeans() {
		FactoryBeansDemo fb = new FactoryBeansDemo();
		//fb.factoryBeanDemo();
		Assert.assertEquals(true, fb.factoryBeanDemo());
	}
}
