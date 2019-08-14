package solving2;

import java.util.Scanner;

public class d3_5162_두가지빵의딜레마 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int C = sc.nextInt();
			if( A>=B)
				System.out.println("#"+tc+" "+C/B);
			else
				System.out.println("#"+tc+" "+C/A);
			
		}//end test cases
	}//end main
}
