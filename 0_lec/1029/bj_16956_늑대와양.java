
import java.util.Scanner;

public class bj_16956_늑대와양 {

	static int R;
	static int C;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'W') {
					if (!check(i, j)) {
						System.out.println("0");
						return;
					}
				}
			}
		}
		System.out.println("1");
		print();
	}// end main

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static boolean check(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 배열범위 체크
			if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1)
				continue;
			// 인접한 곳에 양이 있으면 안됨.
			if (map[nr][nc] == 'S')
				return false;
			if (map[nr][nc] == '.')
				map[nr][nc] = 'D';

		}
		return true;
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
