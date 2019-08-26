package _solving;

import java.util.ArrayList;
import java.util.Scanner;


public class d4_최소스패닝트리_Prims {
	static int[] parents;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] adj = new int[V+1][V+1];
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				adj[a][b] = c;
				adj[b][a] = c;
			}//end for
			
			boolean[] visited = new boolean[V+1];
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(1);
			visited[1] = true;
			
			int sum = 0;
			
			for(int i=1; i<V; i++) {
				
			}
			
			
			
			
			
			
			
			
			
			
		}//end test cases
	}

}
