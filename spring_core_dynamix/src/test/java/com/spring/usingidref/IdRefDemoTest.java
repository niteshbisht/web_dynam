package com.spring.usingidref;

import org.junit.Assert;
import org.junit.Test;

public class IdRefDemoTest {
	
	@Test
	public void testIdRefDemo(){
		IdRefDemo idref = new IdRefDemo();
		Assert.assertTrue(idref.getIdRefDemo());
	}
}
