import java.util.PriorityQueue;
import java.util.Scanner;
public class jungol_1113_119구급대 {
	static class POS implements Comparable<POS> {
		int r, c;
		int dir;
		int ccnt;
		public POS(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.ccnt = cnt;
		}
		@Override
		public int compareTo(POS o) {
			return this.ccnt - o.ccnt;
		}
	}
	static int M;
	static int N;
	static int desR;
	static int desC;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];
		desR = sc.nextInt();
		desC = sc.nextInt();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
	}// end main
	// 상 하 좌 우
	// 0 1 2 3
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static void bfs() {
		PriorityQueue<POS> queue = new PriorityQueue<>();
		visited[0][0] = true;
		queue.add(new POS(0, 0, -1, -1));
		while (!queue.isEmpty()) {
			POS p = queue.poll();
			// 다음 방문할 4방탐색
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				// 배열범위초과
				if (nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;
				// 막혀있는 곳
				if (map[nr][nc] == 0)
					continue;
				// 방문했던 곳
				if (visited[nr][nc])
					continue;

				// 현재 진행방향과 같다면
				if (p.dir == i) {
					if (nr == desR && nc == desC) {
						System.out.println(p.ccnt);
						return;
					}
					visited[nr][nc] = true;
					queue.add(new POS(nr, nc, i, p.ccnt));
				} else {
					if (nr == desR && nc == desC) {
						System.out.println(p.ccnt + 1);
						return;
					}
					visited[nr][nc] = true;
					queue.add(new POS(nr, nc, i, p.ccnt + 1));
				}
			} // end 4방탐색
		} // end while loop
	}//end bfs method
}