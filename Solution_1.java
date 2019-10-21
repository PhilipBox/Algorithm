import java.util.Scanner;

public class Solution {

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}// end Pos

	static int N;
	static int[][] map;
	static int[][] copy;
	static Pos[] dot;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			dot = new Pos[5];
			res = 987654321;
			// map 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					// 가장 위에있는 점 선정
					dot[1] = new Pos(i, j);
					leftDot(i, j);
				}
			}

			System.out.println("#"+tc+" "+res);
			// comb

		} // end test cases
	}// end main

	static void leftDot(int tr, int tc) {
		int nr = tr;
		int nc = tc;
		while (true) {
			nr++;
			nc--;
			// 배열범위초과
			if (nr > N - 1 || nc < 0)
				break;
			dot[2] = new Pos(nr, nc);
			rightDot(tr, tc);
		}
	}// 왼쪽 점 pick

	static void rightDot(int tr, int tc) {
		int nr = tr;
		int nc = tc;
		while (true) {
			nr++;
			nc++;
			// 배열범위초과
			if (nr > N - 1 || nc > N - 1)
				break;
			dot[3] = new Pos(nr, nc);
			donwDot();
		}
	}// 오른쪽 점 pick

	static boolean[][] visited;

	static void donwDot() {
		visited = new boolean[N][N];

		// 왼쪽점에서 우하각으로 true
		int nr = dot[2].r;
		int nc = dot[2].c;
		while (true) {
			nr++;
			nc++;
			if (nr > N - 1 || nc > N - 1)
				break;
			visited[nr][nc] = true;
			break;
		}

		nr = dot[3].r;
		nc = dot[3].c;
		// 오른쪽점에서 좌하각으로 true(겹치는게 있음)
		while (true) {
			nr++;
			nc--;
			// 배열범위초과
			if (nr > N - 1 || nc < 0)
				break;
			if (visited[nr][nc]) {
				// 겹치는 부분은 아래 점이 될 수 있음.
				dot[4] = new Pos(nr, nc);
				// 4개점을 다 찍었음.
				copy = new int[N][N];
				copy[dot[1].r][dot[1].c] = 5;
				copy[dot[2].r][dot[2].c] = 5;
				copy[dot[3].r][dot[3].c] = 5;
				copy[dot[4].r][dot[4].c] = 5;
				getArea();
//				print();
				// 여기서 구역별 합을 구하면 됨.

//			
//				System.out.println("상: " + dot[1].r + "," + dot[1].c);
//				System.out.println("좌: " + dot[2].r + "," + dot[2].c);
//				System.out.println("우: " + dot[3].r + "," + dot[3].c);
//				System.out.println("하: " + dot[4].r + "," + dot[4].c);
//				System.out.println("======================");
				break;
			}
		}
	}// end 아래 점 pick

	static void getArea() {
		int[] area = new int[6];
		visited = new boolean[N][N];

		// 지역별로 합 구하기
		// 1
		int R = dot[2].r;
		int C;
		if (dot[1].r == 0)
			C = dot[1].c;
		else
			C = dot[1].c + 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				area[1] += map[i][j];
				copy[i][j] = 1;
				visited[i][j] = true;
			}
			if (i + 1 >= dot[1].r)
				C--;
		}

		// 2
		R = dot[3].r + 1;
		if (dot[3].c == N - 1)
			R--;
		C = dot[1].c + 1;
		for (int i = 0; i < R; i++) {
			for (int j = C; j < N; j++) {
				area[2] += map[i][j];
				copy[i][j] = 2;
				visited[i][j] = true;
			}
			if (i >= dot[1].r)
				C++;
		}
		// 3

		R = dot[2].r;
		if (dot[2].c == 0)
			R++;

		if (dot[2].c == 0)
			C = dot[2].c + 1;
		else
			C = dot[2].c;
		for (int i = R; i < N; i++) {
			for (int j = 0; j < C; j++) {
				area[3] += map[i][j];
				copy[i][j] = 3;
				visited[i][j] = true;
			}
			if (i < dot[4].r)
				C++;
		}
		
		// 4
		C = dot[4].c;
		if(dot[4].r==N-1) C ++;
		
		for (int i = N-1; i > dot[3].r; i--) {
			
			for (int j = C; j < N; j++) {
				area[4] += map[i][j];
				copy[i][j] = 4;
				visited[i][j] = true;
			}
			if (i-1 <= dot[4].r)
				C++;
		}

		
		
		// 5
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j])continue;
				else {
					area[5] += map[i][j];
					copy[i][j]=5;
				}
			}
		}
//		System.out.println("1구역 : " + area[1]);
//		System.out.println("2구역 : " + area[2]);
//		System.out.println("3구역 : " + area[3]);
//		System.out.println("4구역 : " + area[4]);
		
		int min = 987654321;
		int max = 0;
		for(int i=1; i<=5; i++) {
			min = Math.min(min, area[i]);
			max = Math.max(max, area[i]);
		}
		int tempRes = max - min;
		res = Math.min(res, tempRes);
		
	}// 지역 합 구하기
	static int res = 987654321;
	
	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}// end class
