package beakjoon;

import java.util.Scanner;

public class bj_2096_내려가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][][] dp = new int[2][N][3];
		int[][] map = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++)
				map[i][j] = sc.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			dp[0][0][i] = map[0][i];
			dp[1][0][i] = map[0][i];
		}

		for (int i = 1; i < N; i++) {
			int max = Math.max(dp[0][i-1][0], dp[0][i-1][1]);
			max = Math.max(max, dp[0][i-1][2]);
			dp[0][i][0] = Math.max(dp[0][i - 1][0], dp[0][i - 1][1]) + map[i][0];
			dp[0][i][1] = max+ map[i][1];
			dp[0][i][2] = Math.max(dp[0][i-1][1], dp[0][i-1][2]) + map[i][2];
			
			int min = Math.min(dp[1][i-1][0], dp[1][i-1][1]);
			min = Math.min(min, dp[1][i-1][2]);
			dp[1][i][0] = Math.min(dp[1][i - 1][0], dp[1][i - 1][1]) + map[i][0];
			dp[1][i][1] = min+ map[i][1];
			dp[1][i][2] = Math.min(dp[1][i-1][1], dp[1][i-1][2]) + map[i][2];
		}

		int maxRes = Math.max(dp[0][N - 1][0], dp[0][N - 1][1]);
		maxRes = Math.max(maxRes, dp[0][N - 1][2]);

		int minRes = Math.min(dp[1][N - 1][0], dp[1][N - 1][1]);
		minRes = Math.min(minRes, dp[1][N - 1][2]);

		System.out.println(maxRes + " " + minRes);
	}// end main
}
