<<<<<<< HEAD
package day00_study;

import java.util.Scanner;

public class  d2_2001_파리퇴치 {
=======
package studyClass;

import java.util.Scanner;

public class d2_2001_파리퇴치 {
>>>>>>> b1bd487deddb5b0013e11bc66ea8fb0c5f0e44e7
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			// map 크기 
			int N = sc.nextInt();
			// 파리채 크기 
			int M = sc.nextInt();
			// map 크기만큼 배열 생성 
			int[][] map = new int[N][N];
			
			// map에 파리개수 입력받기   
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int MAX=0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					int result  = scan(map, i, j, M);
					if(MAX < result) {
						MAX = result;
					}
				}
			}
			
			
			System.out.println("#"+tc + " " + MAX);
			
		}//end test cases
		
	}//end main 
	
	static int scan(int[][] arr, int r, int c, int M) {
		int sum =0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				sum += arr[r+i][c+j];
			}
		}
		return sum;
	}//end scan method
<<<<<<< HEAD
=======
	
	
>>>>>>> b1bd487deddb5b0013e11bc66ea8fb0c5f0e44e7
}
