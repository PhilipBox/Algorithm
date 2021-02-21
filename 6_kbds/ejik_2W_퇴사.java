package algorithm;

import java.util.Scanner;

public class ejik_2W_��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] talk = new int[N][2];
		// 0�� �ҿ�ð�
		// 1�� �ݾ�
		for (int i = 0; i < N; i++) {
			talk[i][0] = sc.nextInt();
			talk[i][1] = sc.nextInt();
		}

		int[] dp = new int[N];

		if (talk[N - 1][0] == 1)
			dp[N - 1] = talk[N - 1][1];
		else
			dp[N - 1] = 0;

		for (int i = N - 2; i >= 0; i--) {
			if (i + talk[i][0] >= N) {
				if (i + talk[i][0] == N) {
					dp[i] = Math.max(talk[i][1], dp[i + 1]);
				} else
					dp[i] = dp[i + 1];
			} else {
				dp[i] = Math.max(talk[i][1] + dp[i + talk[i][0]], dp[i + 1]);
			}
		}
		System.out.println(dp[0]);

	}// end main
}
