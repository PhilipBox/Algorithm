package _solving;

import java.util.Arrays;
import java.util.Scanner;

//중복순열 
public class bj_15656_N과M7 {
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		re_perm("", 0);
	}//end main
	
	static void re_perm(String s, int k) {
		if(k==M) {
			System.out.println(s);
			return;
		}
		
		for(int i=0; i<N; i++) {
			re_perm(s+arr[i]+" ", k+1);
		}
	}//end re_perm method
}
