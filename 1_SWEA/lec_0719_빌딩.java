package com.ssafy.algo;


import java.io.FileInputStream;
import java.util.Scanner;

public class Solution13 {
	static int T, N;
	static int Answer;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			char[][] area=new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					area[i][j] = sc.next().charAt(0);
				}
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			Answer=0;
			int count =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int g=0;
					
					if(area[i][j]=='B')	{
						if(Answer==0) Answer=2;          // B구획이라 일단 2층으로 초기화
						// 8방에 G 있는지 확인
						if(i-1>=0 && area[i-1][j]=='G') 
							g++; //상
						if(i-1>=0 && j+1<N && area[i-1][j+1]=='G')
							g++; //우상
						if(j+1<N && area[i][j+1]=='G')
							g++; //우
						if(i+1<N && j+1<N &&area[i+1][j+1]=='G')
							g++; //우하
						if(i+1<N && area[i+1][j]=='G')
							g++; //하
						if(i+1<N && j-1>=0 && area[i+1][j-1]=='G')
							g++; //좌하
						if(j-1>=0 && area[i][j-1]=='G')
							g++;  //좌
						if(i-1>=0 && j-1>=0 && area[i-1][j-1]=='G')
							g++;  //좌상

						
						//8방에 G없을때 확인 
						if(g==0){
							count=0; 
							// 세로 B 카운트
							for(int k=0; k<N; k++){
								if(area[k][j]=='B'){
									count++;
								}
							}
							// 가로 B 카운트
							for(int k=0; k<N; k++){
								if(area[i][k]=='B'){
									count++;
								}
							}
							// 중복제거
							count--;
							if(count>Answer) Answer=count;
						}
					}//end if B
				}//end for j
			}//end for i
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}