import java.util.Scanner;

public class bj_1003_피보나치함수 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			cnt0 = 0;
			cnt1 = 0;
			int n = sc.nextInt();
			arr = new int[n+1];
			
			System.out.println(cnt0 +" " + cnt1);
		}//end test cases
	}//end main
	
	static int cnt0;
	static int cnt1;
	static int fibo(int n) {
		if(n==0) {
			arr[n] = 0;
			cnt0++;
			return arr[n];
		}
		if(n==1) {
			arr[n] = 1;
			cnt1++;
			return arr[n];
		}
		if(arr[n]!=0)
			return arr[n];
		return arr[n] = fibo(n-2) + fibo(n-1);
	}
}
