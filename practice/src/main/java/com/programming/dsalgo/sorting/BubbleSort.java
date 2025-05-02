package com.programming.dsalgo.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 13, 46, 24, 52, 20, 9 };
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using bubble sort.
	 * 
	 * @param arr the input array
	 */
	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int swap = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					swap = 1;
				}
			}
			if (swap == 0)
				break;
		}
	}
}
