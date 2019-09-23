import java.util.Scanner;

public class ColorStick {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(getStick_dp(n));
		System.out.println(getStick_memo(n));
	}
	
	static long getStick_dp(int n) {
		long[] stick = new long[n+1];
		stick[1] = 2;
		stick[2] = 5;
		for(int i=3; i<=n; i++) {
			stick[i] = stick[i-1]*2 + stick[i-2];
		}
		return stick[n];
	}
	
	
	static int[] memo = new int[1000];
	static {
		memo[1] = 2;
		memo[2] = 5;
	}

	static int getStick_memo(int n) {
		if(memo[n]==0)
			memo[n] = getStick_memo(n-1)*2 + getStick_memo(n-2);
		return memo[n];
	}
}

