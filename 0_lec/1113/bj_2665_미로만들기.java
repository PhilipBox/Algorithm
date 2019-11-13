package _1113;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2665_미로만들기 {
	static class POS {
		int r, c;
		int change;

		public POS(int r, int c, int change) {
			this.r = r;
			this.c = c;
			this.change = change;
		}
	}

	static int N;
	static int[][] map;
	static boolean[][][] visited;
	static int ans = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N][N * N];
		ans = 987654321;
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
		System.out.println(ans);
	}// end main

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		// 0은 검은 방 , 1은 흰방 
		// 0을 지운 경우를 생각해야 한다.
		
		Queue<POS> queue = new LinkedList<POS>();
		// 처음 위치 
		visited[0][0][0]= true;
		queue.add(new POS(0,0,0));
		
		while(!queue.isEmpty()) {
			// 큐에서 좌료플 뽑는다
			POS p = queue.poll();
			
			if(p.change > ans)
				continue;
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				//배열범위 확인
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				
				// 다음 좌표가 검정 문이면 뿌수고 가보고 
				if(map[nr][nc]==0) {
					// 뿌순놈이 갔던곳이면 의미 없음
					if(visited[nr][nc][p.change+1]) continue;
					visited[nr][nc][p.change+1] = true;
					queue.add(new POS(nr,nc,p.change+1));
				}
				// nr nc 가 벽이 아니면 그냥 보내고
				if(map[nr][nc]==1) {
					if(visited[nr][nc][p.change]) continue;
					visited[nr][nc][p.change] = true;
					if(nr == N-1 && nc == N-1) {
						ans = Math.min(ans, p.change);
						continue;
					}
					queue.add(new POS(nr,nc,p.change));
				}
			}
		}
	}
}
