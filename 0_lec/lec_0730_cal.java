package day06_0730;

import java.util.Scanner;
import java.util.Stack;

public class cal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		//공백까지 받기
		String sent = sc.nextLine();
		sent = sent.replace(" ", "");
		
		for(int i=0; i<sent.length(); i++) {
			char c = sent.charAt(i);
			//숫자면 출력
			if(Character.isDigit(c))
				System.out.print(c+" ");
			//처리
			else {
				//스택이 비었으면 푸시.
				if(stack.isEmpty()) {
					stack.push(c);
				}
				//덧셈이면
				else if(c=='+') {
					//스택 다 꺼내고 푸시
					while(!stack.isEmpty()) {
						System.out.print(stack.peek()+" ");
						stack.pop();
					}
					stack.push(c);
				}//end +
				//곱셈이면
				else if(c=='*') {
					if(stack.peek()=='*') {
						System.out.print(stack.peek()+" ");
						stack.pop();
						stack.push(c);
					}
					else if(stack.peek()=='+') {
						stack.push(c);
					}
				}//end * 
				else if(c=='(') {
					stack.push(c);
				}
				else if(c==')') {
					while(true) {
						if(stack.peek()=='(') {
							stack.pop();
							break;
						}
						System.out.print(stack.peek()+" ");
						stack.pop();
					}
				}
			}
		}//end for loop
		while(!stack.isEmpty()) {
			System.out.print(stack.peek()+" ");
			stack.pop();
		}
	}//end main
}
