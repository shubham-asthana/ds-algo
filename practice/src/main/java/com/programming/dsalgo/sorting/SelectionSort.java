package com.programming.dsalgo.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 7, 5, 9, 2, 8 };
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using selection sort.
	 * 
	 * @param arr the input array
	 */
	private static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}
