import java.util.Scanner;

public class 이동하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// i == 0 && j== 0 → dp[i][j] = map[i][j]
		// 맨 왼쪽줄과 맨 윗줄은 예외적으로 누적합... 이거를 한줄씩 더 크게 만들어서
		//dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] ) + map[i][j]
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		}
		int[][] dp = new int[N+1][M+1];
		dp[1][1] = map[0][0];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] ) + map[i-1][j-1];
			}
		}
		System.out.println(dp[N][M]);
	}
}
