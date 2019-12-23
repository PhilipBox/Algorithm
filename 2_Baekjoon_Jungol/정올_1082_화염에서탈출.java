import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 화염에서탈출 {

	static class POS {
		int r;
		int c;
		int cnt;

		public POS(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R;
	static int C;
	static int desR;
	static int desC;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static Queue<POS> fire;
	static Queue<POS> queue;

	static int res;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 2][C + 2];
		visited = new boolean[R + 2][C + 2];

		queue = new LinkedList<POS>();
		fire = new LinkedList<POS>();

		bound();
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j + 1] = str.charAt(j);
				// 시작점 좌표
				if (map[i][j + 1] == 'S') {
					queue.add(new POS(i, j + 1, 0));
					visited[i][j + 1] = true;
				}
				if (map[i][j + 1] == 'D') {
					desR = i;
					desC = j + 1;
				}
				if (map[i][j + 1] == '*')
					fire.add(new POS(i, j + 1));
			}
		} // end for loop

		BFS();
		if(res ==0)
			System.out.println("impossible");
		else
			System.out.println(res);
	}// end main

	static void BFS() {
		while (!queue.isEmpty()) {
			int size = queue.size();

			fire();

			for (int s = 0; s < size; s++) {
				POS pos = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nr = pos.r + dr[i];
					int nc = pos.c + dc[i];

					// 갈수있는 곳이고, 방문하지 않았던 곳이라면
					if (!visited[nr][nc] && map[nr][nc] == 'D') {
						res = pos.cnt + 1;
						return;
					}
					if (!visited[nr][nc] && map[nr][nc] == '.') {
						// 방문처리 해주고
						visited[nr][nc] = true;
						map[nr][nc] = 'S';
						queue.add(new POS(nr, nc, pos.cnt + 1));
					}
				}
			}
		}
	}// end BFS

	static void fire() {
		int size = fire.size();
		for (int i = 0; i < size; i++) {
			POS f = fire.poll();

			for (int j = 0; j < 4; j++) {
				int nr = f.r + dr[j];
				int nc = f.c + dc[j];

				if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
					map[nr][nc] = '*';
					fire.add(new POS(nr, nc));
				}
			}
		}
	}// end fire

	static void bound() {
		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				if (i == 0 || i == R + 1 || j == 0 || j == C + 1) {
					map[i][j] = 'X';
					visited[i][j] = true;
				} else
					continue;
			}
		}
	}// end bound method

	static void print() {
		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}// end print

}
