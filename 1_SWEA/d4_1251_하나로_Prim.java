import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d4_1251_하나로_Prim {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			double[][] adj = new double[N][N];
			List<Integer> nodeList = new ArrayList<Integer>();
			boolean[] visited = new boolean[N];

			int[] posX = new int[N];
			int[] posY = new int[N];
			for (int i = 0; i < N; i++) {
				posX[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				posY[i] = sc.nextInt();
			}

			double e = sc.nextDouble();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						adj[i][j] = 0;
					else {
						adj[i][j] = getDist(posX[i], posY[i], posX[j], posY[j]);
					}
				}
			}

			nodeList.add(0);
			visited[0] = true;

			double min, result = 0;
			int index;

			for (int i = 0; i < N - 1; i++) {
				min = Double.MAX_VALUE;
				index = -1;
				for (int node : nodeList) {
					for (int j = 0; j < N; j++) {
						if (!visited[j] && adj[node][j] != 0 && adj[node][j] < min) {
							min = adj[node][j];
							index = j;
						}
					}
				}

				result += min;
				nodeList.add(index);
				visited[index] = true;
			}
			
			result *= e;
			result = Math.round(result);
			System.out.println("#"+tc+" "+ (new Double(result).longValue()));
		}
	}

	static double getDist(int x1, int y1, int x2, int y2) {
		return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
	}

}
