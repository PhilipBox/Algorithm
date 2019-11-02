import java.util.ArrayList;
import java.util.Scanner;

public class swea_등산로조성 {
	static class POS {
		int r;
		int c;
		int cnt;
		int chance;

		public POS(int r, int c, int chance, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.chance = chance;
		}
	}

	static int N;
	static int K;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int ans;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}

			ArrayList<POS> startlist = new ArrayList<POS>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						startlist.add(new POS(i, j, 1, 1));
					}
				}
			}

			for (int i = 0; i < startlist.size(); i++) {
				visited[startlist.get(i).r][startlist.get(i).c]=true;
				dfs(startlist.get(i));
				visited[startlist.get(i).r][startlist.get(i).c]=false;
			}
			System.out.println("#" + tc + " " + ans);
		} // end test cases
	}// end main

	static void dfs(POS p) {
		ans = Math.max(ans, p.cnt);
		for(int i=0; i<4; i++) {
			int nr = p.r + dr[i];
			int nc = p.c + dc[i];
			if(nr<0 || nc <0 || nr >= N || nc>=N) continue;
			if(visited[nr][nc])continue;
			if(map[p.r][p.c] > map[nr][nc]) {
				visited[nr][nc]=true;
				dfs(new POS(nr,nc,p.chance, p.cnt+1));
				visited[nr][nc]=false;
			}
			if(p.chance ==1) {
				for(int h=1; h<=K; h++) {
					if(map[p.r][p.c]>map[nr][nc]-h) {
						int origin = map[nr][nc];
						map[nr][nc] = map[nr][nc]-h;
						visited[nr][nc]=true;
						dfs(new POS(nr,nc,0,p.cnt+1));
						map[nr][nc]=origin;
						visited[nr][nc]=false;
					}
				}
			}
		}//end for
	}//end dfs
}