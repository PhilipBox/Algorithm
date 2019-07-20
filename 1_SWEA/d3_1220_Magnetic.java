package studyClass;

import java.util.Scanner;

public class d3_1220_Magnetic {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int[][] map = new int[100][100];
		
		for(int ts=1; ts<=10; ts++) {
			int T = sc.nextInt();
			
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int flag = 0;
			int cnt = 0;
			
			for(int i=0; i<100; i++) {
				// 세로 한줄씩 scan
				for(int j=0;j<100; j++) {
					
					if(map[j][i]==1) {
						flag=1;
					}
					if(flag==1 && map[j][i]==2) {
						cnt++;
						flag=2;
					}
					
				}
				//flag 초기화 
				flag =0;
			}
			 System.out.println("#"+ ts + " " + cnt);
		}//end test cases
	}//end main
}
