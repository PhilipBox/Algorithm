import java.util.Arrays;
import java.util.Scanner;

public class 다익스트라 {

	static String src = "7 11\n" + "0 1 31\n" + "0 2 31\n" + "0 6 31\n" + "0 5 60\n" + "1 2 21\n" + "2 4 46\n"
			+ "2 6 25\n" + "3 4 34\n" + "4 6 51\n" + "5 3 18\n" + "5 4 40\n";

	static String src2 = "6 11\r\n" + "0 1 3\r\n" + "0 2 5\r\n" + "1 2 2\r\n" + "1 3 6\r\n" + "2 1 1\r\n" + "2 4 6\r\n"
			+ "2 3 4\r\n" + "3 4 2\r\n" + "3 5 3\r\n" + "4 0 3\r\n" + "4 5 6";

	static int[][] adj;
	static final int M = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(src2);

		int V = sc.nextInt();
		int E = sc.nextInt();

		adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a][b] = c;
		}

		// 거리를 저장할 배열, 정점의 개수만큼 필요
		int[] dist = new int[V];
		// 이미 처리가 됐는지 확인
		boolean[] visited = new boolean[V];

		// 0번을 시작점으로 할거임.
		// 0번 방문배열에 체크를 하고
		visited[0] = true;

		// dist에는 0번에서 도달할 수 없는 정점은 큰 정수값을, 있는 곳은 0번부터의 거리를 적어주자.
		for (int i = 1; i < V; i++) {
			if (adj[0][i] == 0)
				dist[i] = M;
			else
				dist[i] = adj[0][i];
		}

		// 남은 V-1개의 정점에 대해서 반복하며
		// 가장 dist가 작은 녀석을 골라서(아직 안고른것중에)
		// 고른 놈으로부터 갈 수 있는 새로운 거리들 중 더 작은 값은 갱신
		for (int i = 0; i < V - 1; i++) {
			// 방문하지 않은 녀석 중 가장 dist가 짧은 놈을 고르자.
			int minIdx = -1;
			int min = M;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[i] < min) {
					min = dist[j];
					minIdx = j;
				}
			}
			
			// 모든 노드를 검사하면서, minIdx번째 노드로부터 갈 수 있는 곳이라면,
			// 그 노드로 가는 현재까지 알던 dist와 minIdx까지 가는 dist + minIdx로부터 그 노드로 가는 거리 중 작은 값을 dist에 갱신
			for(int j=0; j<V; j++) {
				//길이 있으면서 -> adj[minIdx][j] != 0
				//내가 알고있던 j까지의 거리보다, minIdx를 거쳐 j로 가는 거리가 짧다면, -> dist[j] > dist[minIdx]+adj[minIdx][j]
				if(adj[minIdx][j] != 0 && dist[j] > dist[minIdx] + adj[minIdx][j] ) {
					dist[j] = dist[minIdx] + adj[minIdx][j];
				}
				visited[minIdx]=true;
				System.out.println(Arrays.toString(dist));
			}
			
			
		}//end i loop

	}// end main
}
