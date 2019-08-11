package studyClass;

import java.util.Scanner;

public class d3_7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[] card = new int[a+b+1];
			
			for(int i=1; i<=a; i++) {
				for(int j=1; j<=b; j++) {
					card[i+j]++;
				}
			}
			
			int max =0;
			for(int i=1; i<card.length; i++) {
				if(max< card[i])
					max=card[i];
			}
			
			System.out.print("#"+tc+" ");
			for(int i=1; i<card.length; i++) {
				if(max==card[i])
					System.out.print(i+" ");
			}
			System.out.println();
			
			
		}//end test cases
	}
}
