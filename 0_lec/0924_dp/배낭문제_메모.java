import java.util.Arrays;
import java.util.Scanner;

public class 배낭문제_메모 {
	static int N;
	static int K;
	static int[][] memo;
	static int[] weights;
	static int[] values;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			weights = new int[N];
			values = new int[N];
			memo = new int[N][K+1];
			for(int i = 0; i < N; i++) {
				weights[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			for(int i = 0; i < N; i++)
				Arrays.fill(memo[i], -1);
			System.out.println("#" + tc + " " + dfs(0, 0));
		}
	}
	static int dfs(int idx, int weight) {
		if(idx == N)
			return 0;
		if(memo[idx][weight] != -1)
			return memo[idx][weight];
		//지금까지 알고있던 무게에, 이번에 검사하는 아이템을 담았을 때 무게가 초과한다면 
		if( weight + weights[idx] > K )
			//안담고 그냥 지나가는게 최선이야 (idx+1 -> 다음아이템으로 가보는거)
			memo[idx][weight] = dfs(idx+1, weight);
		//안담았을때랑, 담았을때의 가치가 큰거를 memo에 담아두는거야.
		else
			memo[idx][weight] = Math.max( dfs(idx+1, weight) , values[idx] + dfs(idx+1, weight + weights[idx]));
		return memo[idx][weight];
	}
}










