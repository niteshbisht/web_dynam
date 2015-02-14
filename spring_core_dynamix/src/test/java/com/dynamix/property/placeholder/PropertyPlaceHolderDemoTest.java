package com.dynamix.property.placeholder;

import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyPlaceHolderDemoTest {

	@Test
	public void testLoadProperties() {
		PropertyPlaceHolderDemo ppd = new PropertyPlaceHolderDemo();
		Object[] obj = ppd.loadBeansByConstructor();
		assertNotNull(obj);
	}
}
