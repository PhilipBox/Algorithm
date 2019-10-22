import java.util.Scanner;

public class 마방진_문지환 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int row = 0;
		int col = N / 2;
		for (int i = 1; i <= (N * N); i++) {
			map[row][col] = i;
			if (i % N == 0) {
				row++;
			}
			else {
				row--;
				col--;
				if(row<0) {
					row= N-1;
				}
				else {
					if(col<0) {
						col = N-1;
					}
				}
			}
		}
		
		for(int i=0; i<N; i++	) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
