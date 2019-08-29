// 원본 코드
package _solving;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

//중복순열 - 중복된 결과(값) 출력X
public class bj_15665_N과M11 {
	static int N;
	static int M;
	static int[] arr;
	static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.parallelSort(arr);
		re_perm_no_dupVal("", 0);
		
		for(String s : map.keySet())
			System.out.println(s);
	}//end main
	
	static void re_perm_no_dupVal(String s, int k) {
		if(k == M) {
			map.put(s, 0);
			return;
		}
		for(int i=0; i<N; i++) {
			re_perm_no_dupVal(s+arr[i]+" ", k+1);
		}
	}//end re_perm_no_dupVal
}