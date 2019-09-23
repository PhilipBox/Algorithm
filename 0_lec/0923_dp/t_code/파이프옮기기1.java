import java.util.Scanner;

public class 파이프옮기기1 {
	static class Point {
		int r;
		int c;
		int dir;

		Point(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static int N;
	static boolean[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt() == 0 ? true : false;
		}
		dfs(new Point(0,1,0));
		System.out.println(result);
	}

	static int result = 0;

	static void dfs(Point p) {
		if (p.r == N - 1 && p.c == N - 1) {
			result++;
			return;
		}

		switch (p.dir) {
		case 0:
			if( p.c + 1 < N && map[p.r][p.c+1] )
				dfs(new Point(p.r, p.c + 1, 0));
			if( p.r + 1 < N && p.c + 1 < N && map[p.r + 1][p.c] && map[p.r][p.c + 1] && map[p.r + 1][p.c + 1])
				dfs(new Point(p.r + 1, p.c + 1 , 2));
			break;
		case 1:
			if( p.r + 1 < N && map[p.r + 1][p.c] )
				dfs(new Point(p.r + 1, p.c, 1));
			if( p.r + 1 < N && p.c + 1 < N && map[p.r + 1][p.c] && map[p.r][p.c + 1] && map[p.r + 1][p.c + 1])
				dfs(new Point(p.r + 1, p.c + 1 , 2));
			break;
		case 2:
			if( p.c + 1 < N && map[p.r][p.c+1] )
				dfs(new Point(p.r, p.c + 1, 0));
			if( p.r + 1 < N && map[p.r + 1][p.c] )
				dfs(new Point(p.r + 1, p.c, 1));
			if( p.r + 1 < N && p.c + 1 < N && map[p.r + 1][p.c] && map[p.r][p.c + 1] && map[p.r + 1][p.c + 1])
				dfs(new Point(p.r + 1, p.c + 1 , 2));
			break;
		}
	}
}
