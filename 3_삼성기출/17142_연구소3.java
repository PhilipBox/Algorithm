import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_17142_연구소3 {

	static class Virus {
		int r;
		int c;
		int cnt;

		public Virus(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "" + this.r + "," + this.c + " // " + this.cnt;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	static boolean[][] visited;
	static Virus[] vList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 연구소 크기
		map = new int[N][N]; // 연구소 초기화
		M = sc.nextInt(); // 바이러스의 개수
		ArrayList<Virus> virusList = new ArrayList<>(); // 바이러스를 담을 리스트

		// 연구소 상태 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 0 빈벽, 1벽, 2바이러스
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2)
					virusList.add(new Virus(i, j, 0));
			}
		}
		// 바이러스를 배열 리스트로 저장
		vList = new Virus[virusList.size()];
		for (int i = 0; i < vList.length; i++)
			vList[i] = virusList.get(i);
//		for(Virus v : vList) System.out.println(v.toString());

		comb(new Virus[M], 0, 0);
		if(minTime == 987654321) System.out.println("-1");
		else System.out.println(minTime);
	}// end main

	static void comb(Virus[] sel, int n, int idx) {
		if (idx == sel.length) {
			// 전체 바이러스 수 중에서, M개를 선택한 경우
//			for (Virus v : sel)
//				System.out.println(v.toString());
			// 여기서 바이러스를 선택했을 경우 고려해주면 됨.
			Queue<Virus> vQueue = new LinkedList<>();

			// copymap()에서..
			// visited, copy, totalroom초기화
			// 빈방의 개수 카운트, 바이러스 위치는 -1
			copymap();

			// 선택한 바이러스에 대한 처리 (방문처리, 시작위치 0 ,큐에넣기)
			for (Virus v : sel) {
				visited[v.r][v.c] = true;
				copy[v.r][v.c] = -1;
				vQueue.add(v);
			}
			// 선택된 환경에 따른 copy와, M개의 선택된 바이러스들을 가지고 bfs로 간다.
			bfs(vQueue);

			// break해서 왔던가.
			// 다돌고 나왔던가.

			// 퍼뜨린 뒤에 copy에 대해서 최종 확인.
			finalCheck();

			// 0을 만나서 왔으면 987654321
			// 아니면 어떤 값
			minTime = Math.min(minTime, spreadTime);

//			print();
//			System.out.println("===========================");
			return;
		}
		if (n == vList.length)
			return;
		sel[idx] = vList[n];
		comb(sel, n + 1, idx + 1);
		comb(sel, n + 1, idx);
	}

	static int spreadTime = 0;
	static int minTime = 987654321;

	static void finalCheck() {
		// 0이 다 바뀌어서 왔을수도있고
		// 다 돌고 못가는곳에서 큐가 다 poll되어서 왔을수도있어.

		// copy에 남아있는 경우는 -1과 0이겠지.
		// 0이면 안퍼진거.

		spreadTime = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 벽이면 건너뛰고.
				if (map[i][j] == 1)
					continue;
				
				// 안퍼진 놈이 있어
				if (copy[i][j] == -1) {
					continue;
				}
				if (copy[i][j] == 0) {
					spreadTime = 987654321;
					return;
				}

				// 퍼지고있는 수 중에 가장 오래걸리는놈 체크.
				spreadTime = Math.max(spreadTime, copy[i][j]);
			}
		}

//		System.out.println(spreadTime);

	}// end finalcheck method

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int room;
	static void bfs(Queue<Virus> vQueue) {
		// 맨처음에는 M개의 바이러스가 들어가 있음.
		
		room = 0;
		while (!vQueue.isEmpty()) {
			Virus v = vQueue.poll();

			// 뽑은 바이러스를 기준으로 4방 bfs탐색 시작.
			for (int i = 0; i < 4; i++) {
				int nr = v.r + dr[i];
				int nc = v.c + dc[i];

				// 배열범위 체크 + 벽이면 continue .. 벽의 위치는 변하지 않으니까 original map을 기준으로 check.
				if (nr < 0 || nc < 0 || nc >= N || nr >= N || map[nr][nc] == 1)
					continue;

				// copy에 비활성 바이러스는 -1,
				// 활성바이러스 위치는 0. + 방문처리

				// 처음오는 곳이면 (방문안한곳, 비활성 바이러스 위치 가능, 벽 불가능)
				if (!visited[nr][nc]) {
					// 0이면 빈칸인거야.
					if (copy[nr][nc] == 0) {
						room++; // 빈칸에 퍼졌으니까 ++
					}
					// 걸린 시간+1 해서 입력
					if(copy[nr][nc]!=-1)
						copy[nr][nc] = v.cnt + 1;

					// totalroom과 room 비교!
					if (totalroom == room) {
//						System.out.println("모든 방이 다 바뀜!");
						// 비활성 바이러스 : -1은 있을 수 있어.
						// final check
						return;
					}
					
					// 방문처리 후 , 큐에 삽입
					visited[nr][nc] = true;
					vQueue.add(new Virus(nr, nc, v.cnt + 1));
				} else {
					// 방문했던 곳이지만, 최소값은 확인하자. 큐에 바로 넣지는 않아.
					// 기존에 소요된 시간보다, 지금 바이러스가 더 빠르다면
					if (copy[nr][nc] > (v.cnt + 1)) {
						copy[nr][nc] = v.cnt + 1;
						vQueue.add(new Virus(nr, nc, v.cnt + 1));
					}
				}
			} // end 4 dir loop
		} // end while loop
	}// end bfs method

	static int totalroom;
	static void copymap() {
		copy = new int[N][N];
		visited = new boolean[N][N];
		totalroom=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// original map에서 copy로 복사
				copy[i][j] = map[i][j];
				// 옮길 때, 방의 개수를 카운트
				if (copy[i][j] == 0)
					totalroom++;
				// 바이러스 위치는 -1로 초기화.
				if (map[i][j] == 2) {
					copy[i][j] = -1;
				}
			}
		}
	}// end copymap method

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}
}
