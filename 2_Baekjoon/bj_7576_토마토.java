package _solving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7576_토마토 {
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<tomato> queue = new LinkedList<tomato>();

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
				// 처음시작할 지점 찾아서 queue에 넣어주기.
				if (n == 1) {
					queue.add(new tomato(i, j));
				}
			}
		}
		bfs();

	}// end main

	static void bfs() {
		// 날짜를 담을 결과 변수 
		int result = 0;
		
		while (!queue.isEmpty()) {
			//큐에서 꺼내고 방문체크 
			tomato tmt = queue.poll();
			visited[tmt.r][tmt.c] = true;

			// 꺼낸 토마토에 대해서
			// 4방체크
			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + tmt.r;
				int nc = dc[i] + tmt.c;

				// 배열범위 밖이면 빠끄 
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				else {
					// 토마토(0) 이고 방문하지 않았던(false) 곳이라면 
					if (map[nr][nc] == 0 && visited[nr][nc] == false) {
						// 방문체크를 한다 
						visited[nr][nc] = true;
						// 큐에 넣는다 
						queue.add(new tomato(nr, nc));
						// 방문할 지역에 날짜기록을 해둔다(+1) 
						map[nr][nc] = map[tmt.r][tmt.c] + 1;
						// 결과값에 저장해둔다. 
						result = map[nr][nc];
					}
				}
			} // end 4 direction check
		}//end while
		
		// bfs 탐색 후, 최종 결과 확인 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				// 토마토(0)가 하나라도 있으면 빠끄 
				if(map[i][j]==0)
					result = -1;
			}
		}

		//모든 토마토가 썩었는뎅 -1을 해줘야함 
		if(result>0)
			System.out.println(result-1);
		else
			System.out.println(result);
		
	}// end bfs
}
