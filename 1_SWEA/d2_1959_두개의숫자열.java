package studyClass;

import java.util.Scanner;

public class d2_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max=0;
			int sum=0;
			// arr1 < arr2
			if(N>=M) {
				int[] arr2 = new int[N];
				for(int i=0; i<N; i++) {
					arr2[i] = sc.nextInt();
				}
				
				int[] arr1 = new int[M];
				for(int i=0; i<M; i++) {
					arr1[i] = sc.nextInt();
				}
			
				//탐색
				max = 0;
				for(int i=0; i<N-M+1; i++) {
					sum=0;
					for(int j=i; j<i+M; j++) {
						sum += (arr1[j-i]*arr2[j]);
					}
					if(max<sum)
						max=sum;
				}
			}//end if
			else {
				int[] arr1 = new int[N];
				for(int i=0; i<N; i++) {
					arr1[i] = sc.nextInt();
				}
				
				int[] arr2 = new int[M];
				for(int i=0; i<M; i++) {
					arr2[i] = sc.nextInt();
				}
			
				//탐색
				max = 0;
				for(int i=0; i<M-N+1; i++) {
					sum=0;
					for(int j=i; j<i+N; j++) {
						sum += (arr1[j-i]*arr2[j]);
					}
					if(max<sum)
						max=sum;
				}	
			}//end else
			System.out.println("#"+tc+ " "+max);
		}//end test cases
	}//end main
}
