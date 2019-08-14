package solving2;

import java.util.Arrays;
import java.util.Scanner;

public class d3_4466_최대성적표만들기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int max=0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i]=sc.nextInt();
			}
			
			Arrays.sort(score);
			while(true) {
				max+=score[N-1];
				N--;
				K--;
				if(K<=0)
					break;
			}
			System.out.println("#"+tc+" "+max);
		}//end test cases
	}//end main
}
