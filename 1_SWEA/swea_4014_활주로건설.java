
import java.util.Scanner;

public class swea_4014_활주로건설 {

	static int N;
	static int X;
	static int[][] map;
	static int[][] sero;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			sero = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sero[i][j] = map[j][i];
				}
			}
			int ans = 0;
			for (int i = 0; i < N; i++) {
				int dup = 1;
				boolean isOK = true;
				boolean down = false;
				out: for (int j = 0; j < N; j++) {
					// 마지막 컬럼일 경우
					if (j == N - 1) {
						if (down) {
							if (dup < X)
								break;
						}
						ans++;
						break;
					}
					// 같으면 dup++
					if (map[i][j] == map[i][j + 1]) {
						dup++;
						if (dup >= X) {
							if(down) {
								for(int k=0; k<X-1; k++) {
									visited[i][j-k]=true;
								}
								visited[i][j+1]=true;
								down=false;
							}
							isOK = true;
						}
					}
					// 다음거가 더 클때
					else if (map[i][j] < map[i][j + 1]) {
//						// 위로 올라가는데, 2 이상 차이나면 조건 불만족 
						if (map[i][j + 1] - map[i][j] >= 2)
							break;
						else {
							// 활주로 건설 조건 불만족
							if (dup < X)
								break;
							else {
								for (int k = 0; k < X; k++) {
									if (visited[i][j - k])
										break out;
									visited[i][j - k] = true;
								}
								// 만족
								dup = 1;
								down = false;
								isOK = true;
							}
						}
					}
					// 다음거가 더 작을때
					else {
						// 아래로 내려가는데, 2 이상 차이나면 조건 불만족
						if (map[i][j] - map[i][j + 1] >= 2)
							break;
						else {
							if (isOK) {
								dup = 1;
								down = true;
								isOK = false;
							} else
								break;
						}
					}
				}
			}

			// 세로방향 검사. 로직은 같음. 세로배열 새롭게 만든 sero로 검사.
			
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				int dup = 1;
				boolean isOK = true;
				boolean down = false;
				out: for (int j = 0; j < N; j++) {
					// 마지막 컬럼일 경우
					if (j == N - 1) {
						if (down) {
							if (dup < X)
								break;
						}
						ans++;
						break;
					}
					// 같으면 dup++
					if (sero[i][j] == sero[i][j + 1]) {
						dup++;
						if (dup >= X) {
							if(down) {
								for(int k=0; k<X-1; k++) {
									visited[i][j-k]=true;
								}
								visited[i][j+1]=true;
								down=false;
							}
							isOK = true;
						}
					}
					// 다음거가 더 클때
					else if (sero[i][j] < sero[i][j + 1]) {
//						// 위로 올라가는데, 2 이상 차이나면 조건 불만족 
						if (sero[i][j + 1] - sero[i][j] >= 2)
							break;
						else {
							// 활주로 건설 조건 불만족
							if (dup < X)
								break;
							else {
								for (int k = 0; k < X; k++) {
									if (visited[i][j - k])
										break out;
									visited[i][j - k] = true;
								}
								// 만족
								dup = 1;
								down = false;
								isOK = true;
							}
						}
					}
					// 다음거가 더 작을때
					else {
						// 아래로 내려가는데, 2 이상 차이나면 조건 불만족
						if (sero[i][j] - sero[i][j + 1] >= 2)
							break;
						else {
							if (isOK) {
								dup = 1;
								down = true;
								isOK = false;
							} else
								break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		} // end test cases
	}// end main
}
