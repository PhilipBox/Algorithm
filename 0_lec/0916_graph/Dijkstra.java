package _solving;

public class Dijkstra {
	static final int N = 6;
	static int M = Integer.MAX_VALUE;
	static int[][] adj = {
			{0,3,5,M,M,M,}
			,{M,0,2,6,M,M}
			,{M,1,0,4,6,M}
			,{M,M,M,0,2,3}
			,{3,M,M,M,0,6}
			,{M,M,M,M,M,0}
	};
	
	static boolean[] visited = new boolean[N];
	static int[] dist = new int[N];
	
	public static void main(String[] args) {
		
		dijkstra(0);
		for(int i=0; i<N; i++) {
			System.out.println(dist[i]);
		}
	}
	
	//가장 최소 거리를 가지는 정점을 반환
	static int getSmallIndex() {
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for(int i=0; i<N; i++) {
			if( !visited[i] && dist[i] < min) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}//end getSmallIndex method
	
	static void dijkstra(int start) {
		for(int i=0; i<N; i++) {
			//시작점에서 출발했을 때,모든 경로의 cost
			dist[i] = adj[start][i];
		}
		
		//시작점 방문처리 
		visited[start] = true;
		
		for(int i=0; i<N-2; i++) {
			//현재 방문하지 않은 node 중에서, 빠르게 도착할 수 있는
			//즉 최소 cost를 가지는 index를 가져옴.
			int curr = getSmallIndex();
			//가져온 index를 방문처리 
			visited[curr] = true;
			
			//위 노드와 인접한 노드들을 모두 확인 
			for(int j=0; j<N; j++) {
				// 인접 노드 중, 방문하지 않은 곳이 있다면 
				if(!visited[j] && adj[curr][j] != M && dist[j]> dist[curr]+adj[curr][j]) {
						dist[j] = dist[curr] + adj[curr][j];
				}
			}
		}
	}
}
