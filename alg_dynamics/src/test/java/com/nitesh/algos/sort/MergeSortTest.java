package com.nitesh.algos.sort;

import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void testMerge() {
		MergeSort mgsort = new MergeSort();
		int[] A = new int[9];
		for (int i = 8; i >= 0; i--)
			A[i] = 9 - i;

		mgsort.mergeSort(A, 0, 8);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]+" | ");
		// System.out.println(b);
	}
	
	
}
