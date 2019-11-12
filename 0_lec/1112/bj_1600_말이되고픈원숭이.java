package _1112;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_1600_말이되고픈원숭이 {
	static class Pos {
		int r, c, depth, K;

		Pos(int r, int c, int depth, int K) {
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.K = K; // 말처럼 움직인 횟수
		}
	}

	static int K;
	static int R;
	static int C;
	static int map[][];
	static boolean visited[][][]; // 세로 가로 말로이동한횟수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // K번 말처럼 이동가능
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken()); // 가로
		R = Integer.parseInt(st.nextToken()); // 세로
		/**
		 * 주의 해야할점: 0은 평지 1은 장애물
		 */
		map = new int[R][C];
		visited = new boolean[R][C][31];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(bfs());
	}

	// 말이 이동할 수 있는 위치(8방)
	static int hr[] = { -2, -1, 1, 2, 2, 1, -2, -1 };
	static int hc[] = { 1, 2, 2, 1, -1, -2, -1, -2 };
	// 일반 탐색(4방)
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static int bfs() {
		Queue<Pos> queue = new LinkedList<>();
		// 초기 위치 방문처리 + 큐에 넣기
		visited[0][0][0] = true;
		queue.add(new Pos(0, 0, 0, 0));

		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			// 도착지점 확인 : 맨 오른쪽 아래 지점 (R-1,C-1)
			if (p.r == R - 1 && p.c == C - 1) {
				return p.depth;
			}
			// 현재 좌표에서 말이 될 수 있는 기회가 있다면
			// 기회가 있어야만 말처럼 탐색(8방)이 가능함.
			if (p.K < K) {
				for (int i = 0; i < 8; i++) {
					int nr = p.r + hr[i];
					int nc = p.c + hc[i];

					// 배열범위 확인 + 장애물 확인 + 방문배열 확인
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != 1 && !visited[nr][nc][p.K + 1]) {
						visited[nr][nc][p.K + 1] = true;
						queue.add(new Pos(nr, nc, p.depth + 1, p.K + 1));
					}
				}
			}
			// 현재 좌표에서 말이 될 수 있는 기회가 있든 없든.
			// 4방탐색은 가능함.
			if (p.K <= K) {
				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != 1 && !visited[nr][nc][p.K]) {

						visited[nr][nc][p.K] = true;
						queue.add(new Pos(nr, nc, p.depth + 1, p.K));
					}
				}
			}
		}
		// R-1,C-1을 만나지 못하고 bfs가 끝나게 되면 -1 리턴(도달할 수 없음)
		return -1;
	}
}
