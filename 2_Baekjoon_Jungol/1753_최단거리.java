import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_1753_최단거리 {
	static class Node implements Comparable<Node>{
		int dest;
		int cost;
		public Node(int d, int c) {
			this.dest = d;
			this.cost = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int V;
	static int E;
	static int start;
	static int[] dist;
	static boolean[] visited;
	static int M = Integer.MAX_VALUE;
	static ArrayList<Node>[] adj;
	static PriorityQueue<Node> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		start = sc.nextInt();
		
		//인접행렬 생성-
		adj = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		//간선의 수 만큼 입력 
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a].add(new Node(b,c));
		}
		
		visited = new boolean[V+1];
		dist = new int[V+1];
		pq = new PriorityQueue<Node>();
		
		Arrays.fill(dist, M);
		dijkstra(start);
		
		for(int i=1; i<=V; i++) {
			if(dist[i] == M)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
	
	static void dijkstra(int src) {
		dist[src] = 0;
		pq.add(new Node(src,0));
		
		while(!pq.isEmpty()) {
			
			int curr = pq.poll().dest;
			if(visited[curr]) continue;
			
				for(int j=0; j<adj[curr].size(); j++) {
					if(dist[adj[curr].get(j).dest] > dist[curr] + adj[curr].get(j).cost) {
						dist[adj[curr].get(j).dest] =  dist[curr] + adj[curr].get(j).cost;
						pq.add(new Node(adj[curr].get(j).dest, dist[adj[curr].get(j).dest]));
					}
				}
			visited[curr]=true;
		}
	}
	
	
	
	
}
