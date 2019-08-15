package selfStudy;

import java.util.Scanner;

public class d3_1493_수의새로운연산 {
	static int[][] map = new int[400][400];
	static int posRow=0;
	static int posCol=0;
	public static void main(String[] args) {
		int row=1;
		int col=1;
		int val=1;
		for(int i=1; i<=399; i++) {
			row=i;
			col=1;
			while(true) {
				map[row][col] = val;
				row--;
				col++;
				
				val++;
				if(row==0)
					break;
			}
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			posRow=0;
			posCol=0;
			int val1 = sc.nextInt();
			int val2 = sc.nextInt();
			getPos(val1, val2);
			System.out.println("#"+tc+" "+map[posRow][posCol]);
		}//end test cases
	}//end main
	
	//일단 두번해보자 
	static void getPos(int val1, int val2) {
		int flag=0;
		for(int i=1; i<=399; i++) {
			for(int j=1; j<=399; j++) {
				if(map[i][j]==val1) {
					posRow += i;
					posCol += j;
					flag++;
				}
				if(map[i][j]==val2) {
					posRow += i;
					posCol += j;
					flag++;
				}
				if(flag==2)
					break;
			}
			if(flag==2)
				break;
		}
	}//end getPos method
}
