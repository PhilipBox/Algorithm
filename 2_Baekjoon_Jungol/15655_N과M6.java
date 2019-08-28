package _solving;

import java.util.Arrays;
import java.util.Scanner;

//조합 
public class bj_15655_N과M6 {
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
		
		comb("", 0,0);
	}//end main
	
	
	static void comb(String s, int idx, int k) {
		
		if(k == M) {
			System.out.println(s);
			return;
		}
		
		for(int i=idx; i<N; i++	) {
			if(visited[i])
				continue;
			visited[i] = true;
			comb(s+arr[i]+" ", i, k+1);
			visited[i] = false;
		}
	}//end comb method
}
