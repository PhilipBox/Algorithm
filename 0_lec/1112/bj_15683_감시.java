package _1112;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj_15683_감시 {

	static class cctv {
		int r, c;
		int mode;

		public cctv(int r, int c, int m) {
			this.r = r;
			this.c = c;
			this.mode = m;
		}
	}

	static int R;
	static int C;
	static int[][] origin;
	static ArrayList<cctv> clist;

	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		origin = new int[R][C];
		clist = new ArrayList<cctv>();
		ans=987654321;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				origin[i][j] = sc.nextInt();
				if (origin[i][j] >= 1 && origin[i][j] <= 5)
					clist.add(new cctv(i, j, origin[i][j]));
			}
		}
		//
		solve(0,origin);
		System.out.println(ans);
	}// end main

	static void solve(int cctvidx, int[][] map) {
		int[][] visited = new int[R][C];
		// 마지막 cctv까지 탐색하고 난 뒤.
		if (cctvidx == clist.size()) {
			int tcnt = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 0)
						tcnt++;
				}
			}
			if(tcnt < ans) {
				ans = tcnt;
			}
		}
		// 탐색하지 않은 cctv가 남아있다면.
		else {
			cctv tv = clist.get(cctvidx);
			int mode = tv.mode;
			int r = tv.r;
			int c = tv.c;
			switch (mode) {
			case 1:
				// 4방향
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < R; j++) {
						visited[j] = Arrays.copyOf(map[j], map[j].length);
					}
					// 한쪽 바꾸고.
					detect(visited, r, c, i);
					solve(cctvidx + 1, visited);
				}
				break;
			case 2:
				// 2방향
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < R; j++) {
						visited[j] = Arrays.copyOf(map[j], map[j].length);
					}
					detect(visited, r, c, i);
					detect(visited, r, c, i + 2);
					solve(cctvidx + 1, visited);
				}
				break;
			case 3:
				// 4방향
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < R; j++) {
						visited[j] = Arrays.copyOf(map[j], map[j].length);
					}
					// 한쪽 바꾸고.
					detect(visited, r, c, i);
					detect(visited, r, c, (i + 1) % 4);
					solve(cctvidx + 1, visited);
				}
				break;
			case 4:
				// 4방향
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < R; j++) {
						visited[j] = Arrays.copyOf(map[j], map[j].length);
					}
					// 한쪽 바꾸고.
					detect(visited, r, c, i);
					detect(visited, r, c, (i + 1) % 4);
					detect(visited, r, c, (i + 2) % 4);
					solve(cctvidx + 1, visited);
				}
				break;
			case 5:
				// 4방향
				for (int j = 0; j < R; j++) {
					visited[j] = Arrays.copyOf(map[j], map[j].length);
				}
				// 한쪽 바꾸고.
				detect(visited, r, c, 0);
				detect(visited, r, c, 1);
				detect(visited, r, c, 2);
				detect(visited, r, c, 3);
				solve(cctvidx + 1, visited);
				break;
			}

		}

	}// end solve method



	static void detect(int[][] visited, int r, int c, int dir) {
		switch (dir) {
		case 0:
			// 오른쪽
			for (int j = c; j < C; j++) {
				if (origin[r][j] == 6)
					break;
				visited[r][j] = 7;
			}
			break;
		case 1:
			// 아래
			for (int i = r; i < R; i++) {
				if (origin[i][c] == 6)
					break;
				visited[i][c] = 7;
			}
			break;
		case 2:
			// 왼쪽
			for (int j = c; j >= 0; j--) {
				if (origin[r][j] == 6)
					break;
				visited[r][j] = 7;
			}
			break;
		case 3:
			// 위
			for (int i = r; i >= 0; i--) {
				if (origin[i][c] == 6)
					break;
				visited[i][c] = 7;
			}
			break;
		}// end switch
	}// end detect method

}
