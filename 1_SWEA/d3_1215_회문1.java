package day00_study;

import java.util.Scanner;

public class d3_1215_회문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char board[][] = new char[8][8];
		char vertical[][] = new char[8][8];
		//10인데 나중에 지우셈
		
		for(int ts=1; ts<=10; ts++) {
			// 펠린드롬 넘버 받기
			int pldr = sc.nextInt();
			int cnt = 0;
			
			
			//board 입력받기
			for(int i=0; i<8; i++) {
				String board_list = sc.next();
				for(int j=0; j<8; j++) {
					board[i][j] = board_list.charAt(j);
				}
			}
			
			//board 세로버전
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					vertical[i][j] = board[j][i];
				}
			}
			
			
			int mid = pldr/2;
			//펠린드롬 넘버가 짝수일경우
			if(pldr%2==0) {
				for(int i=0;i<8;i++) {

					for(int j=0; j<8-pldr+1; j++) {
						int start = j;
						int back = 0;
						
						for(int k=0; k<mid; k++) {
							if(board[i][start]==board[i][j+pldr+back-1]) {
								start++;
								back--;
								if((k+1)==mid) {
									cnt++;
									continue;
								}
							}
							else {
								break; //주의
							}
						}
					}//end j loop
					
				}
			}
			//펠린드롬 넘버가 홀수일경우
			else {
				for(int i=0;i<8;i++) {
					if(pldr==1) {
						cnt=64;
						break;
					}// 1 예외처리
					for(int j=0; j<8-pldr+1; j++) {
						int start = j;
						int back = 0;
						
						for(int k=0; k<mid; k++) {
							if(board[i][start]==board[i][j+pldr+back-1]) {
								start++;
								back--;
								if((k+1)==mid) {
									cnt++;
									continue;
								}
							}
							else {
								break; //주의
							}
						}
					}//end j loop
				}
			}
			//board 가로 펠린드롬 탐색 완료
		
			
			//board 세로 펠린드롬 탐색 시작
			if(pldr%2==0) {
				for(int i=0;i<8;i++) {

					for(int j=0; j<8-pldr+1; j++) {
						int start = j;
						int back = 0;
						
						for(int k=0; k<mid; k++) {
							if(vertical[i][start]==vertical[i][j+pldr+back-1]) {
								start++;
								back--;
								if((k+1)==mid) {
									cnt++;
									continue;
								}
							}
							else {
								break; //주의
							}
						}
					}//end j loop
					
				}
			}
			
			//펠린드롬 넘버가 홀수일경우
			else {
				for(int i=0;i<8;i++) {
					if(pldr==1) {
						cnt=64;
						break;
					}// 1 예외처리
					for(int j=0; j<8-pldr+1; j++) {
						int start = j;
						int back = 0;
						
						for(int k=0; k<mid; k++) {
							if(vertical[i][start]==vertical[i][j+pldr+back-1]) {
								start++;
								back--;
								if((k+1)==mid) {
									cnt++;
									continue;
								}
							}
							else {
								break; //주의
							}
						}
					}//end j loop
				}
			}
			
			
			
			//total case 완료
			System.out.println("#"+ts +" "+cnt);
			
		}//10 test cases
	
	}
}
