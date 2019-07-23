package day04_0723;

import java.util.Arrays;
import java.util.Scanner;

public class d3_2817_부분수열의합 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for(int ts=1; ts<=T; ts++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arr = new int[N];
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			
			System.out.println("#"+ts+ " " +mask(arr, K) );
			
			
		}//end test cases
		
	}//end main
	
	static int mask(int[] arr, int K) {
		
		int cnt=0;
		for(int i=0; i< (1<<arr.length); i++) {
			int sum=0;
			for(int j=0; j<arr.length; j++) {
				if( ((1<<j)&i) !=0){
					sum+=arr[j];
				}
				
			}//end j 
			if(sum == K)
				cnt++;
		}//end i
		
		return cnt;
	}//end mask method
	
	
	
	
	
	static void perm(int[] arr, int idx, int K) {
		
		if(idx==arr.length) {
			
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			
			swap(arr, i, idx);
			perm(arr, idx+1, K);
			swap(arr, i, idx);
		}
		
		
		
		
	}//end perm method
	
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}//end swap method
	
	
	
	
	
	
}
