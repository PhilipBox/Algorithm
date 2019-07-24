package day04_0723;

import java.util.Scanner;

public class d2_1974_스도쿠검증 {
				// 상 하 좌 우 , 좌상 좌하, 우상 우하, 그대로.
	static int[] dr = {-1,1,0,0,-1,1,-1,1,0};
	static int[] dc = {0,0,-1,1,-1,-1,1,1,0};
	
	static int[] center_r = {1,1,1,4,4,4,7,7,7};
	static int[] center_c = {1,4,7,1,4,7,1,4,7};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] map = new int[9][9];
		
		for(int tc=1; tc<=T; tc++) {
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//9중심 스캔
			// (1,1) (1,4) (1,7)
			// (4,1) (4,4) (4,7)
			// (7,1) (7,4) (7,7)
			int cnt=0;
			// 9중심 상자 스캔
			for(int i=0; i<9; i++) {
					int sq_r = center_r[i];
					int sq_c = center_c[i];
					if(check_square(map, sq_r, sq_c)) {
						cnt++;
					}
					//true면 9개 조건만족
					//false면 불만족
			}
			
			int flag=1;
			for(int i=0; i<9; i++) {
				//가로 합 확인
				if(!check_boolean_hor(map,i)) {
					flag=0;
					break;
				}
				//세로 합 확인
				if(!check_boolean_ver(map,i)) {
					flag=0;
					break;
				}
			}
			
			System.out.print("#"+tc);
			if(cnt==9 && flag==1) {
				System.out.println(" 1");
			}
			else {
				System.out.println(" 0");
			}
		}//end test cases
	}//end main 
	
	//9개의 중심의 합을 검사하기 위한 method
	static boolean check_square(int[][] arr, int r, int c) {
		
		boolean[] digit = new boolean[10];
		for(int i=0; i<9; i++) {
			int value = arr[r+dr[i]][c+dc[i]];
			digit[value]=true;
		}
		for(int i=1;i<=9;i++) {
			if(digit[i]==false) {
				return false;
			}
		}
		
		return true;
	}//end check_square

	static boolean check_boolean_hor(int[][] arr, int r) {
		boolean[] digit = new boolean[10];
		for(int i=0; i<9; i++) {
			digit[arr[r][i]]=true;
		}
		
		for(int i=1;i<=9;i++) {
			if(digit[i]==false) {
				return false;
			}
		}
		return true;
	}//end check_boolean method

	static boolean check_boolean_ver(int[][] arr, int c) {
		boolean[] digit = new boolean[10];
		for(int i=0; i<9; i++) {
			digit[arr[i][c]]=true;
		}
		
		for(int i=1;i<=9;i++) {
			if(digit[i]==false) {
				return false;
			}
		}
		return true;
	}//end check_boolean method

}
