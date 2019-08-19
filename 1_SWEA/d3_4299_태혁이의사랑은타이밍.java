package solving2;

import java.util.Scanner;

public class d3_4299_태혁이의사랑은타이밍 {
	static final int MIN = 11+(11*60)+(11*60*24);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int D = sc.nextInt();
			int H = sc.nextInt();
			int M = sc.nextInt();
			int totalMin = M+(H*60)+(D*24*60);
			
			if(totalMin<MIN) {
				System.out.println("#"+tc+" -1");
			}
			else
				System.out.println("#"+tc+" "+(MIN-totalMin)*-1);
		}//end test cases
	}//end main
}
