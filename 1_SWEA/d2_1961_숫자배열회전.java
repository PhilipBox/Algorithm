package day00_study;

import java.util.Scanner;

public class d2_1961_숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			String[] num = new String[N*N];
			String[][] map = new String[N][N];
			
			//결과를 담을 String 배열 , null대신 초기화.
			String[][] str = new String[N][3];
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					str[i][j] ="";
				}
			}
			
			// 입력받은 숫자를 1열로 받기
			for(int i=0; i<N*N; i++) {
				num[i] = sc.next();
			}
			
			// 90도 회전
			right_angle(map, num, N);
			numbering(map, num, N);
			
			int cnt=0;
			for(int i=0;i<N;i++) {
				while(true) {
					str[i][0] += num[cnt];
					cnt++;
					if(cnt%N==0)
						break;
				}
			}
			
			// 180도 회전
			right_angle(map, num, N);
			numbering(map, num, N);
			right_angle(map, num, N);
			cnt=0;
			for(int i=0;i<N;i++) {
				while(true) {
					str[i][1] += num[cnt];
					cnt++;
					if(cnt%N==0)
						break;
				}
			}
			
			// 270도 회전
			right_angle(map, num, N);
			numbering(map, num, N);
			right_angle(map, num, N);
			cnt=0;
			for(int i=0;i<N;i++) {
				while(true) {
					str[i][2] += num[cnt];
					cnt++;
					if(cnt%N==0)
						break;
				}
			}
			
			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<3; j++) {
					System.out.print(str[i][j] + " ");
				}
				System.out.println();
			}
		}//end test cases
	}//end main
	
	static void right_angle(String[][] maps, String[] nums, int N) {
		int cnt=0;
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<N; j++) {
				maps[j][i]= nums[cnt];
				cnt++;
			}
		}
	}//end right_angle method 
	
	static void numbering(String[][] maps, String[] nums, int N) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				nums[cnt] = maps[i][j];
				cnt++;
			}
		}
		
	}//end nunbering method
}
