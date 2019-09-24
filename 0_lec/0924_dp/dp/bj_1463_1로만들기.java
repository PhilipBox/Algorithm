package dp;
import java.util.Scanner;

public class bj_1463_1로만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			if (i < 4)
				arr[i] = 1;
			else {
				arr[i] = arr[i - 1] + 1;
				if (i % 2 == 0)
					arr[i] = Math.min(arr[i], arr[i / 2] + 1);
				if (i % 3 == 0)
					arr[i] = Math.min(arr[i], arr[i / 3] + 1);
			}
		}
		System.out.println(arr[N]);
	}
}
