package day00_study;

import java.util.LinkedList;
import java.util.Scanner;

public class d3_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1을 10으로 변경
		for (int ts=1; ts<=2; ts++){
			int t = sc.nextInt();//테스트케이스 받음
			
			// 리스트 생성
			LinkedList<Integer> arr = new LinkedList<Integer>();
			
			// 리스트에 데이터 입력
			for(int i=0; i<8; i++) {
				int input = sc.nextInt();
				arr.add(input);
			}
			int flag = 0;
			while(flag==0) {
				// 맨앞 1~5감소후 맨뒤로, (5까지 다돌면 사이클 1 소모)
				// 감소시키다가, 0보다 작아지면 그 값을 0으로해서 맨 뒤로 보내고 종료. (사이클 종료, 암호 도출)
				for(int i=0; i<5; i++) {
					//가장 첫번째 수를 1부터 뺀다.
					int tmp = arr.get(0) - (i+1);
					if(tmp<=0) {
						//0보다 같거나 작으면, 0을 맨 뒤에 add
						arr.add(0);
						//뒤에 더했으니, 첫번째 수 제거
						arr.remove(0);
						flag=1;
						break;
					}
					else {
						//첫번째 수 뺀 값, 맨 뒤로 add
						arr.add(tmp);
						//뒤에 더했으니, 첫번째 수 제거
						arr.remove(0);
					}
				}
			}
			System.out.print("#"+ts);
			for(int i=0;i<8; i++) {
				System.out.print(" "+ arr.get(i));
			}
			System.out.println();
		}//end test cases
	}//end main
}
