import java.util.Scanner;

public class d4_6109_추억의2048게임 {
	static class NUM {
		int val;
		boolean status;

		public NUM(int v) {
			this.val = v;
			this.status = false;
		}
	}

	static int N;
	static NUM[][] map;
	static NUM zero = new NUM(0);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 입력 및 초기화
			N = sc.nextInt(); // map의 크기
			map = new NUM[N][N]; // NUM객체 map 생성
			String dir = sc.next(); // 밀어낼 방향
			// map 입력받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new NUM(sc.nextInt());
				}
			}
			print();
			init(dir);
			push();
			print();

		} // end test cases
	}// end main

	static void init(String dir) {
		if (dir.equals("up")) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].val == 0)
						continue;
					if (map[i][j].status)
						continue;

					if (map[i][j].val == map[i + 1][j].val) {
						map[i][j].val *= 2;
						map[i][j].status = true;

						map[i + 1][j] = zero;
					}
				}
			}
		} // end up init

		else if (dir.equals("down")) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].val == 0)
						continue;
					if (map[i][j].status)
						continue;

					if (map[i][j].val == map[i + 1][j].val) {
						map[i][j].val *= 2;
						map[i][j].status = true;

						map[i + 1][j] = zero;
					}
				}
			}
		} // end down

		else if (dir.equals("left")) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].val == 0)
						continue;
					if (map[i][j].status)
						continue;

					if (map[i][j].val == map[i + 1][j].val) {
						map[i][j].val *= 2;
						map[i][j].status = true;

						map[i + 1][j] = zero;
					}
				}
			}
		} // end left

		else if (dir.equals("right")) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].val == 0)
						continue;
					if (map[i][j].status)
						continue;

					if (map[i][j].val == map[i + 1][j].val) {
						map[i][j].val *= 2;
						map[i][j].status = true;

						map[i + 1][j] = zero;
					}
				}
			}
		} // end right
	}// end init method;

	static void push() {
		// up
		// 컬럼
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (map[i][j].val != 0)
					continue;
				map[i][j] = map[i + 1][j];
				map[i][j] = zero;
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j].val + " ");
			}
			System.out.println();
		}
		System.out.println();
	}// end print

}
