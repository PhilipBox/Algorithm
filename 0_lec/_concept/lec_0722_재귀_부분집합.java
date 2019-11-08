package day03_0722;

import java.util.Arrays;

public class 부분집합 {

	public static void main(String[] args) {
	
		int[] arr= {1,2,3};
//		recur(arr, 0, 0);
		
		boolean[] selected = new boolean[3];
		recur2(arr, selected, 0);
		
		
	}//end main
	
	public static void recur2(int[] arr, boolean[] selected, int idx) {
		
		if(idx == arr.length) {
//			System.out.println(Arrays.toString(selected));
			
			//부분집합의 합 출력
			int sum=0;
			for(int i=0; i<arr.length; i++) {
				if(selected[i])
					sum+=arr[i];
			}
			System.out.println(sum);
			return;
		}
		
	
		
		
		selected[idx] = true;
		recur2(arr, selected, idx+1);
		selected[idx] = false;
		recur2(arr, selected, idx+1);
		
		
	}//end recur2 method
	
	public static void recur(int[] arr, int idx, int sum) {
		if (idx == arr.length) {
			System.out.println(sum);
			return;
		}
		
		System.out.println(arr[idx]);
		recur(arr, idx+1, sum+arr[idx]);
		
		
		
	}//end recur method
}
