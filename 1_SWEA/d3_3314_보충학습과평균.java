package day00_study;

import java.util.Scanner;

public class d3_3314_보충학습과평균 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			//평균을 구하기 위한 합
			int sum=0;
			
			for(int i=0; i<5; i++) {
				int score = sc.nextInt();
				if(score<40) {
					score=40;
				}
				sum+= score;
			}
			System.out.println("#"+tc+" "+(sum/5));
		}//end test cases
	}//end main
}
