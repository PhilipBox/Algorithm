package _solving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2206_벽부수고이동하기 {
	
	static class Pair{
		int r;
		int c;
		int chance=1;
		int cnt;
		public Pair(int r, int c, int cnt, int chance) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.chance = chance;
		}
	}
	
	static int R;
	static int C;
	
	static int[][] map;
	// chance 있는 경우의 방문체크 배열 
	static boolean[][] visited;
	// chance 없는 경우의 방문체크 배열 
	static boolean[][] visited2;
	static int chance=1;

	static Queue<Pair> queue;

	//4방체크 상하좌우 
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		//시작좌표는 1,1
		map = new int[R+1][C+1];
		visited = new boolean[R+1][C+1];
		visited2 = new boolean[R+1][C+1];
		queue = new LinkedList<Pair>();
		
		
		//지도 값 초기화(1,1부터)
		for(int i=1; i<=R; i++) {
			String s = sc.next();
			for(int j=1; j<=C; j++) {
				map[i][j]=s.charAt(j-1) -'0';
			}
		}
		
		//시작위치 넣기, 방문표시
		queue.add(new Pair(1,1,1,1));
		visited[1][1]=true;
		
		bfs();
		
		//한번도 목적지에 도착하지 못했다면.
		if(ans==Integer.MAX_VALUE)
			ans=-1;
		System.out.println(ans);
	}//end main
	

	
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			// 큐에서 꺼낸다.
			Pair p = queue.poll();
				
			// 최종목적지(R,C)에 도착했을 때만 카운트 집계,비교 
			if(p.r==R && p.c==C) {
				ans = Math.min(ans, p.cnt);
				return;
			}

			//4방체크 
			for(int i=0; i<4; i++) {
				int nr = dr[i] + p.r;
				int nc = dc[i] + p.c;
				
				// 갈수있는 배열 범위 체크.
				if(nr<=0 || nc<=0 || nr>R || nc>C)
					continue;
				
				// 찬스가 있는 경우(벽을 뽀갤수있는 기회가 남아있는경우)
				if(p.chance==1) {
					// 벽이 아닌데 이미 왔던 곳이라면 빠끄
					if(map[nr][nc]==0 && visited[nr][nc])
						continue;
					
					// 다음 방문할곳이 벽(1)이라면 
					if(map[nr][nc]==1) {
						// 뿌순놈들 방문배열을 방문했던적이 없다면 
						if(!visited2[nr][nc]) {
							// 뿌순놈들 방문배열에 방문확인 해줌. 
							visited2[nr][nc]=true;
							
							// chance부분을 바꿔줘버려서 다음 4방체크를 할때 값에 변화가 생겼음.
							// 변수하나를 만들어 담고 queue에 넣어줘야한다..ㅠㅠ
//							p.chance--; //찬스 깎아서 큐에 처넣을거임  <<이렇게하면 안돼
							int chances = p.chance-1;
							queue.add(new Pair(nr,nc,p.cnt+1, chances));
						}
						else // 다음 방문할곳이 벽이고 방문했던곳이면 빠끄 
							continue;
					}
					// 이 아래는 벽 안뿌수고 계속 기릿기릿 하는거 
					else{
						visited[nr][nc]=true;
						queue.add(new Pair(nr,nc,p.cnt+1, p.chance));
					}
				}
				// 찬스가 없다면 
				else {
					// 찬스가 없는데, 벽을 만나면 끝내버려 
					if(map[nr][nc]==1)
						continue;
					
					// 방문 여부 확인( 모든 방문배열 확인 )
					if(visited2[nr][nc] || visited[nr][nc])
						continue;
					// 뿌순 방문배열만 방문체크 
					visited2[nr][nc]=true;
					queue.add(new Pair(nr,nc,p.cnt+1, p.chance));
				}
			}//end 4방체크 for
		}
	}//end bfs
}