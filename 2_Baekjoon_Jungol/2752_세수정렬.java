package Baekjoon;

import java.util.Scanner;

// 세수정렬
public class bj_2752 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		QuickSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}

	public static void QuickSort(int[] arr, int start, int end) {
		if( start >= end)
			return;
		
		int pvt = start;
		int i = start + 1;
		int j = end;

		while (i <= j) {
			while (i <= end && arr[i] <= arr[pvt]) {
				i++;
			}

			while (j > start && arr[j] >= arr[pvt]) {
				j--;
			}

			if (i > j) {
				int temp = arr[j];
				arr[j] = arr[pvt];
				arr[pvt] = temp;
			} else {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		QuickSort(arr, start, j-1);
		QuickSort(arr, j+1, end);
	}

}
