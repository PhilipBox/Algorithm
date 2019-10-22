package mon;

import java.util.Scanner;

public class 마방진 {
	static int N, arr[][];

	static final boolean validRange(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}

	// 홀수 마방진을 구하는 메소드 (재귀로 구현해서  N값이 113을 초과하면 스택오버플로)
	static final void solveODD(int y, int x, int num) {
		arr[y][x] = num;
		int ny = y + 1, nx = x + 1;
		if (ny == N)
			ny = 0;
		if (nx == N)
			nx = 0;
		if (arr[ny][nx] != 0) {
			ny = y - 1;
			nx = x;
		}
		if (num < N * N)
			solveODD(ny, nx, num + 1);
	}

	// 마방진을 체크하는 메소드
	static final boolean valid() {
		boolean chk[] = new boolean[N*N+1];
		int row[] = new int[N*N+1];
		int col[] = new int[N*N+1];
		int crossLURD = 0, crossRULD = 0;
		int validNum = N * (N*N + 1) / 2;
		System.out.println("임의의 한 행 값 : " + validNum);
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if (!chk[arr[r][c]]) {
					chk[arr[r][c]] = true;
					row[r] += arr[r][c];
					col[c] += arr[r][c];
					if (r == c) // 00 11 22
						crossLURD += arr[r][c];
					if (c == N - r - 1) // 02 11 20
						crossRULD += arr[r][c];
				}
				else {
					return false;
				}
			}
		}

		if (crossLURD != validNum || crossRULD != validNum) {
			return false;
		}
		for(int i=0;i<N;i++) {
			if (row[i] != validNum || col[i] != validNum) {
				return false;
			}
		}
		return true;
	}

	static final void solveEVEN() { // 4인 경우만 작동됨.
		int num = 1; // 대각선에 부여하는 번호
		int sequenceNum = N * N;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				boolean isSequence = true;
				if(i==j) { // 00 11 22 33
					arr[i][j]=num;
					isSequence=false;
				}
				if(j==N-i-1) { // 03 12 21 30
					arr[i][j]=num;
					isSequence=false;
				}
				
				if(isSequence) {
					arr[i][j]=sequenceNum;
				}
				
				num++;
				sequenceNum--;
			}
		}
	}
	
	static final void printArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		if ((N & 1) == 1) {
			solveODD(N - 1, N / 2, 1);
			printArr();
			System.out.println(valid());
		} else {
			solveEVEN();
			printArr();
			System.out.println(valid());
		}
	}
}
