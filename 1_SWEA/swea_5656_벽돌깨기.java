import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_5656_벽돌깨기 {

	static class Pos {
		int r;
		int c;
		int bomb;

		public Pos(int r, int c, int b) {
			this.r = r;
			this.c = c;
			this.bomb = b;
		}
	}// end Pos class

	static int R;
	static int C;
	static int N;
	static int[][] map;
	static int[][] map_origin;
	static int res=987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			C = sc.nextInt();
			R = sc.nextInt();
			map_origin = new int[R][C];
			map = new int[R][C];
			res = 987654321;
			// 초기 벽돌 상태 입력
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map_origin[i][j] = sc.nextInt();
				}
			}
			// C의 개수 중에서 N개를 뽑는 중복순열
			reperm(new int[N], 0);
			System.out.println("#"+tc+" "+res);
		} // end test cases
	}// end main

	static void reperm(int[] sel, int idx) {
		if (idx == sel.length) {
			// C개중에서 N개를 모두 뽑은 경우 .
			// 벽돌 놓기 시작.
			// top 과 map 복사
			copy();

			for (int i = 0; i < sel.length; i++) {
				bfs(sel[i]);
				//top 위에있는 빈칸 아래로 내리기. 
				moveBlock(); 
			}
		
			// 최종 남은 벽돌 확인.
			int blockCheck = remainBlock();
			// 최저 벽돌 수 비교
			res = Math.min(res, blockCheck);
			return;
		}

		for (int i = 0; i < C; i++) {
			sel[idx] = i;
			reperm(sel, idx + 1);
		}
	}// end reperm method

	static int remainBlock() {
		int blockCnt=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!=0) blockCnt++;
			}
		}
		return blockCnt;
	}//end remainBlock method
	
	
	static void moveBlock() {
		for(int i=0; i<C; i++) {
			int[] blocks = new int[R];
			int cnt=0;
			for(int j=0; j<R; j++) {
				if(map[j][i]!=0) {
					blocks[cnt++]=map[j][i];
				}
			}
			for(int j=R-1; j>=0; j--) {
				if(cnt>0) {
					map[j][i] = blocks[--cnt];
				}
				else map[j][i] =0;
			}
		}//end col loop
	}//end moveBlock method
	
	
	static int findStartPoint(int sel) {
		for(int i=0;i<R;i++) {
			if(map[i][sel]!=0) return i;
		}
		return 0;
	}//end findStartBlock method
	
	
	static void bfs(int sel) {
		Queue<Pos> queue = new LinkedList<Pos>();
		// 처음 떨어지는 구슬을 큐에 넣는다.
		
		//첫 시작 위치(row) 찾기 	
		int start = findStartPoint(sel);
		queue.add(new Pos(start, sel, map[start][sel]));
		map[start][sel]=0;
		
		while (!queue.isEmpty()) {
			Pos p = queue.poll();
			
			if(p.bomb == 0 ) continue;
			// 1이면 주변에 영향X
			if (p.bomb == 1) {
				map[p.r][p.c] = 0;
			} else {
				// 2이상이면 주변 벽돌에 영향을 줄 수 있음.

				int B = p.bomb;
				// 상 하 좌 우 퍼짐.
				// p.bomb만큼.
				// 상 .. r--
				int nr;
				int nc;
				for (int i = 1; i < B; i++) {
					nr = p.r + (i * -1);
					nc = p.c;
					if (isRange(nr, nc)) {
						// 빈칸이면 건너뛰기 - continue;
						if (map[nr][nc] == 0) continue;
						// 1이면 다른 벽돌에는 영향을 주지 않으니까. 방문처리+0으로.
						if (map[nr][nc] == 1) map[nr][nc] = 0;
						// 2이상이면 다른 벽돌에 영향을 주므로, 방문처리 + 큐에 넣기
						if (map[nr][nc] >= 2) {
							queue.add(new Pos(nr, nc, map[nr][nc]));
							map[nr][nc]=0;
						}
					} // end range if
				} // 위로가는 방향 끝.

				// 하 .. r++
				for (int i = 1; i < B; i++) {
					nr = p.r + i;
					nc = p.c;
					if (isRange(nr, nc)) {
						if (map[nr][nc] == 0) continue;
						if (map[nr][nc] == 1) map[nr][nc] = 0;
						if (map[nr][nc] >= 2) {
							queue.add(new Pos(nr, nc, map[nr][nc]));
							map[nr][nc]=0;
						}
					} // end range if
				}

				// 좌 .. c--
				for (int i = 1; i < B; i++) {
					nr = p.r;
					nc = p.c + (i * -1);
					if (isRange(nr, nc)) {
						if (map[nr][nc] == 0) continue;
						if (map[nr][nc] == 1) map[nr][nc] = 0;
						if (map[nr][nc] >= 2) {
							queue.add(new Pos(nr, nc, map[nr][nc]));
							map[nr][nc]=0;
						}
					} // end range if
				}

				// 우 .. c++
				for (int i = 1; i < B; i++) {
					nr = p.r;
					nc = p.c + i;
					if (isRange(nr, nc)) {
						if (map[nr][nc] == 0) continue;
						if (map[nr][nc] == 1) map[nr][nc] = 0;
						if (map[nr][nc] >= 2) {
							queue.add(new Pos(nr, nc, map[nr][nc]));
							map[nr][nc]=0;
						}
					} // end range if
				}
			}//end else 
		} // end while loop
	}// end bfs method

	static boolean isRange(int r, int c) {
		//배열 범위 체크
		return r >= 0 && c >= 0 && r < R && c < C;
	}//end isRange method

	static void copy() {
		// origianl -> map 복사
		for (int i = 0; i < R; i++) {
			map[i] = Arrays.copyOf(map_origin[i], map_origin[i].length);
		}
	}// end copy method
}
