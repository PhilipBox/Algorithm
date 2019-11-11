package _Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1194_달이차오른다가자 {
	static class POS {
		int r, c;
		int key;

		public POS(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.key = k;
		}
	}

	static int R;
	static int C;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C][1 << 6];
		// 민석이의 좌표
		int msR = 0;
		int msC = 0;
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					msR = i;
					msC = j;
				}
			}
		}
		System.out.println(bfs(msR,msC));
	}// end main

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int r, int c) {
		Queue<POS> queue = new LinkedList<POS>();
		// 시작 좌표와 key값(0)넣음. + 방문체크
		queue.add(new POS(r, c, 0));
		visited[r][c][0] = true;

		int move = 0;
		while (!queue.isEmpty()) {
			int qsize = queue.size();
			for (int q = 0; q < qsize; q++) {
				POS p = queue.poll();
				
				if (map[p.r][p.c] == '1') {
					return move;
				}

				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];
					int key = p.key;
					// 배열 범위 확인
					if (nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;

					// 벽이면 pass
					if (map[nr][nc] == '#')
						continue;
					
					// 방문했던 곳이면 pass
					if (visited[nr][nc][key])
						continue;
					
					// a와 f사이일때 (key 일때), 해당 bit를 1로 만들어준다.
					if ('a' <= map[nr][nc] && 'f' >= map[nr][nc]) {
						key |= (1 << map[nr][nc] - 'a');
					}

					// A와F사이일때(문 일때), key를 가지고 있는지 확인한다.
					// &(and) 연산을 해서 0이 나오면 없다는거야
					if ('A' <= map[nr][nc] && 'F' >= map[nr][nc]) {
						if ((key & (1 << (map[nr][nc] - 'A'))) == 0)
							continue;
					}
					visited[nr][nc][key] = true;
					queue.add(new POS(nr, nc, key));
				} // end 4 dir loop
			}
			move++;
		} // end while loop
		return -1;
	}//end bfs
}
/*
 * . : 빈 공간 (이동가능) # : 벽 (절대 이동 불가) a~f: 열쇠(이동가능) A~F: 문(열쇠가 있어야 이동 가능) 0 : 민식이의
 * 현재 위치(이동가능) 1 : 출구(미로탈출)
 */