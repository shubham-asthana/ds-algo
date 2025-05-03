package com.programming.dsalgo.sorting;

public class RecursiveInsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 13, 46, 24, 52, 20, 9 };
		recursiveInsertionSort(arr, arr.length, 0);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using recursive insertion sort.
	 * 
	 * @param arr the input array
	 */
	private static void recursiveInsertionSort(int[] arr, int n, int i) {
		if (i == n)
			return;
		int j = i;
		while (j > 0 && arr[j - 1] > arr[j]) {
			int temp = arr[j];
			arr[j] = arr[j - 1];
			arr[j - 1] = temp;
			j--;
		}
		recursiveInsertionSort(arr, n, i + 1);
	}
}
