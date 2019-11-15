package _1115;

import java.util.Scanner;

public class bj_1052_물병 {

	static int N;
	static int K;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		ans = 0;
		solve();
	}

	static void solve() {
		if (N <= K)
			System.out.println("0");
		else {
			while (true) {
				int tempBottle = addBottle(N);
				// K보다 작으면 물병을 살 필요가 없음
				if (tempBottle <= K)
					break;
				ans++;
				N++;
			}
			System.out.println(ans);
		}
	}

	static int addBottle(int n) {
		int cnt=0;
		while(n>0) {
			if(n%2==1) cnt++;
			n /= 2;
		}
		return cnt;
	}

}
