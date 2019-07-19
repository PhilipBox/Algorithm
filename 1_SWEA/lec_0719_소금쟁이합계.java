package com.ssafy.algo;


import java.io.FileInputStream;
import java.util.Scanner;

public class Solution22 {
	static long Answer;
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
			for(int ss=0; ss<S; ss++) {
				//시작자리에 소금쟁이 있는지 확인
				
				int cnt=3;
				int len = lake.length;
				Answer=0;
				int row, col;
				
				//상  - row변화
				if(strider[ss][2]==1) {
					row = strider[ss][0];
					col = strider[ss][1];
					
					//첫자리 1로 해주고
					lake[row][col]=1;
					
					//이제 점프 시작
					for(int i=0; i<3; i++) {
						row -= cnt; // 3.. 2.. 1..
						if(row<0) {	// 뛸자리가 영역밖이면
							lake[row+cnt][col]=0;	// 뛰기 전 자리 0으로 해줌 - 죽었으니까.
							//쥬금ㅠ
							break;
						}
						else {	// 뛸자리가 영역 내이면
							lake[row+cnt][col]=0;	//뛰기 전 자리 0으로
							lake[row][col]=1; //뛰고난 자리 1로.
							cnt--;	// cnt줄여줌 ( 3.. 2.. 1..)
						}
					}
				}//end if '1'- 상
				
				//하 - row변화
				else if (strider[ss][2]==2) {
					row = strider[ss][0];
					col = strider[ss][1];
					
					//첫자리 1로 해주고
					lake[row][col]=1;
					
					//이제 점프 시작
					for(int i=0; i<3; i++) {
						row += cnt; // 3.. 2.. 1..
						if(row>=len) {	// 뛸자리가 영역밖이면
							lake[row-cnt][col]=0;	// 뛰기 전 자리 0으로 해줌 - 죽었으니까.
							//쥬금ㅠ
							break;
						}
						else {	// 뛸자리가 영역 내이면
							lake[row-cnt][col]=0;	//뛰기 전 자리 0으로
							lake[row][col]=1; //뛰고난 자리 1로.
							cnt--;	// cnt줄여줌 ( 3.. 2.. 1..)
						}
					}
				}//end if '2'- 하
				
				//좌 - col변화
				else if (strider[ss][2]==3) {
					row = strider[ss][0];
					col = strider[ss][1];
					
					//첫자리 1로 해주고
					lake[row][col]=1;
					
					//이제 점프 시작
					for(int i=0; i<3; i++) {
						col -= cnt; // 3.. 2.. 1..
						if(col<0) {	// 뛸자리가 영역밖이면
							lake[row][col+cnt]=0;	// 뛰기 전 자리 0으로 해줌 - 죽었으니까.
							//쥬금ㅠ
							break;
						}
						else {	// 뛸자리가 영역 내이면
							lake[row][col+cnt]=0;	//뛰기 전 자리 0으로
							lake[row][col]=1; //뛰고난 자리 1로.
							cnt--;	// cnt줄여줌 ( 3.. 2.. 1..)
						}
					}
				}//end if '3' - 좌
				//우 - col변화
				else if (strider[ss][2]==4) {
					row = strider[ss][0];
					col = strider[ss][1];
					
					//첫자리 1로 해주고
					lake[row][col]=1;
					
					//이제 점프 시작
					for(int i=0; i<3; i++) {
						col += cnt; // 3.. 2.. 1..
						if(col>=len) {	// 뛸자리가 영역밖이면
							lake[row][col-cnt]=0;	// 뛰기 전 자리 0으로 해줌 - 죽었으니까.
							//쥬금ㅠ
							break;
						}
						else {	// 뛸자리가 영역 내이면
							lake[row][col-cnt]=0;	//뛰기 전 자리 0으로
							lake[row][col]=1; //뛰고난 자리 1로.
							cnt--;	// cnt줄여줌 ( 3.. 2.. 1..)
						}
					}
				}//end if '4' - 우		
			}//end 소금쟁이 수 만큼 loop

			for(int i=0; i<lake.length; i++) {
				for(int j=0; j<lake.length; j++) {
					if(lake[i][j]==1)
						Answer++;
				}
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}//end test cases
	}//end main
}
