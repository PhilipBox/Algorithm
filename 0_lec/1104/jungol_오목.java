import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class jungol_오목{
	private static class Node implements Comparable<Node> {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			if (this.c == o.c)
				return this.r - o.r;
			return this.c - o.c;
		}
	}

	private final static int N = 19;
	private static int[] dr = { -1, 0, 1, 1, 1, 0, -1, -1 };
	private static int[] dc = { 1, 1, 1, 0, -1, -1, -1, 0 };
	private static int[][] area;
	private static int[][][] chk;
	private static LinkedList<Node> list;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		area = new int[N][N];
		chk = new int[N][N][8];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				area[i][j] = sc.nextInt();
			}
		}

		boolean flag = false;
		out: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (area[i][j] != 0) {
					for (int d = 0; d < 8; d++) {
						chk[i][j][d] = 1;
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N || chk[nr][nc][d] == 1 || area[nr][nc] != area[i][j])
							continue;
						list = new LinkedList<>();
						list.add(new Node(i, j));
						if (check(nr, nc, d, area[nr][nc]) == 4) {
							Collections.sort(list);
							System.out.println(area[i][j]);
							System.out.println((list.get(0).r + 1) + " " + (list.get(0).c + 1));
							flag = true;
							break out;
						}
					}
				}
			}
		}
		if (!flag)
			System.out.println(0);
	}

	private static int check(int r, int c, int d, int nowColor) {
		list.add(new Node(r, c));
		chk[r][c][d] = 1;
		int nr = r + dr[d];
		int nc = c + dc[d];
		if (nr < 0 || nc < 0 || nr >= N || nc >= N || area[nr][nc] != nowColor)
			return 1;
		return check(nr, nc, d, nowColor) + 1;
	}
}
