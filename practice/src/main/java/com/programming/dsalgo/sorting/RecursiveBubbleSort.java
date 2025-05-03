package com.programming.dsalgo.sorting;

public class RecursiveBubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 13, 46, 24, 52, 20, 9 };
		recursiveBubbleSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using recursive bubble sort.
	 * 
	 * @param arr the input array
	 */
	private static void recursiveBubbleSort(int[] arr, int n) {
		if (n == 1)
			return;
		int swap = 0;

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;
				swap = 1;
			}
		}

		if (swap == 0)
			return;
		recursiveBubbleSort(arr, n - 1);
	}
}
