import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_17472_다리만들기2 {
	// 1. 각 덩어리를 식별하기
	// 2. 각 덩어리간 경로 비용을 구하기
	// 3. MST

	// 1은 아직 검사 안된 영역 -> dfs가 첫 진입하는 지점을 이렇게 두니까, 여기서는 방문배열이 필요가 없겠지.
	// 0은 영역 아님.
	// 새로운 영역을 만날 때마다 번호를 매겨줄거임. 2부터..3..4..5..

	static int R; // 행
	static int C; // 열
	static int[][] map; // 맵

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				map[i][j] = sc.nextInt();
		}

		// 섬(영역)마다 넘버링하기.
		int idx = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1)
					dfs(i, j, idx++);
			}
		}

		// 인접행렬로 만들거니까, idx 6이라면 우리의 영역을 몇개? (5까지 만든거니까, 2,3,4,5로 총 4개)
		int[][] adj = new int[idx - 2][idx - 2];
		// 이제 영역같의 거리를 구해서 인접행렬에 적어줄 거야. (쌍노가다)

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 현현재 좌표가 영역 안에 있는 어떤 점이라면(육지의 어딘가라면)
				if (map[i][j] != 0) {
					// 해당육지에서 상하좌우로 바다가 있다면, 그 방향으로 바다가 아닐때까지
					// 계속 가봐서, 육지에 도달하면 내 육지번호에서 도달한 육지번호까지 거리를 인접행렬에 적어준다.
					// 거리가 2보다 작은건 무시. 이미 예전에 구한 거리가 있다면, 더 작은 것으로 기억할거야. (섬과 섬이 직사각형이 아니니까)

					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						// while문을 돈 횟수 (바다의 길이)
						int cnt = 0;
						int start = map[i][j] - 2;

						// 도달한 육지번호 담을 것.
						int dest = 0;

						// 일단, 지도 안에는 들어있어야 하고.
						while (isRange(nr, nc)) {
							// 지도 안에 있다면, 육지를 만날 때 까지 반복해야겠지.
							if (map[nr][nc] != 0) {
								// 발 디딘곳이 바다가 아니라면
								dest = map[nr][nc];
								break;
							}
							nr += dr[d];
							nc += dc[d];
							cnt++;
						}
						dest -= 2;
						if (dest != -2 && cnt > 1) {
							// 목적지가 육지이면서, 거리가 2 이상이라면

							if (adj[start][dest] > 0) {
								adj[start][dest] = Math.min(adj[start][dest], cnt);
								adj[dest][start] = adj[start][dest];
							} else {
								adj[start][dest] = cnt;
								adj[dest][start] = cnt;
							}
						}
					}
				}
			}
		}

//		//인접행렬을 출력해서 검사해보자
//		for(int i=0 ;i< idx-2; i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}

		boolean[] visited = new boolean[idx - 2];
		visited[0] = true;
		List<Integer> sel = new ArrayList<>();
		sel.add(0);
		int dist = 0;
		// 이미 확보된 영역으로부터 i로 가는 가장 작은 거리를 찾아서.
		while(true) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for(int node : sel) {
				for(int i=0; i< idx-2; i++) {
					if(adj[node][i] != 0 && !visited[i] && adj[node][i] < min) {
						min = adj[node][i];
						minIdx = i;
					}
				}
			}
			// 최소신장트리가 안만들어질수도있을때
			if(minIdx == -1) {
				dist = -1;
				break;
			}
			// 그 정점으로 다리를 놓는다.
			dist += min;
			sel.add(minIdx);
			visited[minIdx] = true;
			//연결된 정점의 갯수가 영역의 수 만큼 되면 최소신장 트리 완성
			if(sel.size() == idx-2)
				break;
		}

		System.out.println(dist);
	}// end main

	static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	// r,c로부터 출발해서 인접한 모든 1들을 idx로 변경시켜주는 작업
	static void dfs(int r, int c, int idx) {
		map[r][c] = idx;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isRange(nr, nc)) {
				if (map[nr][nc] == 1) {
					dfs(nr, nc, idx);
				}
			}
		} // end for loop
	}// end dfs

}
