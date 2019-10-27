import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_17822_원판돌리기 {

	static class Turn {
		int x;
		int d;
		int k;

		public Turn(int x, int d, int k) {
			this.x = x;
			this.d = d;
			this.k = k;
		}
	}

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int K;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static int flag = 0;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 원판의 수
		M = sc.nextInt(); // 원판에 적히는 수의 개수
		K = sc.nextInt(); // 회전 횟수
		map = new int[N + 1][M];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 회전할때마다의 정보를 담은 배열
		Turn[] TURN = new Turn[K + 1];
		for (int i = 1; i <= K; i++) {
			TURN[i] = new Turn(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		// 회전할때마다의 정보를 담은 배열 TURN (1~K)
		for (int SPIN = 1; SPIN <= K; SPIN++) {
			// 회전시키기
			for (int i = 1; i <= N; i++) {
				int X = TURN[SPIN].x;
				if (i % X != 0)
					continue;
				// row와 방향, 이동칸수가 파라미터로 들어감.
				spin(i, TURN[SPIN].d, TURN[SPIN].k);
			}
			// 회전한 결과를 탐색하다가 인접한게 있으면 제거. 없으면 평균질
			visited = new boolean[N + 1][M];
			// 인접한 숫자 처리 dfs
			flag = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j])
						continue;
					if (map[i][j] == 0)
						continue;
					int tmp = map[i][j];
					visited[i][j] = true;
					map[i][j] = 0;
					cnt = 0;
					int res = dfs(i, j, tmp);
					if (res < 2) {
						visited[i][j] = false;
						map[i][j] = tmp;
					} else {
						flag++;
					}
				}
			}
			if (flag < 1) {
				mean_process();
			}
		} // end
			// 최종 합 구하기
		System.out.println(getSum());
	}// end main

	static void spin(int x, int dir, int k) {
		int[] temp = new int[M];
		for (int i = 0; i < M; i++)
			temp = Arrays.copyOf(map[x], map[x].length);

		// 시계방향
		if (dir == 0) {
			for (int i = 0; i < M; i++) {
				if (i + k >= M)
					map[x][(i + k) % M] = temp[i];
				else
					map[x][i + k] = temp[i];
			}
		}
		// 반시계방향
		else {
			for (int i = 0; i < M; i++) {
				if (i + M - k >= M) {
					map[x][(i + M - k) % M] = temp[i];
				} else
					map[x][i + M - k] = temp[i];
			}
		}
	}// end spin

	static int dfs(int r, int c, int adj) {
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			// 배열범위를 벗어난다면 반대편을 확인해봐야함.
			if (nc >= M) {
				if (map[nr][nc % M] == adj) {
					map[nr][nc % M] = 0;
					visited[nr][nc % M] = true;
					dfs(nr, nc % M, adj);
				}
			}

			if(nc<0 ) {
				if (map[nr][M-1] == adj) {
					map[nr][M-1] = 0;
					visited[nr][M-1] = true;
					dfs(nr, M-1, adj);
				}
			}
			
			// 배열범위 체크
			if (nc<0 || nr<1 || nr > N || nc >= M)
				continue;

			// 방문체크
			if (visited[nr][nc])
				continue;

			if (map[nr][nc] == adj) {
				visited[nr][nc] = true;
				map[nr][nc] = 0;
				dfs(nr, nc, adj);
			}
		}
		return cnt;
	}

	static int getSum() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	static void mean_process() {

		int cnt = 0;
		int sum = 0;
		double mean;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;
				else {
					cnt++;
					sum += map[i][j];
				}
			}
		}

		// 모두 0이라는 것.
		if (cnt == 0)
			return;
		else {
			mean = sum / cnt;
			if (sum % cnt != 0) {
				mean += 0.5;
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						continue;
					if (map[i][j] > mean)
						map[i][j]--;
					else if (map[i][j] < mean)
						map[i][j]++;
				}
			}
		}
	}// end mean_process
}