package _1115;

import java.util.Scanner;

public class bj_2569_십자카드문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt();
		}
		int N = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
		int res = TEN(N);
		int cnt = 0;
		for (int i = 1111; i <= res; i++) {
			if(TEN(i)==i)  cnt++;
		}
		System.out.println(cnt);
	}

	static int TEN(int n) {
		int num = n;
		for (int i = 0; i < 3; i++) {
			num = num % 1000 * 10 + num / 1000;
			if (n > num)
				n = num;
		}
		return n;
	}

}
