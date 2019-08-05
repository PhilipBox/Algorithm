package day00_study;

import java.util.Arrays;
import java.util.Scanner;

public class d2_1983_조교의성적매기기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] grade = {"D0","C-","C0","C+","B-","B0","B+","A-","A0","A+"};
		for (int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int K_score=0;
			int[] total_score = new int[N];
			
			for(int i=0; i<N; i++) {
				int score1 = sc.nextInt();
				int score2 = sc.nextInt();
				int score3 = sc.nextInt();
				total_score[i] = score1*35 + score2*45 + score3*20;
				if(i == K-1)
					K_score = total_score[i];
			}
			
			Arrays.sort(total_score);
			int K_idx =-1;
			for(int i=0; i<N; i++) {
				if(total_score[i]==K_score) {
					K_idx = i;
				}
			}			
			int ans = K_idx/(N/10);
			System.out.println("#"+tc+" "+grade[ans]);
			
		}//end test cases
	}//end main
}
