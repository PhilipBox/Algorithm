import java.util.Scanner;

public class bj_11048_이동하기 {
	static int[][] map;
	static int[][] cost;
	static int R;
	static int C;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R+1][C+1];
		cost = new int[R+1][C+1];
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		cost[1][1] = map[1][1];
		// 내 위치에 올 수 있는 경우는 왼쪽과 위에서야.
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				int curr = map[i][j];
				if(curr + cost[i-1][j] > curr + cost[i][j-1]) {
					cost[i][j] = (curr + cost[i-1][j]);
				}
				else {
					cost[i][j] = (curr + cost[i][j-1]);
				}
			}
		}
		System.out.println(cost[R][C]);
	}//end main
}
