import java.util.Scanner;

public class bj_2630_색종이만들기 {
	
	static int blue;
	static int white;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		white=0;
		blue=0;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				map[i][j] = sc.nextInt();
		}
		divide(0,0, N);
		System.out.println(white);
		System.out.println(blue);
		
	}//end main
	
	static void divide(int r, int c, int n) {
		int color = map[r][c];
		
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(map[i][j] != color) {
					divide(r, c , n/2);
					divide(r + n/2 , c , n/2);
					divide( r, c + n/2, n/2);
					divide( r+ n/2, c+n/2, n/2);
					return;
				}
			}
		}
		if(color == 1) blue++;
		if(color == 0) white++;
	}//end divide method
}
