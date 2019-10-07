import java.util.Scanner;

public class bj_4963_섬의개수 {

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static int R;
	static int C;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			C = sc.nextInt();
			R = sc.nextInt();
			if (R == 0 || C == 0)
				break;

			map = new int[R][C];
			visited = new boolean[R][C];
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						if (visited[i][j]) 
							continue;
						visited[i][j] = true;
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		} // end while
	}// end main

	static boolean isRange(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

	static void dfs(int r, int c) {
		// 8방 체크
		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 배열 범위 체크
			if (isRange(nr, nc)) {
				// 방문했던 곳이면 pass
				if (map[nr][nc]==0) continue;
				if (visited[nr][nc])
					continue;
				// 방문 체크
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		} // end 8방체크 for loop
	}// end dfs
}