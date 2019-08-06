package day00_study;

import java.util.Scanner;

public class d3_6913_동철이의프로그래밍대회 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] person = new int[N][M];
			//1의 개수를 담을 곳.
			int[] solved = new int[N];
			
			
			//입력 & 맞춘개수 넣기
			for(int i=0; i<N; i++) {
				int cnt = 0;
				for(int j=0; j<M; j++) {
					int score = sc.nextInt();
					person[i][j] = score;
					if(score==1)
						cnt++;
				}
				solved[i]= cnt;
			}
			
			//최대값 찾기
			int MAX=-1;
			for(int i=0; i<N; i++) {
				if(MAX < solved[i]) {
					MAX = solved[i];
				}
			}
			
			// 최대값인 사람의 수
			int MAX_cnt = 0;
			for(int i=0; i<N; i++) {
				if(MAX == solved[i])
					MAX_cnt++;
			}
			
			System.out.println("#"+tc+" "+MAX_cnt+" "+MAX);
			
		}//end test cases
	}//end main
}
