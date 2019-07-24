package day03_0722;

import java.util.Scanner;

public class 공원 {
	
	//좌상 상 우상 좌 우 좌하 하 우하
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc <=T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++)
					map[i][j] = sc.next().charAt(0);
			}
			
			//전체 탐색하면서 B를 찾기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]== 'B') {
						//8방에 G가 있는지 검사.
							//근데 그냥 검사하면 안되고, 나가 떨어지는지 검사해야지.
							//근데 이런 코드는 실수하기 쉬워.
							//일일이 case별로 조건을 넣기 보다는..
						
						
						//내 위치가 i j라면 좌상은 i-1, j-1
						//내 위치가 i j라면 상은 i-1, j
						if(i-1 >=0 && j-1 >=0 && map[i-1][j-1] == 'G') {
							//좌상
						}
						else if(i-1 >= 0 && map[i-1][j] == 'G') {
							//상
						}
						else if(i-1>=0 && j+1<N && map[i-1][j+1]== 'G') {
							//우상
						}
						//...
						
						//아래 코드 구조를 추천
						//좌표를 변경해둔 후 사방 나가떨어짐을 검사하는 일관된 반복문 활용
						
						//아까처럼 하면 8개의 조건문이 생기잖아, 
						//그래서 위의 델타를 보자.
						for(int k=0; k<8; k++) {
							//내가 새로 도착한 row , col
							int nr = i+ dr[k];
							int nc = j+ dc[k];
							if(nr >=0 && nr<N && nc >=0 && nc<N) {

							
							}
						}
					}
					
				}//end j loop
			}//end i loop
			
			
		}
		
	}//end main
}
