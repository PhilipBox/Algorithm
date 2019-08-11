package studyClass;

import java.util.Scanner;

public class d3_5516_요일맞추기 {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int  T = sc.nextInt();
		
		// 달별 일수, index 0 제외  
		int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
		
		// dow ( Day Of the Week)
				// 목 금 토 일 월 화 수 
		int[] dow = {3,4,5,6,0,1,2};
		for(int tc=1; tc<=T; tc++) {
			
			//궁금한 요일의  월,일 입력 
			int mon = sc.nextInt();
			int day = sc.nextInt();
			
			int daysum = 0;
			if(mon==1) {
				System.out.println("#"+tc+" "+dow[day%7]);
			}
			else {
				for(int i=1;i<=mon-1; i++) {
					daysum += month[i];
				}
				daysum+=day;
				System.out.println("#"+tc+" "+dow[daysum%7]);
			}
			
			
		}
	}
}
