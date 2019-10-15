import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj_16235_나무재테크 {

	static class TREE implements Comparable<TREE> {
		int r;
		int c;
		int age;

		public TREE(int r, int c, int a) {
			this.r = r;
			this.c = c;
			this.age = a;
		}

		@Override
		public int compareTo(TREE o) {
			// 오름차순
			return this.age - o.age;
		}
		@Override
		public String toString() {
			return "" + this.r + "," + this.c + " / " + this.age;
		}
	}

	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[][] eng;
//	static ArrayList<TREE> tList;
	static Queue<TREE> deadTree;

	static PriorityQueue<TREE> tList;
	static Queue<TREE> tempTree;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 땅크기
		M = sc.nextInt(); // 나무의 수
		K = sc.nextInt(); // 시간(년)
		eng = new int[N + 1][N + 1]; // 땅 크기 초기화
		map = new int[N + 1][N + 1];
		deadTree = new LinkedList<>();
		tempTree = new LinkedList<>();

		// 초기 땅의 양분 초기화 (5)
		for (int i = 1; i <= N; i++)
			Arrays.fill(map[i], 5);

		// SD가 뿌리는 양분 정보 입력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				eng[i][j] = sc.nextInt();
		}
		// 내가 심은 나무의 리스트 , 입력받기
		tList = new PriorityQueue<>();
		for (int i = 0; i < M; i++)
			tList.add(new TREE(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		// 봄 : 나이만큼 양분을 얻음, 나이+1
		// - 하나의 칸에 여러개의 나무 가능
		// - 나이가 어린 나무부터 양분을 얻음.
		// - 땅의 양분 < 나무의 나이 면, 즉시 사망! (같으면 생존)

		// 여름 : 봄에 죽은 나무가 양분이 됨. (나무마다 '나이/2'가 양분으로 추가)
		// 가을 : 나무 번식 ( 나무의 나이가 5의배수 .. 8방에 1나무 생성)
		// 겨울 : SD 가 양분을 추가함.

		for (int year = 0; year < K; year++) {
			// 봄,여름,가을,겨울
			spring();
			summer();
			fall();
			winter();
		}
		System.out.println(tList.size());

	}// end main

	static void spring() {
		// 땅의 양분과 나무의 위치의 나이와 비교.
		// 양분 < 나무의 나이 .. 나무 즉시 사망.
		// 양분 >= 나무의 나이 .. 양분은 나무의 나이만큼 빼줌.
		// .. 나무의 나이 +1

		// 모든 나무의 수만큼 확인
		while (!tList.isEmpty()) {
			TREE t = tList.poll();
			if (map[t.r][t.c] < t.age) {
				// 죽을 나무를 저승명부에 추가
				// 나무 ㅃㅃ
				deadTree.add(t);
			} else {
				map[t.r][t.c] -= t.age;
				t.age++;
				tempTree.add(t);
			}
		} // end tList while loop
		tList.addAll(tempTree);
		tempTree.clear();
	}// end spring method

	static void summer() {
		// 여름 : 봄에 죽은 나무가 양분이 됨. (나무마다 '나이/2'가 양분으로 추가)
		while(!deadTree.isEmpty()) {
			TREE t = deadTree.poll();
			map[t.r][t.c] += t.age / 2;
		}
	}// end summer method

	static void fall() {
		for (TREE t : tList) {
			// 가을 : 나무 번식 ( 나무의 나이가 5의배수 .. 8방에 1나무 생성)
			if (t.age % 5 == 0) {
				// 5살이상(5의배수)일때.
				for (int i = 0; i < 8; i++) {
					// 8방에 나무 생성.
					int nr = t.r + dr[i];
					int nc = t.c + dc[i];

					// 배열범위체크
					if (nr < 1 || nc < 1 || nr > N || nc > N)
						continue;
					// 나무 번식~
					tempTree.add(new TREE(nr, nc, 1));
				}
			}
		} // end tList loop
		tList.addAll(tempTree);
		tempTree.clear();
	}// end fall method

	static void winter() {
		// map에 SD의 eng만큼 양분 추가
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += eng[i][j];
			}
		}
	}// end winter method
}
