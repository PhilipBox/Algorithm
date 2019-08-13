package bitmask;

import java.util.Scanner;

public class 연습문제2 {
	public static void main(String[] args) {
		//16진수 문자로 이루어진 1차 배열이 주어질 때, 앞에서부터 7bit씩 묶어 십진수로 변환하여 출력해보자
		
		//e.g.
		//0F97A3 일경우
		// 00001111110010111110100011
		
		char[] hex = {'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String[] binary = {"0000", "0001", "0010", "0100", "0101", "0110", 
				"1000", "1001", "1010", "1011", "1100", "1101", "1111"};
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if( c >= '0' && c<= '9') {
				//숫자 0~9로 만들고
				int idx = c - '0';
				sb.append(binary[idx]);
			}
			else if(c >= 'A' && c<='F') {
				//글자 10~15로 만들어서
				int idx = c - 'A' + 10;
				sb.append(binary[idx]);
			}
			
			
		}
		System.out.println(sb.toString());
		
	}
}
