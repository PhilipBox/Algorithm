package _1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class swea {
	static class POS implements Comparable<POS>{
		int r;
		int c;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(POS o) {
			return this.c - o.c;
		}
	}

	static int[][] map;
	static final int SIZE = 19;
	static ArrayList<POS> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[SIZE][SIZE];
		list = new ArrayList<POS>();
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				map[i][j] = sc.nextInt();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				// 탐색
				if (map[i][j] == 0)
					continue;
				else {
					check(i, j, map[i][j]);
				}

				if (flag) {
					System.out.println(ans);
					System.out.println((ansR + 1) + " " + (ansC + 1));
					return;
				}
			} // end j loop
		} // end i loop
		System.out.println("0");
	}// end main

	// 우 하 우하각
	static int[] dr = { 0, 1, 1, 1 };
	static int[] dc = { 1, 0, 1, -1 };

	static void check(int r, int c, int color) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 배열범위 초과
			if (nr < 0 || nc < 0 || nr >= SIZE || nc >= SIZE)
				continue;
			// 색깔 다름
			if (map[nr][nc] != color)
				continue;

			// 색깔 같음
			// dfs 시작 (좌표 + 방향 + 색깔)
			list.add(new POS(r,c));
			dfs(r, c, i, color);
			System.out.println("+========");
			if(list.size()>5) {
				list.clear();
				continue;
			}
			if(list.size()==5) {
				for(int q=0; q<list.size(); q++) {
					System.out.println(list.get(i).r +"," + list.get(i).c);
				}
				flag = true;
				ans = color;
				Collections.sort(list);
				ansR = list.get(0).r;
				ansC = list.get(0).c;
				return;
			}
		}
	}// end check

	static int ans;
	static int ansR;
	static int ansC;
	static boolean flag = false;

	static void dfs(int r, int c, int dir, int color) {
		System.out.println(r+","+c+" 들어옴 // " + color);
		int cnt = 1;
		int nr = r;
		int nc = c;
		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			System.out.println(nr +"," + nc);
			if (nr < 0 || nc < 0 || nr >= SIZE || nc >= SIZE) {
				list.clear();
				break;
			}
			if (map[nr][nc] != color) {
				list.clear();
				return;
			}
			cnt++;
			list.add(new POS(nr,nc));
			if (cnt >= 6) {
				break;
			}
		}
	}

	static void print() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}