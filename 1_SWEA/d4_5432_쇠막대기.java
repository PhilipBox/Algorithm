package day05_0729;

import java.util.Scanner;
import java.util.Stack;

public class d4_5432_쇠막대기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			Stack<Character> st = new Stack<>();
			String input = sc.next();
			int cnt=0;
			for(int i=0; i<input.length(); i++) {
				
				if(input.charAt(i)=='('){
					st.push(input.charAt(i));
				}
				else if(input.charAt(i)==')') {
					if(input.charAt(i-1)=='(') {
						st.pop();
						cnt+= st.size();
					}
					else if(input.charAt(i-1)==')') {
						cnt += 1;
						st.pop();
					}
				}
			}
			System.out.println("#"+tc + " " + cnt);
		}//end test cases
		
	}
}
