import java.util.Arrays;
import java.util.Scanner;

public class 플로이드마샬 {

	static int N;
	static int INF = 99;
	static int[][] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				dist[i][j] = sc.nextInt();
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(dist[i][k] != INF && dist[k][j]!= INF)
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
			System.out.println("k= " + k);
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(dist[i]));
			}System.out.println();
		}
	}// end main


}
