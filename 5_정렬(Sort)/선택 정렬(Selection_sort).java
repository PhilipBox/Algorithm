package 정렬;

import java.util.Arrays;

public class Selection_sort {
	public static void main(String[] args) {
		int[] arr = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		
		SelectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void SelectionSort(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			int temp = 0;
			for(int j=i; j<arr.length; j++) {
				if(min>arr[j]) {
					min = arr[j];
					idx = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = temp;
		}
	}
	
	
}
