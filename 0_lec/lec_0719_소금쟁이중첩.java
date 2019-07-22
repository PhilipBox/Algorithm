package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution21 {
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution22.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//테스트 케이스 수

		for(int test_case=1; test_case<=T; test_case++){
			N=sc.nextInt(); //배열의 크기 NxN
			int[][] lake=new int[N][N];

			S=sc.nextInt();//소금쟁이(Strider)수
			int[][] strider=new int[S][3];
			for(int k=0; k<S; k++){
				strider[k][0]=sc.nextInt();//행위치
				strider[k][1]=sc.nextInt();//열위치
				strider[k][2]=sc.nextInt();//방향(1:하,2:우)
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
				
			//strider[0][0]행 / [1]열 / [2]방향
			//ss는 소금쟁이 넘버 
			for(int ss=0; ss<S; ss++) {
				
				int cnt=3;
				int len = lake.length;
				int row, col;
				row = strider[ss][0];
				col = strider[ss][1];
				
				// 범위 밖 flag : -1, 이미 밟았던 곳 : 1
				int flag=0;
				
				//처음 뛰려는 자리가 이미 뛰었던 자리인지 확인 
				//이미 뛰었던 곳이면 결과 출력하고 바로 break해서 다음 test case로.
				if(lake[row][col]==1) {
					System.out.println("#"+test_case + " "+(ss+1));
					break;
				}
				
				
				//아래  - row변화
				if (strider[ss][2]==1) {
					//이제 점프 시작
					for(int i=0; i<3; i++) {
						
						row += cnt; // 3.. 2.. 1..
						if(row>=len) {	// 뛸자리가 영역밖이면,그만뛰엇!
							flag=-1;
							break;
						}
						else {	// 뛸자리가 영역 내이면
							if(lake[row][col]==1) {	//뛸 자리가 이미 밟았던 곳이면, 결과 출력하고 다음 test_case로 보내기 위한 flag=1
								System.out.println("#"+test_case + " " + (ss+1));
								flag=1;
								break;
							}							
							else {	// 뛸 자리가 아무도 밟지 않았던 곳이면, 밟았다는 표시해주고 다음 점프로 ㄱ
								lake[row][col]=1; //뛰고난 자리 1로.
								cnt--;	// cnt줄여줌 ( 3.. 2.. 1..)
							}
						}
					}// 소금쟁이 3회 점프 반복문 종료 
					
					// 뛸자리가 범위 밖이니까 다음 소금쟁이로! 
					if(flag== -1 && (ss+1 != S)) //마지막 소금쟁이는 그대로 진행하도록 뒤의(ss+1 != S) 조건 추가 
						continue;
					// 이미 뛰었던 자리! 출력완료함 다음 케이스로.
					else if(flag== 1 && (ss+1 != S)) //마지막 소금쟁이는 그대로 진행하도록 뒤의(ss+1 != S) 조건 추가 
						break;						
				}//end if '1'- 하
				
				//오른쪽  - col변화
				else if (strider[ss][2]==2) {
					//이제 점프 시작
					for(int i=0; i<3; i++) {
						//뛸 자리가 범위 내인지 확인 
						col += cnt; // 3.. 2.. 1..
						if(col>=len) {	// 뛸자리가 영역밖이면, 그만뛰엇!
							flag=-1;
							break; // 점프 반복문 out
						}
						else {	// 뛸자리가 영역 내이면
							if(lake[row][col]== 1) { //뛸 자리가 이미 밟았던 곳이면, 결과 출력하고 다음 test_case로 보내기 위한 flag=1
								System.out.println("#"+test_case + " " + (ss+1));
								flag=1;
								break;
							}
							else {		// 뛸 자리가 아무도 밟지 않았던 곳이면, 밟았다는 표시해주고 다음 점프로 ㄱ
							lake[row][col]=1; //뛰고난 자리 1로.
							cnt--;	// cnt줄여줌 ( 3.. 2.. 1..)
							}
						}
					}//소금쟁이 3회점프 반복문
					
					// 뛸자리가 범위 밖이니까 다음 소금쟁이로! 
					if(flag== -1 && (ss+1 != S)) //마지막 소금쟁이는 그대로 진행하도록 뒤의(ss+1 != S) 조건 추
						continue;
					// 이미 뛰었던 자리! 출력완료함 다음 케이스로.
					else if(flag== 1 && (ss+1 != S)) //마지막 소금쟁이는 그대로 진행하도록 뒤의(ss+1 != S) 조건 추
						break;
				}//end if '4' - 우
				
			if((ss+1) >= S)
					System.out.println("#"+test_case+" 0");
			}//end 소금쟁이 수 만큼 loop
		}//end test cases
	}//end main
}