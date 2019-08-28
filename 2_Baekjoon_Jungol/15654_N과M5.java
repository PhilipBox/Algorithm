package _solving;

import java.util.Arrays;
import java.util.Scanner;

// 순열 
public class bj_15654_N과M5 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		perm("", 0);
		
	}
	
	static void perm(String s, int k) {
		if(k==M) {
			System.out.println(s);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			perm(s+arr[i]+" ", k+1);
			visited[i] = false;
		}
	}
	
	
	
	
	
	
}
