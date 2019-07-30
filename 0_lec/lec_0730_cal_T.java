package day06_0730;

import java.util.Stack;

public class cal_T {
	public static void main(String[] args) {
		String expr = "2+3*4*2+7"; // 234*2*+7+
		//같은 우선순위를 만나면 꺼낸다. 더이상 기억할 이유가 없으니까.
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<expr.length(); i++) {
			char c = expr.charAt(i);
			
			//숫자만 출력
			if( Character.isDigit(c)) {
				System.out.print(c);
			}
			//연산자면 ~~
			else {
				//스택이 비어있으면 push
				if(stack.empty()) {
					stack.push(c);
				}
				else {
					
					if( c=='+' || c=='-') {
						while(!stack.empty() && stack.peek() != '(') {
							System.out.print(stack.pop());
						}
						stack.push(c);
					}
					else if(c=='*'|| c=='/') {
						//맨위에가 덧셈이면 push
						//맨위에가 곱셈이면 pop하고 push
						//아니면 poppopopop..
						while(!stack.empty() && stack.peek() != '+' && stack.peek()!='-' && stack.peek() != '(') 
							System.out.print(stack.pop());
						stack.push(c);
					}
					
					// 열린괄호는 무조건 들어가, 들어가서는 꼴등
					else if( c== '(') {
						stack.push(c);
					}
					else if(c==')') {
						char top = stack.peek();
						while(!stack.empty() && top != '(') {
							System.out.print(top);
							top = stack.pop();
						}
					}
				}
			}
			
		}//end for
		//남은거 다 꺼내기
		while(!stack.empty())
			System.out.print(stack.pop());
	}
}
