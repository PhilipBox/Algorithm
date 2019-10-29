import java.util.Scanner;

public class d4_4613_러시아국기같은깃발 {
	static class COLOR {
		int white;
		int blue;
		int red;
		public COLOR(int w, int b, int r) {
			this.white = w;
			this.blue = b;
			this.red = r;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			char[][] flag = new char[R][C];
			COLOR[] color = new COLOR[R];
			for (int i = 0; i < R; i++) {
				String s = sc.next();
				int w = 0, b = 0, r = 0;
				for (int j = 0; j < C; j++) {
					flag[i][j] = s.charAt(j);
					if (flag[i][j] == 'W')
						w++;
					else if (flag[i][j] == 'B')
						b++;
					else
						r++;
				}
				color[i] = new COLOR(w, b, r);
			}
			int ans = 987654321;
			for (int i = 1; i < R - 1; i++) {
				for (int j = i + 1; j < R; j++) {
					int paint = 0;
					// 1 - WHITE
					for (int w = 0; w <= i - 1; w++) {
						paint += color[w].blue;
						paint += color[w].red;
					}
					// 2 - BLUE
					for (int w = i; w <= j - 1; w++) {
						paint += color[w].white;
						paint += color[w].red;
					}
					// 3 - RED
					for (int w = j; w <= R - 1; w++) {
						paint += color[w].white;
						paint += color[w].blue;
					}
					ans = Math.min(ans, paint);
				}
			} 
			System.out.println("#"+tc+" "+ans);
		}//end test cases
	}
}
