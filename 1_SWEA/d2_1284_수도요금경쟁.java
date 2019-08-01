package day00_study;

import java.util.Scanner;

public class d2_1284_수도요금경쟁 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int A_liter = sc.nextInt();
			int B_base = sc.nextInt();
			int B_base_limit = sc.nextInt();
			int B_liter = sc.nextInt();
			int water = sc.nextInt();
			
			int A_price=0;
			int B_price=0;
			
			A_price = water * A_liter;
			if(water<=B_base_limit) {
				B_price = B_base;
			}
			else {
				B_price = B_base + (water-B_base_limit)*B_liter;
			}
			
			if(A_price<B_price)
				System.out.println("#"+tc+" "+A_price);
			else
				System.out.println("#"+tc+" "+B_price);
			
			
		}//end test cases
	}//end main
}
