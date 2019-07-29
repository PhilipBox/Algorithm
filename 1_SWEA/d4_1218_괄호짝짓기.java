package day05_0729;

import java.util.Scanner;

public class d4_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//tc 10으로 바꿀것
		for(int tc=1; tc<=1; tc++) {
			//괄호문의 길이
			int L = sc.nextInt();
			
			//각 괄호문자의 빈도를 확인할 배열
			int[] flag = { 0,0,0,0};
			
			//괄호문을 받음.
			String arr = sc.next();
			System.out.print("#"+tc+" ");
			
			for(int i=0; i<arr.length(); i++) {
				char c = arr.charAt(i);
				if(check(flag, c)==false) {
					flag[0]=-1;
					break;
				}
				else {
					if(c == '(') {
						flag[0]++;
					}
					else if(c== '[') {
						flag[1]++;
					}
					else if(c=='{') {
						flag[2]++;
					}
					else if(c=='<') {
						flag[3]++;
					}
				}
			}
			boolean result = true;
			for(int i=0; i<4; i++) {
				if(flag[i]!=0) {
					result = false;
					break;
				}
			}
			if(result) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}//end test cases
	}//end main
	
	static boolean check(int[] arr, char c) {
		// () = 0 ,  [] = 1, {} = 2 , <> = 3
		if(c == ')') {
			if(arr[0]<=0)
				return false;
			else {
				arr[0]--;
				return true;
			}
		}
		else if(c== ']') {
			if(arr[1]<=0)
				return false;
			else {
				arr[1]--;
				return true;
			}
		}
		else if(c=='}') {
			if(arr[2]<=0)
				return false;
			else {
				arr[2]--;
				return true;
			}
		}
		else if(c=='>') {
			if(arr[3]<=0)
				return false;
			else {
				arr[3]--;
				return true;
			}
		}
		return true;
	}//end check method
}
