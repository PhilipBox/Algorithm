package solving2;

import java.util.Scanner;

public class d3_7532_세영이의SEM력연도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int S = sc.nextInt();
			int E = sc.nextInt();
			int M = sc.nextInt();
			
			// 예외처리 
			if(S%24==E && S%29==M ) {
				System.out.println("#"+tc+" "+S);
			}
			else {
				int year = S + 365;
				if(S==365)
					S=0;
				if(E==24)
					E=0;
				if(M==29)
					M=0;
				
				while(true) {
					if(year%365!=S) {
						year += 365;
						continue;
					}
					if(year%24!=E) {
						year += 365;
						continue;
					}
					if(year%29!=M) {
						year+=365;
						continue;
					}
					break;
				}
				System.out.println("#"+tc+" "+year);
			}//end else
		}//end test cases
	}//end main
}
