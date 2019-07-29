package day00_study;

import java.util.Scanner;

public class d2_1970_쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int M = sc.nextInt();
			
			int[] cost = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			
			System.out.println("#"+tc);
			for(int i=0; i<cost.length; i++) {
				// 다음 화폐 사용
				if(M/cost[i]<1) {
					System.out.print("0 ");
					continue;
				}
				else {
					System.out.print(M/cost[i]+" ");
					M %= cost[i];
				}
				System.out.println();
			}//end for loop
			
		}//end test cases
	}
}
