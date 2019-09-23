import java.util.Scanner;

public class 이동하기_재귀 {
	static int[][] map;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		}
		memo = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				memo[i][j] = -1;
		}
		System.out.println(solve(0, 0));
	}
	static int[][] memo;
	static int solve(int r,int c) {
		if( r == N - 1 && c == M - 1 ) {
			return map[r][c];
		}
		if(memo[r][c] != -1)
			return memo[r][c];
		int result = map[r][c];
		int s1 = 0, s2 = 0;
		if( r + 1 < N )
			s1 = solve(r+1, c);
		if( c + 1 < M )
			s2 = solve(r, c+1);
		result += Math.max(s1, s2);
		memo[r][c] = result;
		return result;
	}
}







