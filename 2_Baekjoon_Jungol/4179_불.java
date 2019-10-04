import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 불먼저 퍼뜨림
// 불이 전부 퍼지는데 걸리는 시간을가지고, 
// 내가 움직일때 움직일 수 있는 여부를 결정 (불이 먼저 퍼진상태여야 하므로 부등호 주의)
// 실수했던 부분. -> 불이 퍼지지않았을 때 map(시간)은 0이었는데, 등호때문에 바로 continue를 해버렸다.
// 그래서 map이 0이 아닐때라는 && 조건을 넣어줘서 해결했다.

// http://acm.student.cs.uwaterloo.ca/~acm00/090613/data/
// 여기서 B.0.dat는 테케 , diff는 정답 

public class bj_4179_불 {
	static class POS{
		int r;
		int c;
		int time;
		public POS(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int R;
	static int C;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<POS> fire;
	static Queue<POS> jihoon;
	
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R+2][C+2];
		visited = new boolean[R+2][C+2];
		fire = new LinkedList<POS>();
		jihoon = new LinkedList<POS>();
		bound();
		for(int i=1; i<R+1; i++) {
			String str = sc.next();
			for(int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if(c=='#') map[i][j+1] = -9;
				if(c=='F') {
					map[i][j+1] = 1;
					visited[i][j+1]=true;
					fire.add(new POS(i,j+1,0));
				}
				if(c=='J') jihoon.add(new POS(i, j+1, 1));
			}
		}
		fire_bfs();
		visited = new boolean[R+2][C+2];
		escape_bfs();
		if(res==Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
		else System.out.println(res);
	}//end main
	
	static void fire_bfs() {
		while(!fire.isEmpty()) {
			POS p = fire.poll();
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				//벽이든, 바깥범위든 음수니까 continue.
				if(map[nr][nc]<0) continue;
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				map[nr][nc] = p.time+1;
				fire.add(new POS(nr,nc,p.time+1));
			}
		}//end while
	}//end fire_bfs method
	
	static void escape_bfs() {
		while(!jihoon.isEmpty()) {
			POS p = jihoon.poll();
			visited[p.r][p.c]=true;
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				//탈출 
				if(map[nr][nc]==-1) {
					res = Math.min(res, p.time);
					continue;
				}
				//벽이면 빠끄
				if(map[nr][nc]==-9) continue;
				//불난곳 빠끄
				if(visited[nr][nc]) continue;
				// 불이 안퍼졌을때 고려해줘야해. map이 0일때 ㅠㅠㅠㅠ
				if(map[nr][nc] !=0 && p.time >= map[nr][nc]) continue;
				visited[nr][nc]=true;
				jihoon.add(new POS(nr,nc,p.time+1));
			}
		}
	}
	
	static void bound() {
		//맨위, 맨아래 초기화
		for(int i=0; i<C+2; i++) {
			map[0][i] = -1;
			map[R+1][i] = -1;
		}
		//좌 ,우 초기화
		for(int i=0; i<R+2; i++) {
			map[i][0] = -1;
			map[i][C+1] = -1;
		}
	}
}
