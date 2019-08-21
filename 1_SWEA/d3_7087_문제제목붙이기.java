package solving3;

import java.util.Scanner;

public class d3_7087_문제제목붙이기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[] asc = new int[26];
			int N = sc.nextInt();
			for(int i=0; i<N; i++) {
				String s = sc.next();
				if(s.charAt(0)=='_')
					continue;
				if(Character.isDigit(s.charAt(0)))
					continue;
				
				asc[s.charAt(0)-65]++;
			}
			
			for(int i=0; i<asc.length; i++) {
				int a = asc[i] + 65;
				char c = (char)a;
				System.out.print(c);
			}
			
			
		}//end test cases
	}//end main
}
