package day03_0722;

import java.util.Scanner;


public class d4_1210_Ladder1 {
	static int N = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int ts=1; ts<=10; ts++) {
			int T = sc.nextInt();

			int[][] map = new int[N][N];
			// 사다리 지도 입력
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//도착 지점 찾기
			for(int i=0; i<N; i++) {
				if (map[N-1][i]==2) {
					System.out.print("#"+ts+" ");
					route(map,N-1,i);
				}
			}
		}//end test cases
	}//end main
	
	static void route(int[][] arr, int r, int c) {
		//왼쪽에 길이 있다면
		if(  (c-1>=0) && arr[r][c-1]==1) {
			arr[r][c]=0;
			route(arr, r, c-1);
		}
		//오른쪽에 길이 있다면
		else if((c+1<N)&&arr[r][c+1]==1) {
			arr[r][c]=0;
			route(arr, r, c+1);
		}
		//위에 길이 있다면
		else if( (r-1>=0) && arr[r-1][c]==1) {
			arr[r][c]=0;
			route(arr, r-1, c);
		}
		//끝.
		else if( r-1<0) {
			System.out.println(c);
		}
	}//end route method
}
