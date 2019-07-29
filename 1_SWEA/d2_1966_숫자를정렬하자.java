package day00_study;

import java.util.Scanner;

public class d2_1966_숫자를정렬하자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			for(int i=0; i<N; i++) {
				num[i] =sc.nextInt();
			}
			
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<N-i-1; j++) {
					if(num[j]>=num[j+1]) {
						int temp = num[j];
						num[j]=num[j+1];
						num[j+1] = temp;
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<N; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}//end test cases;
	}//end main
}
