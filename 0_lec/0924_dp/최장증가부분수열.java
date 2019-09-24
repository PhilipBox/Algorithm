import java.util.Scanner;

public class 최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			int[] LIS = new int[N];
			int max=0;
			for (int i = 0; i < arr.length; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j] < arr[i]) {
						LIS[i] = Math.max(LIS[i], LIS[j]+1);
					}
				}
				max = Math.max(max, LIS[i]);
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
