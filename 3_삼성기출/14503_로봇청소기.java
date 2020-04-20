package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj_14503_로봇청소기 {
	static int count = 1, N, M;
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 }; // N, E, S, W
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(startX, startY, direction);
		bw.write(count + "");
		bw.flush();
	}

	// 1.4방향을 돌며 청소 가능한 곳을 탐색해 다시 dfs()를 호출한다.
	// 2.4방향 청소가 끝나면 후진한다.
	// 3.후진이 불가능하면 return 한다.
	private static void dfs(int x, int y, int d) {
		map[x][y] = 2;
		int posX, posY;
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			posX = x + dx[d];
			posY = y + dy[d];

			if (posX >= 0 && posX < N && posY >= 0 && posY < M && map[posX][posY] == 0) {
				// 왼쪽이 청소 가능한 경우,
				count++;
				dfs(posX, posY, d);
				return;
			}
		}

		// 후진
		int back = (d + 2) % 4;
		posX = x + dx[back];
		posY = y + dy[back];
		if (posX >= 0 && posX < N && posY >= 0 && posY < M && map[posX][posY] != 1) {
			dfs(x + dx[back], y + dy[back], d);
		}
	}
}
