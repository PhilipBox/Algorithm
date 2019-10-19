package _solving;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1592_수영장 {

	static int[] price;
	static int[] month;
	static int resMin;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			//0 : X
			//1 : 1일 
			//2 : 1달 
			//3 : 3달
			//4 : 1년
			price = new int[5];
			// 12개월 
			month = new int[13];
			for(int i=1; i<=4; i++) 
				price[i] = sc.nextInt();
			for(int i=1; i<=12; i++)
				month[i]=sc.nextInt();
			
			// 1년 이용권 비용을 최소값으로 지정. 
			resMin = price[4];
			dfs(1,0);
			System.out.println("#"+tc+" "+resMin);
		}//end test cases
	}//end main
	
	static void dfs(int idx , int cost){
		if(idx >= 13) {
			// 13이 되면 12개월 선택 끝.
			resMin = Math.min(resMin, cost);
			return;
		}
		if(resMin<cost) return;
		dfs(idx+1, cost + price[1] * month[idx]);
		dfs(idx+1, cost + price[2]);
		dfs(idx+3, cost + price[3]);
	}
}
