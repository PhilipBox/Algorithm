package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178_미로탐색 {
	static class POS {
		int r;
		int c;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(map[N-1][M-1]);
	}

	public static void bfs() {
		Queue<POS> queue = new LinkedList<>(); // 큐 생성
		queue.add(new POS(0, 0)); // 시작 좌표 입력
		visited[0][0] = true; // 시작지점 방문처리

		while (!queue.isEmpty()) {
			POS pos = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = pos.r + dr[i];
				int nc = pos.c + dc[i];

				// 배열범위 조건
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				
				// 이동할 수 있는 칸이고, 방문하지 않았다면.
				if (map[nr][nc] != 0 && !visited[nr][nc]) {
					queue.add(new POS(nr, nc)); // 큐에 다음 좌표 추가 
					map[nr][nc]=map[pos.r][pos.c]+1; // 다음좌표에 이전좌표값 +1
					visited[nr][nc] = true; // 방문처리
				}
			}

		}

	}

}
