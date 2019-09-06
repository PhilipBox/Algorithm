import java.util.Scanner;

public class bj_17144_미세먼지안녕 {

	static class Cleaner {
		int r, c;

		public Cleaner(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	// 공기청정기 위치
	static Cleaner[] cleaner_pos = new Cleaner[2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		map = new int[R][C];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					cleaner_pos[idx++] = new Cleaner(i, j);
				}
			}
		}

		for (int i = 0; i < T; i++) {
			// 미세먼지 전파
			speardDust(new int[R][C]);
			// 공기청정기 순환
			Wind(new int[R][C]);
		}

		dustCnt();
		// 정답 도출

	}// end main

	static void speardDust(int[][] copy) {
		// copy는 해당 좌표에 대해서 미세먼지 변화량만을 기록할 좌표

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copy[i][j] += map[i][j];

				// 5보다 작으면 전파되는게 없음.
				if (map[i][j] < 5)
					continue;

				int spreadCnt = map[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					// 퍼트릴 수 있는 위치인지 확인
//					if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == -1)
//						continue;
//					copy[i][j] -= speardCnt;
//					copy[nr][nc] += speardCnt;
					if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
						copy[i][j] -= spreadCnt;
						copy[nr][nc] += spreadCnt;
					}

				}
			}
		}
		// 미세먼지 변화량을 원본 맵에 복사하는 과정
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}// end spreadDust method

	static void Wind(int[][] copy) {
		for (int idx = 0; idx < 2; idx++) {
			Cleaner cleaner = cleaner_pos[idx];
			int nr = cleaner.r;
			int nc = cleaner.c + 1;

			// 오른쪽으로 끝까지.
			while (nc < C - 1) {
				copy[nr][nc + 1] = map[nr][nc];
				nc++;
			}

			// 상 or 하로 끝까지.
			if (idx == 0) {
				while (nr > 0) {
					copy[nr - 1][nc] = map[nr][nc];
					nr--;
				}
			} else {
				while (nr < R - 1) {
					copy[nr + 1][nc] = map[nr][nc];
					nr++;
				}
			}

			// 왼쪽으로 끝까지.
			while (nc > 0) {
				copy[nr][nc - 1] = map[nr][nc];
				nc--;
			}

			// 공기청정기 위치 전까지.
			if (idx == 0) {
				while (nr < cleaner.r - 1) {
					copy[nr + 1][nc] = map[nr][nc];
					nr++;
				}
			} else {
				while (nr > cleaner.r + 1) {
					copy[nr - 1][nc] = map[nr][nc];
					nr--;
				}
			}
		}

		// 이동한거 원본으로 복사
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || i == R - 1 || j == 0 || j == C - 1 || i == cleaner_pos[0].r || i == cleaner_pos[1].r) {
					map[i][j] = copy[i][j];
				}
			}
		}

		map[cleaner_pos[0].r][cleaner_pos[0].c] = -1;
		map[cleaner_pos[1].r][cleaner_pos[1].c] = -1;
	}// end Wind

	static void dustCnt() {
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0)
					continue;
				cnt += map[i][j];
			}
		}
		System.out.println(cnt);
	}

}
