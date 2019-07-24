package studyClass;

import java.util.Scanner;

public class d2_1926_간단한369게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int END = sc.nextInt();
		int start=1;
		while(start<=END) {
			String N = Integer.toString(start);
			// 한자리수
			if(N.length()==1) {
				if( N.charAt(0)=='3' || N.charAt(0)=='6' || N.charAt(0)=='9')
					System.out.print("- ");
				else
					System.out.print(N+" ");
			}
			// 두자리수 이상
			else {
				int cnt=0;
				for (int i = 0; i < N.length(); i++) {
					if(N.charAt(i)=='3' || N.charAt(i)=='6' || N.charAt(i)=='9')
						cnt++;
				}
				if(cnt==0)
					System.out.print(N+' ');
				else {
					for(int i=0; i<cnt; i++) {
						System.out.print('-');
					}
					System.out.print(' ');
				}
			}
			start++;
		}//end while loop
	}
}