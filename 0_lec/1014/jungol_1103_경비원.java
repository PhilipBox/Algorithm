import java.util.Arrays;
import java.util.Scanner;

public class jungol_1103_경비원 {

	static class Store {
		int dir;
		int pos;

		public Store(int d, int p) {
			this.dir = d;
			this.pos = p;
		}
	}

	static int R;
	static int C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		R = sc.nextInt();
		// 거리를 저장할 맵
		int[][] map = new int[R + 1][C + 1];
		// 상점의 수
		int N = sc.nextInt();

		// 상점의 목록을 담을 리스트
		Store[] StoreList = new Store[N];
		for (int i = 0; i < N; i++)
			StoreList[i] = new Store(sc.nextInt(), sc.nextInt());

		int DKdir = sc.nextInt();
		int DKpos = sc.nextInt();

		// 북1
		// 남2
		// 서3
		// 동4
		switch (DKdir) {

		// 북
		case 1:
			// r : 0
			// c : DKpos
			estDist1(map, 0, DKpos);
			break;

		// 남
		case 2:
			// r : R-1
			// c : DKpos
			estDist2(map, R, DKpos);
			break;

		// 서
		case 3:
			// r : DKpos
			// c : 0
			estDist3(map, DKpos, 0);
			break;
		// 동
		case 4:
			estDist4(map, DKpos, C);
			break;
		}// end switch

//		for (int i = 0; i <= R; i++) {
//			for (int j = 0; j <= C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		getRes(map, StoreList);
		System.out.println(res);
	}

	static int res = 0;

	static void getRes(int[][] arr, Store[] StoreList) {

		for (Store s : StoreList) {
			switch (s.dir) {
			// 북
			case 1:
				res += arr[0][s.pos];
				break;
			// 남
			case 2:
				res += arr[R][s.pos];
				break;
			// 서
			case 3:
				res += arr[s.pos][0];
				break;
			// 동
			case 4:
				res += arr[s.pos][C];
				break;
			}// end switch
		}
	}// end getRes method

	static void estDist1(int[][] arr, int r, int c) {
		// 북쪽에 위치
		// 1일때
		int cnt = 0;

		// 시계
		int DKr = r;
		int DKc = c;
		arr[DKr][DKc++] = cnt++;
		// 오른쪽
		while (DKc <= C) {
			arr[DKr][DKc++] = cnt++;
		}
		DKc--;
		DKr++;

		// 아래로
		while (DKr <= R) {
			arr[DKr++][DKc] = cnt++;
		}
		DKr--;
		DKc--;

		// 왼쪽
		while (DKc >= 0) {
			arr[DKr][DKc--] = cnt++;
		}

		// 반시계
		cnt = 0;
		DKr = r;
		DKc = c;
		// 왼쪽
		while (DKc >= 0) {
			arr[DKr][DKc--] = cnt++;
		}
		DKc++;
		DKr++;

		// 아래로
		while (DKr <= R) {
			arr[DKr++][DKc] = cnt++;
		}
		DKr--;
		DKc++;

		// 오른쪽(최소값 체크)
		while (DKc <= C) {
			if (arr[DKr][DKc] > cnt) {
				arr[DKr][DKc++] = cnt++;
			} else {
				break;
			}
		}
		DKc--;
	}

	static void estDist2(int[][] arr, int r, int c) {
		// 남쪽에 위치
		// 2일때
		int cnt = 0;
		// 반시계
		int DKr = r;
		int DKc = c;
		arr[DKr][DKc++] = cnt++;
		// 오른쪽
		while (DKc <= C) {
			arr[DKr][DKc++] = cnt++;
		}
		DKc--;
		DKr--;
		while (DKr >= 0) {
			arr[DKr--][DKc] = cnt++;
		}
		DKr++;
		DKc--;
		while (DKc >= 0) {
			arr[DKr][DKc--] = cnt++;
		}

		// 시계
		DKr = r;
		DKc = c;
		cnt = 0;
		arr[DKr][DKc--] = cnt++;
		while (DKc >= 0) {
			arr[DKr][DKc--] = cnt++;
		}
		DKc++;
		DKr--;
		while (DKr >= 0) {
			arr[DKr--][DKc] = cnt++;
		}
		DKr++;
		DKc++;
		// 오른쪽
		while (DKc <= C) {
			if (arr[DKr][DKc] > cnt) {
				arr[DKr][DKc++] = cnt++;
			} else {
				break;
			}
		}
		DKc--;
	}

	static void estDist3(int[][] arr, int r, int c) {
		// 서쪽에 위치
		// 3일때
		int cnt = 0;
		// 시계
		int DKr = r;
		int DKc = c;
		arr[DKr--][DKc] = cnt++;
		// 위
		while (DKr >= 0) {
			arr[DKr--][DKc] = cnt++;
		}
		DKr++;
		DKc++;

		// 오른쪽
		while (DKc <= C) {
			arr[DKr][DKc++] = cnt++;
		}
		DKc--;
		DKr++;

		// 아래
		while (DKr <= R) {
			arr[DKr++][DKc] = cnt++;
		}
		DKr--;
		DKc--;

		// 반시계
		cnt = 0;
		DKr = r;
		DKc = c;
		arr[DKr++][DKc] = cnt++;
		// 아래
		while (DKr <= R) {
			arr[DKr++][DKc] = cnt++;
		}
		DKr--;
		DKc++;

		// 오른쪽
		// 오른쪽
		while (DKc <= C) {
			arr[DKr][DKc++] = cnt++;
		}

		DKr--;
		DKc--;
		// 위
		while (DKr >= 0) {
			if (arr[DKr][DKc] > cnt) {
				arr[DKr--][DKc] = cnt++;
			} else {
				break;
			}
		}
	}// end 3

	static void estDist4(int[][] arr, int r, int c) {
		// 동쪽에 위치
		// 4일때

		int cnt = 0;
		// 반시계
		int DKr = r;
		int DKc = c;
		arr[DKr--][DKc] = cnt++;
		// 위
		while (DKr >= 0) {
			arr[DKr--][DKc] = cnt++;
		}
		DKr++;
		DKc--;

		// 왼쪽
		// 왼쪽
		while (DKc >= 0) {
			arr[DKr][DKc--] = cnt++;
		}
		DKc++;
		DKr++;

		// 아래
		while (DKr <= R) {
			arr[DKr++][DKc] = cnt++;
		}
		
		// 시계
		cnt = 0;
		DKr = r;
		DKc = c;
		
		arr[DKr++][DKc] = cnt++;
		// 아래
		// 아래
		while (DKr <= R) {
			arr[DKr++][DKc] = cnt++;
		}
		DKr--;
		DKc--;
		// 왼쪽
		while(DKc >=0) {
			arr[DKr][DKc--] = cnt++;
		}
		DKc++;
		DKr--;
		// 위(최소값)
		while (DKr >= 0) {
			if (arr[DKr][DKc] > cnt) {
				arr[DKr--][DKc] = cnt++;
			} else {
				break;
			}
		}
	}// end 4
}
