package studyClass;

import java.util.Scanner;

public class d3_5601_쥬스나누기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int ts=1; ts<=T; ts++) {
			
			int N = sc.nextInt();
			System.out.print("#"+ts + " ");
			for(int i=0; i<N; i++) {
				System.out.print("1/"+N+" ");
			}
		
			System.out.println();
		}
		
	}//end main
}