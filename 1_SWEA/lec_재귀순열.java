package day02_0716;

import java.util.Arrays;

public class 재귀순열 {
	public static void main(String[] args) {
		
		int arr[] = {1,2,3};

		
		
	}//end main
	
	
	
	
	//첫번째랑 첫번째 바꾸고 다음으로 1
		//두번째랑 두번째랑 바꾸고 다음으로 2 
			// 세번째랑 세번째랑 바꾸고 다음으로 3 
		//두번째랑 세번째랑 바꾸고 다음으로 4
			// 세번째랑 세번째랑 바꾸고 다음으로 5
	
	// 첫번째랑 두번째 바꾸고 다음으로 6
		
	
	// 첫번째랑 세번째바꾸고 다음으로
	
	
	//순열 method
						//몇번째꺼 바꾸고있는지의 index
	static void perm(int[] arr, int idx) {
		if(idx == arr.length) {
			// 여기가 리프노드!
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		
		for(int i=idx; i<arr.length; i++) {
			//idx(현재위치)랑 i랑 바꾸기.
			swap(arr, i, idx);
			perm(arr, idx+1);
			swap(arr, i, idx);
		}
		
		
		
		
	}//end perm method
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a]= arr[b];
		arr[b] = tmp;
	}
	
	
	
	
	
}//end class
