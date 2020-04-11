package Baekjoon;

import java.util.Scanner;

public class bj_1748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int pos = (int)(Math.log10(n)+1);
		
		int[] cnt = new int[9];
		cnt[8] = 9; // 100,000,000가 범위의 최대범위이므로.
		for(int i=0; i<8; i++) {
			cnt[i] = ((int)(Math.pow(10,i+1))-1) - (int)(Math.pow(10, i)) + 1 ;
			cnt[i] *= i+1;
		}
		
		long ans = 0;
		for(int i=0; i<pos-1; i++) {
			ans += cnt[i];
		}
		
		ans +=  (n - (int)(Math.pow(10, pos-1)) + 1)*pos;
		System.out.println(ans);
	}
}
