package solving2;

import java.util.Scanner;

public class d3_5789_현주의상자바꾸기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int[] box = new int[N];
			
			for(int i=1; i<=Q; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				for(int j=L-1; j<=R-1; j++) {
					box[j]=i;
				}
			}
			
			System.out.print("#"+tc);
			for(int i=0; i<box.length; i++) {
				System.out.print(" "+box[i]);
			}
			System.out.println();
		}//end test cases
	}//end main
}
