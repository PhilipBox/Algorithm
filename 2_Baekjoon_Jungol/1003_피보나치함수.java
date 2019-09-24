package _solving;

import java.util.Scanner;

public class bj_1003_피보나치함수 {
	static int[][] memo;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		memo = new int[41][2];
		memo[0][0] = 1;
		memo[0][1] = 0;
		
		memo[1][0] = 0;
		memo[1][1] = 1;
		
		for(int i=2; i<41; i++) {
			for(int j=0; j<2; j++) {
				memo[i][j] = memo[i-2][j]+memo[i-1][j];
			}
		}
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			System.out.println(memo[n][0] +" " + memo[n][1]);
		}//end test cases
	}//end main
}
