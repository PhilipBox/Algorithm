package day03_0722;

import java.util.Random;
import java.util.Scanner;

public class 연습문제1 {
//						상	하	좌	우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[5][5];
		
		Random random = new Random();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
//				arr[i][j] = random.nextInt(25);
				arr[i][j] = (int) (Math.random()*25)+1;
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
		
		//상 하 좌 우 
		
		int sum=0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				
				//나 : arr[i][j], 4방 중 현재검색하는애 : arr[i+dr][j+dc] <-여기를 그냥 가면 안되고, 범위안에 있는지 확인해.
				for(int k=0; k<4; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					//범위 내에 있다면
					if(nr >=0 && nr<5 && nc >=0 && nc<5) {
						sum += Math.abs(arr[i][j] - arr[nr][nc]);
					}
				}
			}
		}
		
		
		System.out.println("abs total sum : " + sum);
		
	}//end main
}
