package com.programming.dsalgo.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 13, 46, 24, 52, 20, 9 };
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using insertion sort.
	 * 
	 * @param arr the input array
	 */
	private static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				j--;
			}
		}
	}
}
