package 정렬;

import java.util.Arrays;

public class Insertion_sort {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		
		InsertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void InsertionSort(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			int j=i;
			while(j>0 && arr[j-1] > arr[j]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}
	
}
