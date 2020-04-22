package 정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 정렬모음 {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };

//		QuickSort(arr, 0, arr.length - 1);
//		BubbleSort(arr);
//		SelectionSort(arr);
//		InsertionSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}

	// 퀵소트
	// i,j 의 증감조건에서의 값 대소비교를 바꿔주면 내림차순이 된다.
	public static void QuickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int pvt = start;
		int i = start + 1;
		int j = end;

		while (i <= j) {
			while (i <= end && arr[i] <= arr[pvt])
				i++;
			while (j > start && arr[j] >= arr[pvt])
				j--;

			if (i > j) {
				int tmp = arr[j];
				arr[j] = arr[pvt];
				arr[pvt] = tmp;
			} else {
				int tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
			}
			QuickSort(arr, start, j - 1);
			QuickSort(arr, j + 1, end);
		}

	}

	// 버블소트 오름차순
	// j와 j-1의 대소비교만 바꿔주면 내림차순
	public static void BubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					int tmp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = tmp;
				}
			}
		}
	}

	// 선택정렬
	// min -> max = Integer.Min_VALUE; max를 찾아주는 조건으로 바꾸면 내림차순.
	public static void SelectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			int tmp = 0;
			for (int j = i; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					idx = j;
				}
			}
			tmp = arr[idx];
			arr[idx] = arr[i];
			arr[i] = tmp;
		}
	}

	// 삽입정렬
	// j와 j-1의 대소비교만 바꿔주면 내림차순.
	public static void InsertionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int j = i;
			while(j>0 && arr[j-1] > arr[j]) {
				int tmp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = tmp;
				j--;
			}
		}
	}
	
}
