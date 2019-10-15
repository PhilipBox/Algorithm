import java.util.*;

public class BOJ_아기상어_16236 {
	static Scanner sc = new Scanner(System.in);
	static int N, map[][], shSize = 2;
	static boolean visit[][];

	static final int dy[] = { -1, 1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	static boolean valid(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
	
	static class Pos {
		int y, x, len;
		Pos(int y, int x, int len) {
			this.y = y;
			this.x = x;
			this.len=len;
		}
	}
	
	static Comparator<Pos> cmp = new Comparator<Pos>() {
		public int compare(Pos o1, Pos o2) {
			// 거리가 가까운 물고기가 많으면 가장 위에 있는 물고기,
			// 가장 위에 있는 물고기가 많다면 가장 왼쪽에 있는 물고기를 먹는다.
			if(o1.len == o2.len)
				return o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y;
			else
				return o1.len - o2.len;
		};
	};

	static Queue<Pos> bs = new LinkedList<>();

	public static void main(String[] args) {
		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					bs.add(new Pos(i,j,0));
					map[i][j]=0;
				}
			}
		}

		LinkedList<Pos> fish = new LinkedList<>();
		
		int moveCnt = 0, eatCnt = 0;
		while(true) {
			while(!bs.isEmpty()) {
				Pos now = bs.poll();
				for(int d=0;d<4;d++) {
					int ny= now.y+dy[d];
					int nx=now.x+dx[d];
					if(valid(ny,nx) && !visit[ny][nx] && map[ny][nx] <= shSize) {
						visit[ny][nx] = true;
						bs.add(new Pos(ny,nx,now.len+1));
						
						// 크기가 작은 물고기만 먹을 수 있다.
						// 크기가 같은면 먹을수는 없더라도 이동할 수는 있다.
						if(map[ny][nx] != 0 && map[ny][nx] < shSize)
							fish.add(new Pos(ny,nx,now.len+1));
					}
				}
			}
			
			if(!fish.isEmpty()) {
				Collections.sort(fish, cmp);
				
				Pos nowFish = fish.get(0);
				bs.add(nowFish);
				moveCnt = nowFish.len;
				map[nowFish.y][nowFish.x]= 0; 
				eatCnt++;
				if(eatCnt == shSize) {
					eatCnt = 0;
					shSize++;
				}
				fish.clear();
			}else {
				break;
			}
			
			for(int i=0;i<N;i++) {
				Arrays.fill(visit[i], false);
			}
		}
		
		System.out.println(moveCnt);
	}
}