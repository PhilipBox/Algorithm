package day06_0730;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix2 {
	
	static int prec(char op) {
		switch(op) {
		case '(': case ')' : return 0;
		case '+': case '-' : return 1;
		case '*': case '/' : return 2;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int n = sc.nextInt();
			String expr = sc.next();
			
			Stack<Character> stack = new Stack<>();
			StringBuilder postfix = new StringBuilder();
	
			for(int i=0; i<expr.length(); i++) {
				char c = expr.charAt(i);
				switch(c) {
				case '(' :
					stack.push(c);
					break;
					
				case ')' :
					char top;
					while((top = stack.pop()) != '(') {
						postfix.append(top);
//						System.out.print(top);
					}
				case '+':
				case '-':
				case '*':
				case '/' :
					while(!stack.empty() && prec(c) <= prec(stack.peek())) {
						postfix.append(stack.peek());
						stack.pop();
//						System.out.print(stack.pop());
					}
					stack.push(c);
					break;
					
				default : 
					postfix.append(c);
//					System.out.print(c);
					break;
				}//end switch
			}//end for
			while(!stack.empty()) {
				postfix.append(stack.peek());
				stack.pop();
//				System.out.print(stack.pop());
			}
//			System.out.println();
//			System.out.println(postfix);
			System.out.print("#"+tc+" ");
			cal(postfix);
		}
	}//end main
	
	static void cal(StringBuilder arr) {
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<arr.length(); i++) {
			char c = arr.charAt(i);
			//피연산자면
			if(Character.isDigit(c)) {
				stack.push(c-'0');
			}
			//연산자면
			else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				switch(c) {
				case '+':
					stack.push(num1+num2);
					break;
				case '-':
					stack.push(num1-num2);
					break;
				case '*' :
					stack.push(num1*num2);
					break;
				case '/' :
					stack.push(num1/num2);
					break;
				}
			}//end else
		}//end for
		System.out.println(stack.pop());
	}
	
}
