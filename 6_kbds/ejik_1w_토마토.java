// 백준 7576
// https://www.acmicpc.net/problem/7576
package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ejik_1w_토마토 {
	static int N;
	static int M;
	static int map[][];
	static boolean visited[][];

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<tomato> queue = new LinkedList<>();

	static class tomato {
		int r;
		int c;

		public tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int n = sc.nextInt();
				map[i][j] = n;
				
				// 처음 익은 토마토의 위치 add(start point)
				if (n == 1) {
					queue.add(new tomato(i, j));
				}
			}
		} // end for loop

		 bfs();

	}

	static void bfs() {
		int rst = 0;
		// 최소 날짜를 체크할 변수(answer)
		while (!queue.isEmpty()) {

			tomato tmt = queue.poll();
//			System.out.println(tmt.r +","+tmt.c);
			visited[tmt.r][tmt.c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = tmt.r + dr[i];
				int nc = tmt.c + dc[i];

				// 배열범위체크
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				else {
					// 토마토가 익지않고(0), 방문하지 않았던 곳(false)이라면
					if (map[nr][nc] == 0 && visited[nr][nc] == false) {
						
						visited[nr][nc] = true; // 방문체크
						queue.add(new tomato(nr, nc)); // 큐에 넣음
						map[nr][nc] = map[tmt.r][tmt.c] + 1; // 날짜기록
						rst = map[nr][nc]; // 결과값저장
					}
				}
			}
		} // end while

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					rst = -1;
				}
			} 
		}
		
		//모든 토마토가 썩었는뎅 -1을 해줘야함 
		if(rst>0)
			System.out.println(rst-1);
		else
			System.out.println(rst);
	}//end bfs

}
