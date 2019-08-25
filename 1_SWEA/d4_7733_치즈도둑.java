package swea_d4_d5;

import java.util.Scanner;

public class d4_7733_치즈도둑 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int cnt;
	static int cnt_MAX=1;

	static int min = 999;
	static int max = 0;

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N + 2][N + 2];
			cnt_MAX = 1;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
					if (min > map[i][j])
						min = map[i][j];
					if (max < map[i][j])
						max = map[i][j];
				}
			}

			for (int day = min; day < max; day++) {
				visited = new boolean[N + 2][N + 2];
				// 하루씩 진행.
				// day이하 true
				for (int i = 0; i < N + 2; i++) {
					for (int j = 0; j < N + 2; j++) {
						if (map[i][j] <= day) {
							visited[i][j] = true;
						}
					}
				}
				cnt=0;
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						// false면 방문하지 않은 곳.
						if (!visited[i][j]) {
							cnt++;
							dfs(i, j);
						}
					}
				}
				if(cnt_MAX<cnt) {
					cnt_MAX = cnt;
				}
				
			} // end day loop
			System.out.println("#"+tc+" "+cnt_MAX);
		} // end test cases
	}// end main

	static void dfs(int r, int c) {
		// 방문했던 곳이면 빠끄
		if (visited[r][c]) {
			return;
		}

		// 방문했던곳이 아니면
		// 방문처리
		visited[r][c] = true;

		// 4방체크
		for (int i = 0; i < 4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			
			dfs(nr, nc);
		}

	}// end dfs

}
