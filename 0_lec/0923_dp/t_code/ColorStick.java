
public class ColorStick {
	public static void main(String[] args) {
		System.out.println(getStick_memo(6));
	}
	static int getStick_dp(int n) {
		int[] dp = new int[n+1];
		dp[1] = 2;
		dp[2] = 5;
		for(int i =3 ; i<= n; i++) {
			dp[i] = dp[i-2] + dp[i-1]*2;
		}
		return dp[n];
	}
	static int[] memo = new int[1000];
	static {
		memo[1] = 2;
		memo[2] = 5;
	}
	static int getStick_memo(int n) {
		if( memo[n] == 0 ) {
			memo[n] = getStick_memo(n-1)*2 + getStick_memo(n-2);
		}
		return memo[n];
	}
}
