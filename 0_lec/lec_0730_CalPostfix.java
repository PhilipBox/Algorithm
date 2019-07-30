package day06_0730;

import java.util.Stack;

public class CalPostfix {
	public static void main(String[] args) {
		String expr = "232*+13*+";
		//식을 순회하면서
		//피연산자면 스택에 담는다.
		//연산자면 스택에서 숫자 두개 꺼내서 해당 연산 후 결과를 스택에 담는다.
		
		// 마지막에 스택에 들어있는 그 하나의 숫자가 정답!
		
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<expr.length(); i++) {
			char c = expr.charAt(i);
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
