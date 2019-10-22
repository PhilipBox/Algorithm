import java.util.Scanner;

public class bj_17779_게리맨더링2 {

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
	static Pos[] dot;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
			System.out.println(res);
			// comb
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
			if (nr > N - 1 || nc > N - 1) {
				break;
			}
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
			
		}

		nr = dot[3].r;
		nc = dot[3].c;
		// 오른쪽점에서 좌하각으로 true(겹치는게 있음)
		while (true) {
			nr++;
			nc--;
			// 배열범위초과
			if (nr > N - 1 || nc < 0) {
				break;
			}
			if (visited[nr][nc]) {
				// 겹치는 부분은 아래 점이 될 수 있음.
				dot[4] = new Pos(nr, nc);
				// 4개점을 다 찍었음.
				getArea();
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
				}
			}
		}
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
}// end class