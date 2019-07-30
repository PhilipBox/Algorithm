package day00_study;

import java.util.Scanner;

public class d2_1948_날짜계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int mon1 = sc.nextInt();
			int day1 = sc.nextInt();
			int mon2 = sc.nextInt();
			int day2 = sc.nextInt();
			int total=0;
			
			//같은달
			if(mon1==mon2) {
				System.out.println("#"+tc+" "+(day2-day1+1));
			}
			else {
				//1. 시작달의 전체일 - 현재일
				total = day[mon1]-day1;
				
				//2. 사잇달 모두 cnt
				for(int i=mon1+1; i<mon2; i++) {
					total += day[i];
				}
				
				//3. 마지막달 cnt
				total += (day2+1);	
				System.out.println("#"+tc+ " " + total);
			}
		}
	}//end main
}
