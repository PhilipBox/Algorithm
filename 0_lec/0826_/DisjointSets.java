package _solving;

import java.util.Arrays;

public class DisjointSets {
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) {
		parents = new int[6];
		rank = new int[6];
		
		for(int i=0; i<parents.length; i++) {
			makeSet(i);
		}
		//makeSet을 통해 자신의 부모가 자기자신으로 지정됨
		// 0 1 2 3 4 5
		System.out.println(Arrays.toString(parents));
		
		// 1이속한 집합의 대표자를 0이 속한 집합의 대표자로 변경
		union(0, 1);
		// 0 0 2 3 4 5 
		System.out.println(Arrays.toString(parents));
		
		union(2, 3);
		System.out.println(Arrays.toString(parents));
		//0 0 0 2 4 5 
		
		union(0, 3);
		System.out.println(Arrays.toString(parents));
		//0 0 0 2 4 4 
		
		union(4, 5);
		System.out.println(Arrays.toString(parents));
		//0 0 0 2 0 4
		
		union(2, 4);
		System.out.println(Arrays.toString(parents));

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
	
}
