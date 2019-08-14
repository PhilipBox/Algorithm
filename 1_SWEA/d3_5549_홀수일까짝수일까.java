package solving2;

import java.util.Scanner;

public class d3_5549_홀수일까짝수일까 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String n = sc.next();
			int digit = n.charAt(n.length()-1) - '0';
			
			if(digit%2==0)
				System.out.println("#"+tc+" "+"Even");
			else
				System.out.println("#"+tc+" "+"Odd");
		}//end test cases
	}//end main
}
