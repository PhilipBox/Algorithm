import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_2117_홈방범서비스 {
	static class POS {
		int r, c;
		int depth;

		public POS(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}
	}
	static int N;
	static int M;
	static int[][] map;
	static int totalHome;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			totalHome = 0;
			ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1)
						totalHome++;
				}
			}
			// 모든 자리에서 bfs 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 현재좌표 넣어서 bfs
					bfs(i, j, new boolean[N][N], 1);
				}
			}
			System.out.println("#" + tc + " " + ans);
			// 결과 출력
		} // end test cases
	}// end main
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans = 0;
	static void bfs(int r, int c, boolean[][] visited, int depth) {
		Queue<POS> queue = new LinkedList<POS>();
		int max = 0;
		// 현재 위치, 깊이, 서비스 영역 수, 현재 서비스하는 집의 수 + 방문처리
		if (map[r][c] == 1) {
			ans = Math.max(ans, 1);
			max++;
		}
		visited[r][c]=true;
		queue.add(new POS(r, c, depth));

		int dep = 1;
		while (!queue.isEmpty()) {
			int qsize = queue.size();
			for (int s = 0; s < qsize; s++) {
				POS p = queue.poll();
				dep = p.depth;
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					// 배열범위 초과
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					// 방문배열 재방문 체크
					if (visited[nr][nc])
						continue;
					// 집이 있다면
					if (map[nr][nc] == 1) {
						max++;
						visited[nr][nc] = true;
						queue.add(new POS(nr, nc, p.depth + 1));
					}
					// 그냥 공간
					else {
						visited[nr][nc] = true;
						queue.add(new POS(nr, nc, p.depth + 1));
					}
				}
			} // 현재 depth에서 모두 돌고난 뒤.
			int cost = M *max;
			if (range(dep + 1) <= cost)
				ans = Math.max(ans, max);
		} // end whil loop
	}
	static int range(int n) {
		return (n * n) + ((n - 1) * (n - 1));
	}
}