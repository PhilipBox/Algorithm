package day00_study;

import java.util.Arrays;
import java.util.Scanner;

public class d2_1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[] num = new int[10];
			for(int i=0; i<10; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			double sum=0;
			for(int i=1; i<9; i++) {
				sum += num[i];
			}
			System.out.println("#"+tc+" "+Math.round(sum/8));
		}
	}
}
