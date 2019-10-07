import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class d4_1249_보급로 {
	static class POS {
		int r;
		int c;
		int cost;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	static int[][] map;
	static int[][] cost;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static Queue<POS> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			cost = new int[N][N];
			visited = new boolean[N][N];
			queue = new LinkedList<POS>();
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			visited[0][0]=true;
			queue.add(new POS(0,0));
			while(!queue.isEmpty()) {
				POS p = queue.poll();
				for(int i=0; i<4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					
					if(isRange(nr, nc)) {
						if(!visited[nr][nc]) {
							cost[nr][nc] = cost[p.r][p.c] + map[nr][nc];
							visited[nr][nc]=true;
							queue.add(new POS(nr,nc));
						}
						if(cost[nr][nc] > cost[p.r][p.c]+map[nr][nc]) {
							cost[nr][nc] = cost[p.r][p.c] + map[nr][nc];
							queue.add(new POS(nr,nc));
						}
					}
					else 
						continue;
				}	
			}//end while
			System.out.println("#"+tc+" "+cost[N-1][N-1]);
		} // end test cases
	}// end main

	static boolean isRange(int r, int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
}
