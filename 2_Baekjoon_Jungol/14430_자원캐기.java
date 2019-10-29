import java.util.Scanner;

public class bj_14430_자원캐기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				map[i][j] = sc.nextInt();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(i==0) {
					if(j==0) continue;
					map[i][j]= map[i][j] + map[i][j-1];
				}
				else if(i!=0 && j==0) {
					map[i][j]= map[i][j] + map[i-1][j];
				}
				else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]) + map[i][j];
				}
			}
		}
		System.out.println(map[R-1][C-1]);
	}// end main
}
