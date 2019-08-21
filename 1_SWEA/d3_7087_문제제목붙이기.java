package selfStudy;

import java.util.Scanner;

public class d3_7087_문제제목붙이기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[] asc = new int[26];
			int N = sc.nextInt();
			// 입력받은 알파벳을 +해준다. 
			// 숫자 및 _ 는 건너뛰기,
			for(int i=0; i<N; i++) {
				String s = sc.next();
				if(s.charAt(0)=='_')
					continue;
				if(Character.isDigit(s.charAt(0)))
					continue;
				asc[s.charAt(0)-'A']++;
			}

			int cnt=0;
			for(int i=0; i<asc.length; i++) {
				if(asc[i]==0)
					break;
				cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}//end test cases
	}//end main
}
