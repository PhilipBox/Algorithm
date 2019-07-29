package day00_study;

import java.util.Scanner;

public class d2_1976_시각덧셈 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {

			int hour1= sc.nextInt();
			int min1 = sc.nextInt();
			
			int hour2= sc.nextInt();
			int min2= sc.nextInt();
			
			int hour=0, min=0;
			
			hour = hour1 + hour2;
			min = min1+min2;
			if(min>60) {
				hour++;
				min -= 60;
			}
			
			System.out.print("#"+tc+" ");
			if(hour>12)
				System.out.print(hour-12+" ");
			else 
				System.out.print(hour+" ");
			
			System.out.println(min);
		}//end test cases
	}//end main
}
