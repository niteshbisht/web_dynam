package com.nitesh.reverse.ptrar;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlaywithPointersTest {

	@Test
	public void testPlayWithPointers() {
		PlaywithPointers ppt=new PlaywithPointers();
		CharPtr m =ppt.playPointers("Hello");
		
		String resultstr=ppt.viewChars(m);
		assertEquals("Hello", resultstr);
		
	}
}
