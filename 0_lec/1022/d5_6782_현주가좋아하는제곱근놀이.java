import java.util.Scanner;

public class d5_6782_현주가좋아하는제곱근놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			
			long result = 0;
			while (N != 2) {
				double t = Math.sqrt(N);
				if ((int) t == t) {
					N = (int) t;
				} else {
					t = (int) t;
					result += ((t+1)*(t+1)-N);
					N = (int) Math.sqrt((t+1)*(t+1));
				}
				result++;
			} // end while
			System.out.println("#"+tc+" "+result);
		} // end test cases
	}// end main

}
