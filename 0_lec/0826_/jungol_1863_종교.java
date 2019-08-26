package _solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class jungol_1863_종교 {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		parents = new int[n+1];
		rank = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
//			if(a>b) union2(b, a);
//			else union2(a, b);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=1; i<=n; i++) {
			int tmp = findSet(parents[i]);
			if(list.contains(tmp))
				continue;
			else
				list.add(tmp);
		}
		System.out.println(list.size());
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(x==parents[x]) {
			return x;
		}
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		// findSet은 
		int px = findSet(x);
		int py = findSet(y);
		
		if(rank[px] > rank[py]) {
			parents[py] = px;
		}
		else {
			parents[px] = py;
			if(rank[px]== rank[py])
				rank[py]++;
		}
	}
	
	
	static void union2(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		parents[py] = px;
	}
}
