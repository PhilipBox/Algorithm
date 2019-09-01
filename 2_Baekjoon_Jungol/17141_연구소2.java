package _solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17141_연구소2 {
	// 좌표를 기록할 객체 Pos
	static class Pos{
		int r;
		int c;
		int cnt;
		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] copy;
	
	static ArrayList<Pos> vriuslist = new ArrayList<Pos>();
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};

	//바이러스를 놓고 전파시킬 배열 
	static int[][] Vmap;
	//bfs를 위한 queue 
	static Queue<Pos> queue;
	
	static int ANS=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		copy = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int dot = Integer.parseInt(st.nextToken());
				if(dot==2) {
					vriuslist.add(new Pos(i,j,0));
				}
				map[i][j] = dot;
			}
		}
		// 원본은 map은 모든 2의 위치가 기록되어있음.
		// copy라는 배열에 바이러스가 놓여지지 않은 상태로 복사. 
		copyMap();
		
		// 바이러스를 퍼뜨려본다.
		setVirus(0, 0);
		
		
		// 최종 비교.
		if(ANS==Integer.MAX_VALUE)
			ANS=-1;
		System.out.println(ANS);
	}
	
	static void copyMap() {
		// 원본은 map은 모든 2의 위치가 기록되어있음.(바이러스를 놓을 수 있는 모든 위치)
		// copy라는 배열에 바이러스가 놓여지지 않은 상태로 복사. 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==2)
					copy[i][j]=0;
				else
					copy[i][j] = map[i][j];
			}
		}
	}//end copyMap method
	
	
	//바이러스를 M만큼 놓게할 함수
	static void setVirus(int start, int depth) {
		
		if(depth == M) {
			// 지정된 자리에 모두 바이러스를 놓았을 때.
			//복사해보고 퍼뜨리기. 
			
			// 바이러스를 퍼뜨릴 배열 초기화 
			Vmap = new int[N][N];
			queue = new LinkedList<Pos>();
			
			// 초기 바이러스의 위치를 큐에 담는다.
			// 바이러스를 퍼뜨릴 배열에 초기 바이러스 위치를 넣는다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(copy[i][j]==2)
						queue.add(new Pos(i,j,0));
					Vmap[i][j] = copy[i][j];
				}
			}
			
			// 바이러스 퍼뜨리기 - BFS
			SpreadVirus();
			return;
		}// 기저조건 end 
		
		//재귀 조건 
		for(int i=start; i<N*N; i++) {
			// 해당 좌표가 바이러스를 놓을 수 있는 위치인지 확인.
			int r = i/N;
			int c = i%N;
			
			// 바이러스를 놓을 수 있는 자리면 
			if(map[r][c]==2) {
				
				// 바이러스 놔보고!
				copy[r][c]=2;
				setVirus(i+1,depth+1);
				// 원상복귀 
				copy[r][c]=0;
			}
		}
	}//end setVirus method
	
	static void SpreadVirus() {
		//퍼지는데 걸리는 시간을 기록할 변수 
		int temp_max =0;
		while(!queue.isEmpty()) {
			
			Pos p = queue.poll();
			// 가장 오래 걸린 시간 기록. 
			if(p.cnt>temp_max)
				temp_max = p.cnt;
			
			// 큐에서 뽑아서 4방 확인(바이러스를 퍼뜨릴 수 있는지 확인)
			for(int i=0; i<4; i++) {
				int nr = dr[i] + p.r;
				int nc = dc[i] + p.c;
				
				// 배열범위 체크 
				if(nr<0 || nc<0 || nr>=N || nc>=N)
					continue;
				
				// 바이러스가 갈수 있는 곳이면 
				if(Vmap[nr][nc]==0) {
					// 바이러스 전파! 
					Vmap[nr][nc]=2;
					queue.add(new Pos(nr,nc,p.cnt+1));
				}
			}//end 4방체크 loop
		}//end while 
		
		
		// 바이러스가 모두 퍼진 후 상태 확인
		// 퍼지지 않은 곳이 남아있다면, 이 경우는 return하여 pass.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(Vmap[i][j]==0) 
					return;
			}
		}
		
		// 모두 퍼져있다면, 소요시간 비교하여 가장 작은 것과 비교.
		ANS=Math.min(ANS, temp_max);
	}//end SpreadVirus method
}
