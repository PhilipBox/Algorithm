package _solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class d4_최소스패닝트리_Kruskal {

	static class Node {
		int src;
		int dst;
		int cost;

		public Node(int src, int dst, int cost) {
			this.src = src;
			this.dst = dst;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "" + src + " , " + dst + " , " + cost;
		}
	}

	static class MyComp implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.cost - o2.cost;
		}
	}

	static ArrayList<Node> list = null;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			parents = new int[V+1];
			list = new ArrayList<Node>();
			for (int i = 0; i < E; i++) {
				Node node = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
				list.add(node);
			}

			MyComp mycomp = new MyComp();
			Collections.sort(list, mycomp);

			for (int i = 1; i <= V; i++) {
				parents[i] = i;
			}

			int cnt = 0;
			long total = 0;
			for (int i = 0; i < E; i++) {
				if (find(list.get(i).src) != find(list.get(i).dst)) {
					union(list.get(i).src, list.get(i).dst);
					total += list.get(i).cost;
					cnt++;
				} else
					continue;
				if (cnt == (V - 1))
					break;
			}
			System.out.println("#"+tc+" "+total);
		}
	}

	static int find(int x) {
		if (x == parents[x]) {
			return x;
		} else {
			parents[x] = find(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		parents[py] = px;
	}
}