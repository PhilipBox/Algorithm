package day00_study;

import java.util.Scanner;

public class d3_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// test case 입력
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			// 농장의 크기 입력
			int N = sc.nextInt();

			// 농장에 입력받기
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				String num = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j]= num.charAt(j)-'0';
				}
			}
			
			
			int total = 0;
			int row=1;

			//중간라인 합
			for(int i=0; i<N; i++) {
				total += map[N/2][i];
			}
			
			//중간아래  합
			for(int i=N/2+1; i<=N; i++) {
				for(int j=0+row; j<N-row; j++) {
					total += map[i][j];
				}
				row++;
			}
			
			//중간 위 합
			row=N/2;
			for(int i=0; i<N/2; i++) {
				for(int j=row; j<N-row; j++) {
					total+= map[i][j];
				}
				row--;
			}
			System.out.println("#"+tc+" "+total);
			
		}//test cases
	}
}
