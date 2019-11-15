package _1115;

import java.util.Scanner;

public class bj_6588_골드바흐의추측 {

	static int N = 1000001;
	static boolean[] prime = new boolean[N + 1];
	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 에라토스테네스의 체
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (prime[i] == false) {
				int power = 2;
				while (true) {
					prime[i * power] = true;
					power++;
					if (i * power > N)
						break;
				}
			}
		}

		while (true) {
			int num = sc.nextInt();
			if (num == 0)
				break;
			int first = 0;
			int second = 0;
			boolean flag = false;
			for (int i = 2; i < num; i++) {
				if (prime[i] == false) {
					first = i;
					second = num - first;
					if (prime[second] == false) {
						System.out.println(num + " = " + first + " + " + second);
						flag = true;
						break;
					}
				} 
			}
			if (!flag) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		} // end while
	}
}
