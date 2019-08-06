package studyClass;

import java.util.Scanner;

public class d3_4751_다솔이의다이아몬드장식 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			String c = sc.next();
			
			firstLine(c.length());
			secondLine(c.length());
			mainLine(c.length(), c);
			secondLine(c.length());
			firstLine(c.length());
			
		}//end test cases
	}//end main
	
	static void firstLine(int n) {
		System.out.print("..#");
		for(int i=1;i<n;i++) {
			System.out.print("...#");
		}
		System.out.println("..");
	}
	
	static void secondLine(int n) {
		for(int i=0; i<n*2;i++) {
			System.out.print(".#");
		}
		System.out.println(".");
		
	}
	
	static void mainLine(int n, String str) {
		for(int i=0; i<n; i++) {
			System.out.print("#."+str.charAt(i)+".");
		}System.out.println("#");
	}
	
}
