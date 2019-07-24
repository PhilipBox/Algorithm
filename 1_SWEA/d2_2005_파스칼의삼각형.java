package studyClass;

import java.util.Scanner;

public class d2_2005_파스칼의삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {
				if(i==0) {
					map[0][0]=1;
					continue;
				}
				for(int j=0; j<N; j++) {
					if(i<j)
						break;
					else {
						if(j==0) {
							map[i][j]=1;
						}
						else {
							map[i][j] = map[i-1][j-1] + map[i-1][j];
						}
					}
				}//end j
			}//end i loop

			System.out.println("#"+tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i<j)
						break;
					else {
						System.out.print(map[i][j]+" ");
					}
				}
				System.out.println();
			}
		}//end test cases
	}
}