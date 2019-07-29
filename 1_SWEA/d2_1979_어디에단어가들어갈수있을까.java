package day00_study;

import java.util.Scanner;

public class d2_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// test case
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			//map 크기
			int N = sc.nextInt();
			
			//글자길이
			int K = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			// map 입력
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int tmp =0;
			int cnt=0;
			//가로탐색
			for(int i=0; i<N; i++) {
				tmp=0;
				for(int j=0; j<N; j++) {
					//일반 벽 체크
					if(map[i][j]==0) {
						if(tmp==K) {
							cnt++;
							tmp=0;
						}
						tmp=0;
						continue;
					}
					else {
						tmp++;
						//마지막 열 체크.
						if(j==N-1 && tmp==K) {
							cnt++;
							tmp=0;
						}
					}
					
				}
			}

			//세로탐색
			for(int i=0; i<N; i++) {
				tmp=0;
				for(int j=0; j<N; j++) {
					//일반 벽 체크
					if(map[j][i]==0) {
						if(tmp==K) {
							cnt++;
							tmp=0;
						}
						tmp=0;
						continue;
					}
					else {
						tmp++;
						//마지막 열 체크.
						if(j==N-1 && tmp==K) {
							cnt++;
							tmp=0;
						}
					}
					
				}
			}
			System.out.println("#"+tc +" " + cnt);
			
		}//end test cases
	}
}
