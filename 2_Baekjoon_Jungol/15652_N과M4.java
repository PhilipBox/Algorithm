package _solving;

import java.util.Scanner;

public class bj_15652_N과M4 {
	static int[] arr;
	StringBuilder sb;
	
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = i+1;
		
		perm("",0,0); 
	}//end main
	
	static void perm(String s, int k , int idx) {
		if(k==M) {
			System.out.println(s);
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			perm(s+arr[i]+" ",k+1, i);
		}
	}
	
}
