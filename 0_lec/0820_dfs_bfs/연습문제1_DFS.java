import java.util.Scanner;
import java.util.Stack;

public class 연습문제1_DFS {
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
		boolean[] visited = new boolean[N+1];
		Stack<Integer> s = new Stack<>();
		
		//정점의 갯수 만큼 방문 배열을 준비한다.
		//정수 스택을 준비한다. (각 정점의 자료형이 인트)
		//첫번째 방문할 정점을 스택에 담는다.
//		s.push(1);
//		
//		//아래 작업을 스택이 빌때까지 반복하는게 dfs 
//		while(!s.empty()) {
//			//스택에서 pop해서, 방문하지 않았다면 
//			int v = s.pop();
//			if(visited[v]) 
//				continue;
//			//방문
//			System.out.print(v+" ");
//			//방문체크
//			visited[v] = true;
//			//해당 정점과 연결되어 있으면서, 방문하지 않은 정점이 있다면. 스택에 push
//			for(int i=1; i<= N; i++) {
//				if(!visited[i] && graph[v][i]==1){
//					s.push(i);
//				}
//			}//end for
//		}//end while
		dfs(graph, new boolean[N+1], 1);
		
	}//end main
	
	static Stack<Integer> stack = new Stack<>();
	static void dfs(int[][] matrix, boolean[] visited, int v) {
		// 방문.(출력)
		System.out.print(v+" ");
		// 방문체크
		visited[v] = true;
		// 나와 연결된 곳 중에서, 아직 방문 안한 곳이 있으면 방문
		for(int i=1; i<matrix.length; i++) {
			if(!visited[i] && matrix[v][i] == 1) {
				dfs(matrix,visited,i);
			}
		}
		
	}
	
	
	
	
	
	
	
}
