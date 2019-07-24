package day04_0723;

import java.util.Scanner;

public class d2_1989_초심자의회문검사 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int ts=1; ts<=T; ts++) {
			
			String str = sc.next();
			
			if(palin(str))
				System.out.println("#"+ts+" 1");
			else
				System.out.println("#"+ts+" 0");
		}
	}//end main
	
	static boolean palin(String str) {
		int flag=0;
		int start=0, end=str.length()-1;
		for(int i=0; i<str.length()/2; i++) {
			if(str.charAt(start)==str.charAt(end)) {
				start++;
				end--;
				flag=1;
			}
			else
				flag=0;
		}
		if(flag==1)
			return true;
		else
			return false;
	}//end palin method
}
