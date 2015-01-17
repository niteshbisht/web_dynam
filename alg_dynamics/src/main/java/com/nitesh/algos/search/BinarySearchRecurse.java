package com.nitesh.algos.search;

public class BinarySearchRecurse {
	public static int rank(int num, int[] a) {
		return rank(num, a, 0, a.length - 1);
	}

	public static int rank(int num, int[] a, int lo, int hi) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (num < a[mid])
			return rank(num, a, lo, mid - 1);
		else if (num > a[mid])
			return rank(num, a, mid + 1, hi);
		else
			return mid;
	}
}
