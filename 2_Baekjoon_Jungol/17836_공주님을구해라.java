package _1113;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_17836_공주님을구해라 {
	static class POS {
		int r, c;
		int time;
		boolean sword;

		public POS(int r, int c, int t, boolean s) {
			this.r = r;
			this.c = c;
			this.time = t;
			this.sword = s;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static boolean visited[][][];
	static int T;
	static String fail = "Fail";
	static int ans;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();
		ans = 987654321;
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
		if(ans == 987654321)
			System.out.println(fail);
		else
			System.out.println(ans);
	}// end main

	static void bfs() {
		Queue<POS> queue = new LinkedList<POS>();
		// 시작 위치 추가 및 방문처리
		// 시작부터 검이 있다면
		if (map[1][1] == 2) {
			visited[1][1][1] = true;
			queue.add(new POS(1, 1, 0, true));
		} else {
			visited[1][1][0] = true;
			queue.add(new POS(1, 1, 0, false));
		}
		while (!queue.isEmpty()) {
			POS p = queue.poll();
			if(p.time >= T)
				return;
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				// 배열범위 확인
				if (nr < 1 || nc < 1 || nr > N || nc > M)
					continue;

				// 무기가 X
				if (!p.sword) {
					// 벽으로 막혀있거나, 방문했던곳이라면 pass
					if (map[nr][nc] == 1 || visited[nr][nc][0])
						continue;
					// 최종 목적지라면 
					if(nr == N && nc == M) {
						ans = p.time+1;
						return;
					}
					
					//다음 칸으로 이동 + 검이 있는지 확인
					if (map[nr][nc] == 2) {
						visited[nr][nc][0]=true;
						visited[nr][nc][1]=true;
						queue.add(new POS(nr,nc,p.time+1, true));
					}else {
						visited[nr][nc][0]=true;
						queue.add(new POS(nr,nc,p.time+1, false));
					}
				}
				// 무기가 O
				else {
					// 검을 들고 왔던 곳이라면 pass
					if(visited[nr][nc][1]) continue;
					// 최종 목적지라면 
					if(nr == N && nc == M) {
						ans = p.time+1;
						return;
					}
					visited[nr][nc][1]=true;
					queue.add(new POS(nr,nc,p.time+1, true));
				}
			}
		} // end while loop
	}
}
