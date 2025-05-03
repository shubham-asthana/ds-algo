package com.programming.dsalgo.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 2, 8, 5, 1, 4, 23 };
		mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * Sorts the array using merge sort.
	 * 
	 * @param arr the input array
	 */
	private static void mergeSort(int[] arr) {
		divide(arr, 0, arr.length - 1);
	}

	private static void divide(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;

		divide(arr, low, mid);
		divide(arr, mid + 1, high);

		merge(arr, low, mid, high);
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		List<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid + 1;
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
	}
}
