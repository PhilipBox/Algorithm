package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution32 {
	static int Answer;
	static int Y, X, N, P;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution32.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // Test case

		// fill up the data
		for (int test_case = 1; test_case <= T; test_case++) {

			Y = sc.nextInt(); // position row
			X = sc.nextInt(); // position col
			N = sc.nextInt(); // number of player

			int[][] room = new int[Y + 1][X + 1];// because start from 1;
			// fill up table
			for (int i = 1; i <= Y; i++) {
				for (int j = 1; j <= X; j++) {
					room[i][j] = sc.nextInt();
				}
			}

			int[][] player = new int[N][3];
			for (int i = 0; i < N; i++) {
				player[i][0] = sc.nextInt(); // coord Y
				player[i][1] = sc.nextInt(); // coord X
				player[i][2] = sc.nextInt(); // steps
			}

			P =sc.nextInt();
			int[][] trap=new int[P][2];
			for(int i = 0; i < P; i++){
				trap[i][0] = sc.nextInt();
				trap[i][1] = sc.nextInt();
				//trap위치 room에 반영
				room[trap[i][0]][trap[i][1]]=0;
			}
			
			// 참가자 수만큼 참가비 지불
			Answer= -1000*N;
			
			//사람 수 만큼 놀이 진행
			for(int person=0; person<N; person++) {
				int cnt = player[person][2]; // 점프 기회 횟수
				
				//처음 플레이어의 좌표 get
				int row = player[person][0];
				int col = player[person][1];
				
				//지도상의 플레이어 위치 값 get
				int pos = room[row][col];
				
				//위치 값 해석
				int direction = pos/10; // 몫: 방향
				int move = pos%10;	// 나머지 : 이동
				
				// 시작하자마자 함정이면 실패. continue로 다음사람에게 기회를.
				if(pos == 0) {
					Answer +=0;
					continue;
				}
					
				for(int chance=0; chance<cnt; chance++) {
					//위치 값 해석
					direction = pos/10; // 몫: 방향
					move = pos%10;		// 나머지 : 이동하는 칸
					
					//상 - row 변화 
					if(direction==4) {
						
						if(row-move<=0) {	// 이동했을 때 범위 밖이면.
							break;
						}
						else {
							row -= move;	// move만큼 이동.
							pos = room[row][col];	// 이동했을 때 값.
						}			
					}//end 상
					
					//하 - row 변화
					else if(direction==2) {
						if(row+move>Y) {	// 이동했을 때 범위 밖이면.
							break;
						}
						else {
							row += move;	// move만큼 이동.
							pos = room[row][col];	// 이동했을 때 값.
						}	
					}//end 하
					
					//좌 - col 변화
					else if(direction==3) {
						if(col-move<=0) {	// 이동했을 때 범위 밖이면.
							break;
						}
						else {
							col -= move;	// move만큼 이동.
							pos = room[row][col];	// 이동했을 때 값.
						}	
					}//end 좌
					
					//우 - col 변화
					else if(direction==1) {
						if(col+move>X) {	// 이동했을 때 범위 밖이면.
							break;
						}
						else {
							col += move;	// move만큼 이동.
							pos = room[row][col];	// 이동했을 때 값.
						}	
					}//end 우
					
					
					//모든 기회를 완료.
					if(chance==(cnt-1)) {
						Answer += (pos*100);
					}

				}//한명당 주어진 점프 기회 counting
			}//end person loop : 사람 수 만큼 - 놀이 종료
			
			
			System.out.println("#" + test_case + " " + Answer);
		}//end test cases

	}
}