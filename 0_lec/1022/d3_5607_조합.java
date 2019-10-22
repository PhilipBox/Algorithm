import java.util.Scanner;

public class d3_5607_조합 {

	static final int MOD = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long[] fact = new long[N + 1];
			fact[0] = 1;
			for (int i = 1; i <= N; i++) {
				fact[i] = (fact[i - 1] * i) % MOD;
			}

			long a = (fact[R] * fact[N - R]) % MOD; 
			long tres = ferm(a, MOD - 2);
			//a^p-2와 a^-1은 동치.
			
			System.out.println("#"+tc+" "+(fact[N] * tres) % MOD);
		} // end test cases

	}// end main

	static long ferm(long n, int x) {
		if (x == 0)
			return 1;
		long tmp = ferm(n, x / 2); //분할정복
		long ret = (tmp * tmp) % MOD;
		if (x % 2 == 0)
			return ret;
		else
			return (ret * n) % MOD;
	}
}
