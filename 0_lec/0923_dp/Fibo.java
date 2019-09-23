
//중복을 제거하지 않은 Fibo재귀함수를 구현하시오.
//상향식(DP), 하향식(메모리제이션) 으로 각각 구현하시오.
public class Fibo {
	public static void main(String[] args) {
		System.out.print("memorization result : ");
		System.out.println(fibo_memo(50));
		
		System.out.print("dp result : ");
		System.out.println(fibo_dp(50));
	}
	
	
	static long[] memo = new long[100];
	//메모리제이션 : 이전에 계산했던 결과를 기억.
	static long fibo_memo(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(memo[n] ==0)
			memo[n] = fibo_memo(n-1) + fibo_memo(n-2);
		return memo[n];
	}

	//상향식(dp)
	static long fibo_dp(int n) {
		long[] fibo = new long[n+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2; i<= n; i++) {
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		return fibo[n];
	}
	
}

