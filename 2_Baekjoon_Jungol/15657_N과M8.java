package _solving;

import java.util.Arrays;
import java.util.Scanner;

//중복조합
public class bj_15657_N과M8 {
	static int N;
	static int M;
	static int arr[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		re_comb("", 0, 0);
	}//end main
	
	static void re_comb(String s, int idx, int k) {
		if(k==M) {
			System.out.println(s);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			re_comb(s+arr[i]+" ", i, k+1);
		}
	}//end re_comb method
}
