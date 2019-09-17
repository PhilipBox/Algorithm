import java.util.Arrays;
import java.util.Scanner;

public class d4_7333_한솔이의택배아르바이트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] box = new int[N];
			for (int i = 0; i < N; i++)
				box[i] = sc.nextInt();

			int cnt = 0; // 옮겨야 되는 횟수
			int fin = 0; // 뒤쪽에 이미 사용된 상자의 수 ( 이미 사용된 가벼운 상자의 수 )
			Arrays.sort(box);

			// 제일 무거운 것부터 검사해 나가서, 사용된 가벼운 상자 전까지 반복
			for (int i = N - 1; i >= fin; i--) {
				if (box[i] >= 50) {
					cnt++;
					continue;
				}
				int need = 0; // 아래 깔아야되는 상자 수
				if (50 % box[i] == 0)
					need = 50 / box[i] - 1;
				else
					need = 50 / box[i];

				// 현재까지 사용된 가벼운 상자의 수에, 지금 필요한 가벼운 상자의 수를 더해도 상자가 남는다면.
				if (i >= fin + need) {
					fin += need;
					cnt++;
				} else
					break;
			}
			System.out.println("#"+tc+" "+cnt);
		} // end test cases
	}
}
