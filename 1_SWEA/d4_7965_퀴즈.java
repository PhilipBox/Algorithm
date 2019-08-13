package lecture;

import java.util.Scanner;

public class d4_7965_퀴즈 {
	static final long MOD = 1_000_000_007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
				int N = sc.nextInt();
				long sum =0L;
				for(int i=1; i<=N; i++) {
					sum = (sum + (power(i,i)%MOD)%MOD);
					sum = sum%MOD;
				}
				System.out.print("#"+tc +" "+sum);
				System.out.println();
		}
	}
	
	
	static long power(int a, int n) {
		if(n==0)
			return 1;
		if(n==1)
			return a;
		
		long tmp = (power(a, n/2)%MOD);
		
		if(n%2==0) {
			return (tmp * tmp)%MOD;
		}
		else {
			return (tmp* tmp)%MOD * a;
		}
		
	}//end power
	
}
