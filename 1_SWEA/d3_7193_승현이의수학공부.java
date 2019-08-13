package solving2;

import java.util.Scanner;

public class d3_7193_승현이의수학공부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			String X = sc.next();

			System.out.println("#"+tc+" "+ digitSum(X)%(N-1));
		}
	}//end main
	
	static int digitSum(String X) {
		int sum=0;
		for(int i=0; i<X.length(); i++) {
			sum += X.charAt(i) - '0';
		}
		
		return sum;
	}//end digitSum end
}
