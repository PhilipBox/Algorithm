package day04_0723;

import java.util.Arrays;

public class 순열2 {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		
		
		perm(arr, 0);
	}//end main
		
	static void perm(int[] arr, int idx) {
		if(idx==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			swap(arr, i , idx);
			perm(arr,idx+1);
			swap(arr, i, idx);
		}
		
	}//end perm method
	
	
	static void swap(int[] arr, int a, int b) {
		
		int tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
		
	}//end swap method
	
}
