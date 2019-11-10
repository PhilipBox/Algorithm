import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_1953_탈주범검거 {
	static class POS {
		int r, c;
		int dir;
		int t;
		public POS(int r, int c, int d, int t) {
			this.r = r;
			this.c = c;
			this.dir = d;
			this.t = t;
		}
	}

	static int R;
	static int C;
	static int time;
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			int srcR = sc.nextInt();
			int srcC = sc.nextInt();
			time = sc.nextInt();
			map = new int[R][C];
			visited = new boolean[R][C];
			ans = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			bfs(srcR, srcC);
			for(int i=0 ;i<R; i++) {
				for (int j =0; j<C; j++) {
					if(visited[i][j]) ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		} // end test cases
	}// end main

	static void bfs(int srcR, int srcC) {
		Queue<POS> queue = new LinkedList<POS>();
		visited[srcR][srcC] = true;
		queue.add(new POS(srcR, srcC, map[srcR][srcC], 1));
		while (!queue.isEmpty()) {
			POS p = queue.poll();
			if(p.t >= time) {
				return;
			}
			
//			System.out.println(p.r +"," + p.c +" / " + p.dir + " : " + p.t);
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
				if (map[nr][nc]==0) continue;
				if(visited[nr][nc]) continue;
				
				// 각 파이프에 맞는 파이프가 다음 칸에도 연결이 되어 있어야 한다.
				if(p.dir==1) {
					// i == 0일때 , 3,4,7 안됨.
					// i == 1일때, 3,5,6  안됨.
					// i == 2일때, 2,6,7 안됨.
					// i == 3일때, 2,4,5 안됨.
					if(i==0) {
						if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
					}
					else if(i==1) {
						if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
					}
					else if(i==2) {
						if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
					}
					else if(i==3) {
						if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
					}
				}
				else if(p.dir==2) {
					if(i==2 || i==3) continue;
					// i == 0일때, 3,4,7 안됨.
					if(i==0) {
						if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
					}
					// i == 1일때, 3,5,6 안됨.
					else if(i==1) {
						if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
					}
				}
				else if(p.dir==3) {
					if(i==0 || i==1) continue;
					// i == 2일때, 2,6,7 안됨.
					if(i==2) {
						if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
					}
					// i == 3일때, 2,4,5 안됨.
					else if(i==3) {
						if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
					}
				}
				else if(p.dir==4) {
					if(i==1 || i==2) continue;
					// i == 0일때,
					if(i==0) {
						if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
					}
					// i == 3일때,
					else if(i==3) {
						if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
					}
				}
				else if(p.dir==5) {
					if(i==0 || i==2) continue;
					// i == 1일때,
					if(i==1) {
						if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
					}
					// i == 3일때,
					else if(i==3) {
						if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
					}
				}
				else if(p.dir==6) {
					if(i==0 || i==3) continue;
					// i == 1일때,
					if(i==1) {
						if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
					}
					// i == 2일때,
					else if(i==2) {
						if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
					}
				}
				else if(p.dir==7) {
					if(i==1 || i==3) continue;
					// i == 0일때,
					if(i==0) {
						if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
					}
					// i == 2일때,
					else if(i==2) {
						if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
					}
				}
				// 방문했던곳도 pass
				// 0도 pass
				// 각 파이프에 맞는 조건도 pass
				visited[nr][nc]=true;
				queue.add(new POS(nr,nc,map[nr][nc] , p.t+1));
			}
		} // end while loop
	}//end bfs
}
