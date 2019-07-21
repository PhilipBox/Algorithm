package studyClass;

import java.util.Scanner;

public class d3_7728_다양성측정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int ts=1; ts<=T; ts++) {
			
			int cnt=0;
			String num = sc.next();
			int[] digit = new int[10];

			for(int i=0; i<num.length();  i++) {
				int tmp = (int)num.charAt(i)-48;
				digit[tmp]++;
			}
			
			for(int i=0;i<10; i++) {
				if(digit[i] != 0)
					cnt++;
			}
			
			System.out.println("#"+ts+" "+cnt);
		}//end test cases
		
		
		
	}//end main
}
