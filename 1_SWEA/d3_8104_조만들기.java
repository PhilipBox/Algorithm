package studyClass;

import java.util.Scanner;

public class d3_8104_조만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] team = new int[K][N];
			
			int row=-1;
			int col=0;
			int val=1;
			
			// 조원 분배하기.
			while(true) {
				if(K==1) {
					System.out.println("#"+tc+" "+N*(N+1)/2);
					break;
				}
				
				//아래로 가
				while(true) {
					team[++row][col]=val++;
					if(val>N*K)
						break;
					if(row==K-1) {
						team[row][++col]=val++;
						break;
					}
				}

				if(val>N*K)
					break;
				
				//위로가
				while(true) {
					team[--row][col]=val++;
					if(val>N*K)
						break;
					if(row==0) {
						team[row][++col]=val++;
						break;
					}
				}

				if(val>N*K)
					break;
				
			}//end while
			
			if(K==1)
				continue;
			
//			for(int i=0; i<team.length; i++) {
//				for(int j=0; j<team[i].length; j++) {
//					System.out.print(team[i][j] +" ");
//				}
//				System.out.println();
//			}
//			System.out.println("---");
			
			System.out.print("#"+tc);
			for(int i=0; i<team.length; i++) {
				int sum=0;
				for(int j=0; j<team[i].length; j++) {
					sum += team[i][j];
				}
				System.out.print(" "+ sum);
			}
			System.out.println();
		}//end test cases
	}
}
