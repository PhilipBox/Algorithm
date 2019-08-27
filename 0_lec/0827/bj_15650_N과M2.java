package _solving;

import java.util.Scanner;

public class bj_15650_N과M2 {
	static int[] arr;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++)
			arr[i] = i+1;
		
		comb(new int[M], 0,  0);
	}
	
	static void comb(int[] sel, int idx, int k) {
		if(k==sel.length) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i] + " ");
			}System.out.println();
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			//방문하지 않았더라면 
			if(!visited[i]) {
				sel[k]=arr[i];
				visited[i]=true;
				comb(sel, i, k+1);
				visited[i]=false;
			}
		}
	}
	
}
