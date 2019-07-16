package day01_0715;

import java.util.Scanner;

public class d2_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // when N is 4,
			int[][] arr = new int[N][N];
			
			//맨 첫칸의 하나 왼쪽에서 시작..
			int row= 0, col= -1;
			//이동하는 위치에 적을 값
			int val=1;
			
			while(true) {
				// N이 4일떄, 이동 순서
				//오른쪽 네칸
				for(int i=0; i<N; i++) {
					col++;
					arr[row][col] = val++;
				}
				N--;
				if(N == 0)
					break;
				//아래로 세칸
				for(int i=0; i<N; i++) {
					row++;
					arr[row][col] = val++;
				}
				//왼쪽 세칸
				for(int i=0; i<N; i++) {
					col--;
					arr[row][col] = val++;
				}
				N--;
				if(N == 0)
					break;
				//위로 두칸
				for(int i=0; i<N; i++) {
					row--;
					arr[row][col] = val++;
				}
				// 패턴반복
				
			}//end while loop	
			System.out.println("#"+tc);
			for(int i=0; i< arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}//출력을 위한 loop
		}//end for loop
	}//end main
}//end class
