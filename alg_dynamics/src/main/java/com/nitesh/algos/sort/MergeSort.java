package com.nitesh.algos.sort;

public class MergeSort {
	public void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int left[] = new int[n1 + 2];
		int right[] = new int[n2 + 2];
		left[n1 + 1] = Integer.MAX_VALUE;
		right[n2 + 1] = Integer.MAX_VALUE;
		// populating array left and right
		for (int i = 1; i <= n1; i++)
			left[i] = A[p + i - 1];
		for (int i = 1; i <= n2; i++)
			right[i] = A[q + i];
		int i = 1;
		int j = 1;
		for (int k = p; k <= r; k++) {
			if (left[i] < right[j]) {
				A[k] = left[i];
				i = i + 1;
			} else {
				A[k] = right[j];
				j = j + 1;
			}
		}
	}

	public void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2);
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
}