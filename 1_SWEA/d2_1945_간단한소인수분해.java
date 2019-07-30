package studyClass;

import java.util.Scanner;

public class d2_1945_간단한소인수분해 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int[] digit = new int[5]; //2,3,5,7,11의 지수를 담을 배열
			
			while(N!=1) {
				
				if(N%2==0) {
					N/= 2;
					digit[0]++;
				}
				else if(N%3==0) {
					N/= 3;
					digit[1]++;
				}
				else if(N%5==0) {
					N/=5;
					digit[2]++;
				}
				else if(N%7==0) {
					N/=7;
					digit[3]++;
				}
				else if(N%11==0) {
					N/=11;
					digit[4]++;
				}
				
				if(N==1)
					break;
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<5; i++) {
				System.out.print(digit[i] + " ");
			}
			System.out.println();
		}//end test cases
	}//end main
}
