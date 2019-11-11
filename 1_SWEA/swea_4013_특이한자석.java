import java.util.Scanner;

public class swea_4013_특이한자석 {
	static int[][] magnet;
	static int K;
	static int ans;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			K = sc.nextInt();
			// i = 0은 비워둠. j = 0은 dir로 쓸거야
			magnet = new int[5][9];
			// 자석정보 입력
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= 8; j++) {
					magnet[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			// 회전정보 입력
			for (int i = 0; i < K; i++) {
				sel = new boolean[5];
				// 인접한 자석 확인 및 바뀌어야 할 톱니바퀴 dir 변경
				changeDir(sc.nextInt(), sc.nextInt());
				// 바뀌어야 할 톱니바퀴 rotate
				for (int s = 1; s <= 4; s++) {
					if (sel[s]) {
						rotate(s, magnet[s][0]);
					}
				}
			}
			// 다돌린 뒤 점수 확인
			score();
			System.out.println("#" + tc + " " + ans);
		} // end test cases
	}// end main

	static void score() {
		for (int i = 1; i <= 4; i++) {
			int val = magnet[i][1];
			if (i == 1) {
				if (val == 1)
					ans += 1;
			} else if (i == 2) {
				if (val == 1)
					ans += 2;
			} else if (i == 3) {
				if (val == 1) {
					ans += 4;
				}
			} else if (i == 4) {
				if (val == 1)
					ans += 8;
			}
		}
	}

	static void rotate(int idx, int dir) {
		if (dir == 1) {
			int temp = magnet[idx][8];
			for (int i = 8; i >= 2; i--) {
				magnet[idx][i] = magnet[idx][i - 1];
			}
			magnet[idx][1] = temp;
		} else {
			int temp = magnet[idx][1];
			for (int i = 1; i <= 7; i++) {
				magnet[idx][i] = magnet[idx][i + 1];
			}
			magnet[idx][8] = temp;
		}
	}

	static void changeDir(int idx, int dir) {
		boolean[] visited = new boolean[5];
		visited[0] = true;
		visited[idx] = true;
		sel[idx] = true;
		magnet[idx][0] = dir;
		dfs(idx, visited);
	}

	static void dfs(int idx, boolean[] visited) {

		if (idx == 1) {
			// 다르면 움직여
			if (!visited[idx + 1] && magnet[idx][3] != magnet[idx + 1][7]) {
				visited[idx + 1] = true;
				sel[idx + 1] = true;
				magnet[idx + 1][0] = magnet[idx][0] * -1;
				dfs(idx + 1, visited);
			}
		} else if (idx == 4) {
			if (!visited[idx - 1] && magnet[idx][7] != magnet[idx - 1][3]) {
				visited[idx - 1] = true;
				sel[idx - 1] = true;
				magnet[idx - 1][0] = magnet[idx][0] * -1;
				dfs(idx - 1, visited);
			}
		}
		// 2, 3 양쪽 다 확인해야하는 곳
		else {
			// 현재 톱니바퀴와 오른쪽 톱니바퀴를 확인
			if (!visited[idx + 1] && magnet[idx][3] != magnet[idx + 1][7]) {
				visited[idx + 1] = true;
				sel[idx + 1] = true;
				magnet[idx + 1][0] = magnet[idx][0] * -1;
				dfs(idx + 1, visited);
			}
			// 현재 톱니바퀴와 왼쪽 톱니바퀴를 확인
			if (!visited[idx - 1] && magnet[idx][7] != magnet[idx - 1][3]) {
				visited[idx - 1] = true;
				sel[idx - 1] = true;
				magnet[idx - 1][0] = magnet[idx][0] * -1;
				dfs(idx - 1, visited);
			}
		}
	}
}
