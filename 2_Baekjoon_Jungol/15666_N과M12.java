package _solving;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

// 중복순열 - 중복된 값(결과) 제거 
public class bj_15666_N과M12 {
	static int N;
	static int M;
	
	static int[] arr;
	static LinkedHashMap<String, String> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		map = new LinkedHashMap<String,String>();
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.parallelSort(arr);
		re_comb_no_dupVal("", 0, 0);
		
		for(String s : map.keySet())
			System.out.println(s);
	}//end main

	static void re_comb_no_dupVal(String s,int idx,  int k) {
		if(k==M) {
			map.put(s,s);
			return;
		}
		
		for(int i=idx; i<N; i++)
			re_comb_no_dupVal(s+arr[i]+" ", i ,k+1);
	}//end re_comb_no_dupVal method
}