package _solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 조합 - 중복되는 값(결과) 출력 X
public class bj_15664_N과M10 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<String> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		list = new ArrayList<String>();
		
		for(int i=0; i<N; i++) 
			arr[i] = sc.nextInt();
		
		Arrays.parallelSort(arr);
		
		comb_no_repVal("", 0, 0);
		for(String s : list)
			System.out.println(s);
	}//end main
	
	static void comb_no_repVal(String s, int idx, int k) {
		if(k==M) {
			if(list.contains(s))
				return;
			else {
				list.add(s);
				return;
			}
		}
		
		for(int i=idx; i<N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			comb_no_repVal(s+arr[i]+" ", i, k+1);
			visited[i] = false;
		}
	}//end comb_no_repVal method
}
