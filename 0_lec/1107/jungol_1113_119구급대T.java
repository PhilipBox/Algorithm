import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class jungol_1113_119구급대T {
	static class POS implements Comparable<POS> {
		int r, c;
		int dir;
		int cnt;

		public POS(int r, int c, int dir, int cnt) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(POS o) {
			return this.cnt - o.cnt;
		}
	}

	static int N, M;
	static int desR, desC;
	static int[][] map;
	static int[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		desR = sc.nextInt();
		desC = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		}
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], 987654321);

		PriorityQueue<POS> queue = new PriorityQueue<>();
		visited[0][0] = 0;
		queue.add(new POS(0, 0, 1, 0));
		queue.add(new POS(0, 0, 3, 0));
		while (!queue.isEmpty()) {
			POS p = queue.poll();
			if (p.r == desR && p.c == desC) {
				System.out.println(p.cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if(map[nr][nc]==1 && visited[nr][nc] > p.cnt) {
					int cnt = p.cnt;
					if( i != p.dir)
						cnt++;
					visited[nr][nc] = p.cnt;
					queue.add(new POS(nr,nc,i,cnt));
				}
			}//end 4방 탐색
		}//end while loop
	}
}