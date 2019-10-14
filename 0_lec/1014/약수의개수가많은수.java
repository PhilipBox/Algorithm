import java.util.Scanner;

public class 약수의개수가많은수 {

	static final int MAX = 100001;

	public static void main(String[] args) {
		int[] cnt = new int[MAX];
		
		for (int i = 1; i < MAX; i++) {
			for (int j = i; j < MAX; j += i) {
				cnt[j]++;
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		for (int i = 1; i < MAX; i++) {
			if (max <= cnt[i]) {
				max = cnt[i];
				maxIdx = i;
			}
			cnt[i] = maxIdx;
		}

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T ; tc++) {
			int n = sc.nextInt();
			System.out.println("#"+tc+" "+cnt[n]);
		}
	}
}
