package studyClass;

import java.util.Scanner;

public class d3_3456_직사각형길이찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[] sq = new int[3];
			for(int i=0; i<3; i++) {
				sq[i] = sc.nextInt();
			}
			
			if(sq[0]==sq[1])
				System.out.println("#"+tc+" "+sq[2]);
			else if( sq[0]==sq[2])
				System.out.println("#"+tc+" "+sq[1]);
			else if( sq[1]==sq[2])
				System.out.println("#"+tc+" "+sq[0]);
		}//end test cases
	}
}
