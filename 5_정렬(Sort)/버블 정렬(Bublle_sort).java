package 정렬;

import java.util.Arrays;

public class Bublle_sort {
	public static void main(String[] args) {
		int[] arr = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		BubbleSort_asc(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	// 내림차순
	public static void BubbleSort_desc(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1]<arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	// 오름차순
	public static void BubbleSort_asc(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr.length-i; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
