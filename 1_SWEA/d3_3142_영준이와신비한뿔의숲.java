package solving2;

import java.util.Scanner;

public class d3_3142_영준이와신비한뿔의숲 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// N : 뿔의 수
			int N = sc.nextInt();
			// M : 동물의 수
			int M = sc.nextInt();
			
			int twin=0;
			int uni=0;
			twin = N-M;
			
			uni = M - twin;
			System.out.println("#"+tc+" "+uni + " " + twin);
		}//end test cases
	}//end main
}
