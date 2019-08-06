package day00_study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d3_1228_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++) {
			
			List<Integer> pw = new ArrayList<Integer>();

			//암호문의 길이 입력
			int len = sc.nextInt();
			for(int i=0; i<len; i++) {
				//암호문 입력
				pw.add(sc.nextInt());
			}
			
			//명령어 개수 입력
			int cmd_cnt = sc.nextInt();
			
			// I 입력
			for(int i=0; i<cmd_cnt; i++) {
				String insert = sc.next(); 
				//위치 입력
				int x = sc.nextInt();
				//개수 입력
				int y = sc.nextInt();

				// x위치부터  y만큼 넣기
				for(int j=0; j<y; j++) {
					pw.add(x+j, sc.nextInt());
				}
				
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				System.out.print(pw.get(i)+" ");
			}
			System.out.println();
			
		}//end test cases
	}// end main
}
