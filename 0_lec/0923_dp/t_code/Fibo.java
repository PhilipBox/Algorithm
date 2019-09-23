
//중복을 제거하지 않은 Fibo재귀함수를 구현하시오.
//상향식(DP). 하향식(메모이제이션). 으로 각각 구현해보시오.
public class Fibo {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long result = fibo_dp(999);
		long end = System.currentTimeMillis();
		System.out.println("fibo : " + result);
		System.out.println("Elapsed time : " + (end - start)); 
	}
	
	//중복제거 안한 버전
	static long fibo(int n) {
		if( n == 0 )
			return 0;
		if( n == 1 )
			return 1;
		return fibo(n-1) + fibo(n-2);
	}
	static long[] memo = new long[1000];
	static long fibo_memo(int n) {
		if( n == 0 )
			return 0;
		if( n == 1 )
			return 1;
		if( memo[n] == 0 )
			memo[n] = fibo_memo(n-1) + fibo_memo(n-2);
		return memo[n];
	}
	static long fibo_dp(int n) {
		long[] fibo = new long[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 2; i <= n ; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		return fibo[n];
	}
}














