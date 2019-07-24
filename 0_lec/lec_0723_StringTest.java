package day04_0723;

import java.awt.Window.Type;

public class StringTest {
	public static void main(String[] args) {
		String str="010-9211-1220";
		
		for(int i=0; i<str.length(); i++) {
			//특정 위치의 글자를 얻어오고 싶으면 charAt
			char c = str.charAt(i);
			
			//특정 글자가 숫자인지 검사
			if(Character.isDigit(c)) {
				System.out.println("숫자");
			}
			
			//특정 글자가 알파벳인지 검사
			if(Character.isAlphabetic(c)) {
				System.out.println("알파벳");
			}
		}//end for loop
		
		String myStr = "Moon" + " " + "Ji" + " " + "Hwan" + 3;
		System.out.println(myStr);
		
		//문자열은 합쳐주는게 나아.
		StringBuilder sb = new StringBuilder();
		sb.append("Philip").append(" ").append("Box").append(" ").append(3);
		
		// toString을 안하면 개별적으로 출력하는거고
		// toString을 하면 하나의 string으로 만들어주는 것.
		System.out.println(sb.toString());
		
		// 더 사용을 한다면 새로운 String에 넣어줄 수 있겠지.
		String newstr = sb.toString();
		System.out.println(newstr);
		
	}//end main
}
