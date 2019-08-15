package selfStudy;

import java.util.Scanner;

public class d3_7510_상원이의연속합 {
	static int cnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			cnt=0;
			
			int N = sc.nextInt();
			for(int i=1; i<=N; i++) {
				perm(i,N,0);
			}
			System.out.println("#"+tc+" "+cnt);
			
		}//end test cases
	}//end main
	
	static void perm(int i, int N, long sum) {
		if(sum==N) {
			cnt++;
			return;
		}
		if(sum>N)
			return;
		
		perm(i+1, N, sum+i);
	}
}
