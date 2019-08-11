package studyClass;

import java.util.Scanner;

public class d3_1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			int row=0;
			int col=0;
			int val=1;
			while(true) {
				
				for(int i=0; i<N; i++) {
					map[row][col++]=val++;
				}
				N--;
				if(N==0)
					break;
				col--;
				
				for(int i=0; i<N; i++) {
					map[++row][col] = val++;
				}
				
				
				for(int i=0; i<N; i++) {
					map[row][--col] = val++;
				}
				N--;
				if(N==0)
					break;
				
				for(int i=0; i<N; i++) {
					map[--row][col] = val++;
				}
				col++;
			}//end while
			
			System.out.println("#"+tc);
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			//전체출력
		}//end test cases
	}
}
