package selfStudy;

import java.util.Scanner;

public class d3_5603_건초더미 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			int avg=0;
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				avg+= arr[i];
			}
			avg /= N;
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				int box = avg -arr[i];
				if(box>0) {
					cnt += box;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}//end test cases
	}//end main
}
