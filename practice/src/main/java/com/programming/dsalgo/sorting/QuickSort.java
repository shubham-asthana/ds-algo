package com.programming.dsalgo.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 8, 5, 1, 4, 23 };
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using quick sort.
	 * 
	 * @param arr the input array
	 */
	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (arr[i] <= pivot && i < high) {
				i++;
			}
			while (arr[j] > pivot && j > low) {
				j--;
			}
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;

		return j;
	}
}
