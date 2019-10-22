import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj_16236_아기상어 {
	static class Shark {
		int r,c,size,upgrade;
		public Shark() {
			this.size = 2;
			this.upgrade = 2;
		}
	}
	static class Fish implements Comparable<Fish> {
		int r,c,dist,size;

		public Fish(int r, int c, int size, int dist) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if( this.dist == o.dist ) {
				if(this.r == o.r) {
					return this.c-o.c;
				}else return this.r-o.r;
			} 
			return this.dist-o.dist;
		}
	}// end fish class

	static int N;
	static int[][] map;
	static Shark bs;
	static PriorityQueue<Fish> fishQ;
	static boolean[][] visited;
	static int time;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		bs = new Shark(); // baby shark 객체 생성
		fishQ = new PriorityQueue<>();
		// 공간정보 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					bs.r = i;
					bs.c = j;
					map[i][j]=0;
				}
			}
		}

		while (true) {
			// 먹을 수 있는 물고기가 없으면 끗.
			if (!findFish())
				break;
			else{
				// 여기에 왔다는 것은, '먹을 수 있다는 것'
				Fish fs = fishQ.poll();
				
				// 먹었을 때 진화여부 확인 및 진화
				// 먹었으니까, 업그레이드 카운트 --
				bs.upgrade--;
				// 만약 크기만큼 다 먹었으면 진화!
				if (bs.upgrade == 0) {
					bs.size++;
					bs.upgrade = bs.size;
				}
				// 상어가 먹어버렸엉
				bs.r = fs.r;
				bs.c = fs.c;
				
				// 먹은 물고기 0으로 
				map[fs.r][fs.c]=0;
				// 먹느라 소요된 시간 더하기
				time += fs.dist;
			}
		} // end while loop
		System.out.println(time);
	}// end main

	static boolean findFish() {
		fishQ.clear();
		// 현재 상어 위치에서 먹을 수 있는 물고기 탐색
		bfs(bs.r, bs.c, bs.size);
		if (fishQ.isEmpty())
			return false;
		else 
			return true;
	}// end findfish method

	static void bfs(int r, int c, int size) {
		visited = new boolean[N][N];
		visited[r][c]=true;
		Queue<Fish> move = new LinkedList<>();
		move.add(new Fish(r, c, size, 0));

		int minDist = 999;
		while (!move.isEmpty()) {
			Fish f = move.poll();
			// 이미 더 가까이 위치한, 먹을 수 있는 물고기가 있음.
			if (f.dist > minDist)
				break;
			for (int i = 0; i < 4; i++) {
				int nr = f.r + dr[i];
				int nc = f.c + dc[i];
				// 배열 범위 체크
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
					continue;
				// 가려는 곳이 물고기 크기가 더 크다면 못가.
				if (map[nr][nc] > f.size)
					continue;
				// 여기까지 왔으면 이동은 가능한 곳. 이동가능한 곳을 move큐에 넣기
				visited[nr][nc]=true;
				move.add(new Fish(nr, nc, f.size, f.dist + 1));
				// 먹을 수 있는 쉐끼 찾기
				if (map[nr][nc] > 0 && map[nr][nc] < f.size) {
					fishQ.add(new Fish(nr, nc, map[nr][nc], f.dist + 1));
					minDist = f.dist + 1;
				}
			}
		} // end while loop
	}// end bfs
}