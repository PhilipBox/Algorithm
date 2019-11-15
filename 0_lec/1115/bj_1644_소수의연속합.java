package _1115;

import java.util.Scanner;

public class bj_1644_소수의연속합 {

	static int MAX = 4_000_000;
	static boolean[] array = new boolean[MAX + 1];
	static int[] prime = new int[283146 + 1];
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		getPrime(); // 400만까지의 소수를 구하고 (에라토스테네스의 체) - 반복문을 다시 돌려서 소수의 개수가 283146임을 파악.
		setPrime(); // 소수만 따로 배열에 옮겼다.

		int sum = 0;
		int ans = 0;
		int start = 0;
		int end = 0;
		while (end <= cnt) {
			if (sum < N) {
				sum += prime[end++];
				continue;
			}

			if (sum == N) {
				++ans;
			}
			sum -= prime[start++];
		}
		System.out.println(ans);
	}//end main

	static void getPrime() {
		int sqrt = (int) Math.sqrt(MAX);
		for (int i = 2; i <= sqrt; i++) {
			// 소수이면
			if (array[i] == false) {
				int cnt = 2;
				while (true) {
					array[i * cnt] = true;
					cnt++;
					if (i * cnt > MAX)
						break;
				}
			}
		} // 에라토스테네스의 체
	}// end getPrime method

	static void setPrime() {
		for (int i = 2; i <= MAX; i++) {
			if (!array[i]) {
				prime[cnt++] = i;
			}
		}
	}// end setPrime method
}
