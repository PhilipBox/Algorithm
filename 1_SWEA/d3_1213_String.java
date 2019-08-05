package studyClass;

import java.util.Scanner;

public class d3_1213_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int n = sc.nextInt();
			String key = sc.next();
			String str = sc.next();
			
			str = str.replaceAll(key, " ");
			System.out.println(str.toString());
			int cnt=0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)==' ')
					cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}//end test cases
	}
}
