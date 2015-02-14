package com.dynamix.constructor.inject;

import org.junit.Test;
import static org.junit.Assert.*;
public class InjectorDemonsTest {

	@Test
	public void testLoadBeansByConstructor() {
		InjectorDemons icd = new InjectorDemons();
		Object[] object = icd.loadBeansByConstructor();
		assertNotNull(object);
	}
}
