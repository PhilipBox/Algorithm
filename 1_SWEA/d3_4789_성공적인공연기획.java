package selfStudy;

import java.util.Scanner;

public class d3_4789_성공적인공연기획 {
	static int cnt;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0; // 일어선 사람 수
			ans = 0; // 고용해야하는 사람 수
			String s = sc.next();
			
			for(int i=0; i<s.length(); i++) {
				if(cnt>=i) {
					cnt += s.charAt(i)-'0';
				}
				else {
					ans += i-cnt;
					cnt = i+ s.charAt(i)-'0';
				}
			}
			System.out.println("#"+tc+" "+ans);
		} // end test cases
	}// end main
}
