package _solving;

import java.util.Scanner;

public class bj_6603_로또 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();
			if(N==0)
				break;
			
			arr = new int[N];
			visited = new boolean[N];
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			comb("", 0,0);
			System.out.println();
			// comb
		}//end while
	}//end main
	
	static void comb(String s, int idx, int k) {
		if(k==6) {
			System.out.println(s);
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			comb(s+arr[i]+" ", i, k+1);
			visited[i] = false;
		}
	}//end comb method
}
