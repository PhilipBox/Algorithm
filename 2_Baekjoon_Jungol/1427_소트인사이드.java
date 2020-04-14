package Baekjoon;

import java.util.Scanner;

//소트인사이드
public class bj_1427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] digit = new int[10];
		String str = String.valueOf(n);
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			digit[Character.getNumericValue(str.charAt(i))]++;
		}
		for (int i = 9; i >= 0; i--) {
			while (digit[i] != 0) {
				ans += i;
				digit[i]--;
			}
		}
		System.out.println(ans);
	}
}
