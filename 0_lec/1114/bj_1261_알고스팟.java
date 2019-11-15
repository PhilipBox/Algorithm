package _1114;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj_1261_알고스팟 {
	static class POS implements Comparable<POS>{
		int r, c;
		int door;

		public POS(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.door = d;
		}
		@Override
		public int compareTo(POS o) {
			return door - o.door;
		}
	}

	static int R;
	static int C;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] visited;

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		ans = 987654321;
		map = new int[R][C];
		visited = new int[R][C];
		// 0빈방
		// 1문
		// 0,0이랑 R-1,C-1는 항상 0
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
			Arrays.fill(visited[i], -1);
		}
		bfs();
		System.out.println(ans);
	}// end main

	static void bfs() {
		PriorityQueue<POS> queue = new PriorityQueue<POS>();
		// 시작좌표 방문처리 및 큐에 넣기
		visited[0][0] = 0;
		queue.add(new POS(0, 0, 0));

		while (!queue.isEmpty()) {
			POS p = queue.poll();
			// 4방탐색
			if(p.r== R-1 && p.c == C-1) {
				ans = visited[R-1][C-1];
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				// 배열범위 초과
				if (nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;

				// 가려는 곳이 1(벽)이면 부수고 가기.
				if (map[nr][nc] == 1) {
					// 처음오는 곳이라면
					if (visited[nr][nc] < 0) {
						visited[nr][nc] = p.door + 1;
						queue.add(new POS(nr, nc, p.door + 1));
					} else {
						// 이미 왔던곳인데 이미 내가 들고있는게 더 많아
						if (p.door + 1 >= visited[nr][nc])
							continue;
						else {
							visited[nr][nc] = p.door + 1;
							queue.add(new POS(nr, nc, p.door + 1));
						}
					}
				} else {
//					// 도착지 체크
//					if (nr == R-1 && nc == C-1) {
//						ans = Math.min(ans, p.door);
//						continue;
//					}
					//벽이 아니라면 
					//처음오는 곳이라면 
					if(visited[nr][nc]<0) {
						visited[nr][nc]=p.door;
						queue.add(new POS(nr,nc,p.door));
						continue;
					}
					// 다음에 갈곳이랑 문을 뿌순 횟수가 같으면 갈 필요가 없지
					if(p.door >= visited[nr][nc])
						continue;
					else {
						//지금 문을 뿌순 횟수가 더 작다면
						visited[nr][nc] = p.door;
						queue.add(new POS(nr,nc,p.door));
					}
				}
			}
		} // end while
	}// end bfs
}