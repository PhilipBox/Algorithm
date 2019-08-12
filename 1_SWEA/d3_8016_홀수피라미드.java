package swea;

import java.util.Scanner;

public class d3_8016_홀수피라미드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			long N = sc.nextInt();
			long pow = N*N;
			long pre_pow = (N-1)*(N-1);
			if(N==1)
				System.out.println("#"+tc+" "+"1 1");
			else {
			System.out.println("#"+tc+" "+((2*pre_pow)+1)+" "+((2*pow)-1));
			}
		}//end test cases
	}//end main
}
