import java.util.Arrays;
import java.util.Scanner;

public class d4_4050_재관이의대량할인 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum=0;
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum+=arr[i];
			}
			Arrays.sort(arr);
			int idx = arr.length-1;
			for(int i=0; i<arr.length/3; i++) {
				int min=987654321;
				min = Math.min(Math.min(arr[idx], arr[idx-1]), arr[idx-2]);
				sum -= min;
				idx -=3;
			}
			System.out.println("#"+tc+" "+sum);
		}//end test cases
	}
}
