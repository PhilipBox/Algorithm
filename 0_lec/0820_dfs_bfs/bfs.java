import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int V = sc.nextInt();
		int [][] graph = new int[N+1][N+1];
		
		for(int i=0; i<V; i++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			graph[s][d] = 1;
			graph[d][s] = 1;
		}
		//큐와 방문배열을 준비.
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		// 처음 방문할 정점을 큐에 삽입하고. 방문체크.
		queue.add(1);
		visited[1]=true;
		
		//아래 작업을 큐가 빌때까지 반복
		
		while(!queue.isEmpty()) {
			//큐에서 하나 꺼내서 방문 후
			int v = queue.poll();
			System.out.print(v+" ");
			
			// 해당 노드와 영결되어 있는 노드 중 아직 방문하지 않은 노드를 큐에 삽입.
			for(int i=1; i<=N; i++) {
				if(!visited[i] && graph[v][i]==1) {
					queue.add(i);
					visited[i] =true;
				}
			}
			
		}//end while
	}
	
	static void bfs(int[][] matrix, boolean[] visited, int v) {
		
		
		
		
		
		
	}
	
	
}
