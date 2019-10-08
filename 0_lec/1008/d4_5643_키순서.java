import java.util.Scanner;
public class d4_5643_키순서 {
	static int N;
	static int M;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			dist = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						dist[i][j] = 0;
					else
						dist[i][j] = -1;
				}
			}
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				dist[a - 1][b - 1] = 99;
			}
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j)
							continue;
						if (dist[i][k] != -1 && dist[k][j] != -1) {
							dist[i][j] = 99;
						}
					}
				}
			}
			int res = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (dist[i][j] == 99 || dist[j][i] == 99)
						cnt++;
				}
				if (cnt == N - 1)
					res++;
			}
			System.out.println("#"+tc+" " + res);
		} // end test cases
	}// end main
}
