package studyClass;

import java.util.Scanner;

public class d3_6730_장애물경주난이도 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T =  sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//장애물 개
			int N = sc.nextInt();
			int[] block = new int[N];
			
			//블럭 입력받
			for(int i=0;i<N; i++) {
				block[i] = sc.nextInt();				
			}
			
			//올라가는,내려가는 난이도 check 변
			int up = 0;
			int down =0;
			
			//
			for(int i=0 ; i<N-1; i++) {
				
				// up - 올라가는 난이도 
				if(block[i]<=block[i+1]) {
					if(up <= (block[i+1]-block[i])) {
						up = (block[i+1]-block[i]);
					}
				}
				// down - 내려가는 난이도 
				else {
					if(down <= (block[i]-block[i+1])) {
						down = (block[i]-block[i+1]);
					}
				}
			}
			System.out.println("#"+tc +" " + up + " " + down);
		}//end test cases
	}//end main
}
