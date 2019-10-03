package beakjoon;

import java.util.Scanner;

public class bj_1010_다리놓기 {
	
	static int N;
	static int M;
	static long total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
		
			int[][] arr = new int[N+1][M+1];
			for(int i=1; i<=M; i++) arr[1][i]=i;
			
			for(int i=2; i<=N; i++) {
				for(int j=i; j<=M; j++) {
					for(int k=j-1; k>=i-1;k--) {
						arr[i][j] += arr[i-1][k];
					}
				}
			}
			System.out.println(arr[N][M]);
		}//end test cases
	}//end main
}
