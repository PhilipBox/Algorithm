package studyClass;

import java.util.Scanner;

public class d3_1234_비밀번호 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int N = sc.nextInt();
			StringBuilder sb = new  StringBuilder();
			sb.append(sc.next());
			while(true) {
				int flag=0;
				for(int i=0; i<sb.length()-1;  i++) {
					if(sb.charAt(i)==sb.charAt(i+1)) {
						sb.delete(i, i+2);
						break;
					}
					if(i+1 ==sb.length()-1)
						flag=1;
				}//end for
				if(flag==1)
					break;
			}//end while
			System.out.println("#"+tc+" "+ sb.toString());
		}//end test cases
	}//end main
}
