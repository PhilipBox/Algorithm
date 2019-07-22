package day03_0722;

import java.util.Scanner;

public class d3_5215_햄버거다이어트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int ts=1; ts<=T; ts++) {
			// 재료의 수
			int N = sc.nextInt();
			
			// 제한 칼로리
			int L = sc.nextInt();
			
			int[] score = new int[N];
			int[] cal = new int[N];
			
			// 재료의 수 만큼, 점수와 칼로리 입력하기
			for(int i=0; i<N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			int total_score=0;
			int total_cal=0;
			int temp_score =0;
			
			for(int i=0; i<(1<<N); i++) {
				total_score=0;
				total_cal=0;
				for(int j=0; j<N; j++) {
					
					if( (i&(1<<j)) != 0) {
						total_score += score[j];
						total_cal += cal[j];
					}
				}//end j loop
				if( (total_cal <= L) && (total_score >= temp_score) ) {
					temp_score = total_score;
				}
			}//end i loop

			System.out.println("#"+ts +" "+temp_score);
		}//end test cases
			
	}//end main
}
