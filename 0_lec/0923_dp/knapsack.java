import java.util.Arrays;
import java.util.Scanner;

public class knapsack {
	static int N;
	static int K;
	static int[] V;
	static int[] C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();
            V = new int[N];
            C = new int[N];
            for(int i=0; i<N; i++) {
                V[i] = sc.nextInt();
                C[i] = sc.nextInt();
            }
            int cost[][] = new int[N+1][K+1];
            
            System.out.println(Arrays.toString(V));
            System.out.println(Arrays.toString(C));
            //i 물건
            for(int i=0; i<=N; i++) {
            	// j 무게
                for(int j=0; j<=K; j++) {
                    if(i==0 || j==0) {
                        cost[i][j] = 0;
                        continue;
                    }
                    if (V[i-1] <= j) {
                        cost[i][j] = Math.max(C[i-1]+cost[i-1][j-V[i-1]],  cost[i-1][j]);
                        continue;
                    }
                    cost[i][j] = cost[i-1][j];
                }
            }
            
            for(int i=0; i<=N; i++) {
            	for(int j=0; j<=K; j++) {
            		System.out.print(cost[i][j] + " ");
            	}System.out.println();
            }
            
            System.out.println("#"+tc+" "+cost[N][K]);
        }
    }
}