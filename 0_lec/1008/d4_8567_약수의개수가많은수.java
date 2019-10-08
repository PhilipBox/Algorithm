import java.util.Scanner;

public class d4_8567_약수의개수가많은수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int MAX = 100001;
		int[] count = new int[MAX];
		int[] res = new int[MAX];
		for (int i = 1; i < MAX; i++) {
			for (int j = 1; i*j < MAX ; j++)
				count[i * j]++;
		}
		res[1]=1;
		int max = 1;
		int maxIdx =1;
		for(int i=2; i<MAX; i++) {
			if(count[i]>=max) {
				max = count[i];
				maxIdx = i;
				res[i] = maxIdx;
			}
			else {
				res[i] = maxIdx;
			}
		}
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			System.out.println("#"+tc+" "+res[N]);
		}
	}
}
