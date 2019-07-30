package day00_study;

import java.util.Scanner;

public class d2_1946_간단한압축풀기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int total=0;
			StringBuilder str = new StringBuilder();
			
			for(int i=0; i<N; i++) {
				String c = sc.next();
				int cnt = sc.nextInt();
				total += cnt;
				for(int j=0; j<cnt; j++)
					str.append(c);
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<total; i++) {
				if(i != 0 && i%10==0)
					System.out.println();
				System.out.print(str.charAt(i));
			}
			System.out.println();
		}//end test cases
	}//end main
}
