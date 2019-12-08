package _solving;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	static class Node implements Comparable<Node> {
		int dest;
		int cost;

		public Node(int d, int c) {
			this.dest = d;
			this.cost = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

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
			}

			// 방문배열 생성
			boolean[] visited = new boolean[V+2];
			PriorityQueue<Node> queue = new PriorityQueue<>();
			// 0번 노드를 방문한거로 치고 0번으로부터 출발하는 모든 간선정보를 pq에 삽입.
			visited[1] = true;

			for (int i = 1; i < V; i++) {
				if (adj[1][i] != 0)
					queue.add(new Node(i, adj[1][i]));
			}

			long cnt = 0;
			long sum = 0;
			while (!queue.isEmpty()) {
				if (cnt == V)
					break;

				Node node = queue.poll();
				if (visited[node.dest])
					continue;

				// 방문한적이 없으면 가중치를 누적합하고 해당 정점을 방문체크,
				// 그리고 그 정점으로 출발하는 모든 간선 큐에 삽입.
				sum += node.cost;
				for (int i = 0; i <= V; i++) {
					if (adj[node.dest][i] != 0)
						queue.add(new Node(i, adj[node.dest][i]));
				}
				visited[node.dest] = true;
				cnt++;
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
