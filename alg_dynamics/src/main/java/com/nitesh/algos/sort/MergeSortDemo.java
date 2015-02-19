package com.nitesh.algos.sort;

public class MergeSortDemo {
	public static void main(String[] args) {
		MergeSort mgsort = new MergeSort();
		int[] A = new int[9];
		for (int i = 8; i >= 0; i--)
			A[i] = 9 - i;

		mgsort.mergeSort(A, 0, 8);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]+" , ");
		// System.out.println(b);
	}
}

class MergeSort {
	public void merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int left[] = new int[n1 + 1];
		int right[] = new int[n2 + 1];
		left[n1 + 1] = Integer.MAX_VALUE;
		right[n2 + 1] = Integer.MAX_VALUE;
		// populating array left and right
		for (int i = 0; i < n1; i++)
			left[i] = A[i];
		for (int i = 0; i < n2; i++)
			right[i] = A[q + i];
		int i = 0;
		int j = 0;
		for (int k = p; k < r; k++) {
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