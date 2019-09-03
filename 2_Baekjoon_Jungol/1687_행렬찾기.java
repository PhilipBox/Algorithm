package _solving;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1687_행렬찾기 {
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		//정렬 - 행기준 
		
		@Override
		public int compareTo(Pos o) {
			if(this.r*this.c > o.r*o.c)
				return 1;
			else if(this.r*this.c == o.r*o.c)
				return this.r - o.r;
			
			return this.r*this.c - o.r*o.c;
		}
	}
	
	static int N;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static Queue<Pos> queue;
	static ArrayList<Pos> squareList;
	
	static int start_r, start_c, end_r, end_c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			queue = new LinkedList<Pos>();
			
			//이거를 행기준으로 정렬해야해 
			squareList = new ArrayList<Pos>();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 첫 좌표부터 하나하나 bfs 검사.
			// 갔던곳이라면 방문배열로 거르기 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					//방문했던 곳(bfs탐색완료) 이거나 빈 병(0)이면 continue;
					if(map[i][j]==0)
						continue;
					//0이아닌 숫자이고, 방문안했던 곳이면 첫 화학물질 발견
					queue.add(new Pos(i,j));
					posInitialize();
					findChem(i,j);
				}
			}
			
			Collections.sort(squareList);
			System.out.print("#"+tc+" "+squareList.size()+" ");
			for(Pos p : squareList)
				System.out.print(p.r +" "+p.c+" ");
			System.out.println();
		}//end test cases
		
	}//end main
	
	static void posInitialize() {
		 start_r = N+1;
		 start_c = N+1;
		 end_r = -1;
		 end_c = -1;
	}
	
	// 첫 화학물질을 발견한 순간 처음 들어옴(화학물질 상자의 좌측 상단 꼭지점)
	static void findChem(int r, int c) {
		
		while(!queue.isEmpty()) {
			
			Pos p = queue.poll();
			
			// 시작위치 저장 (시작위치는 항상 제일 작은r,c이고)
			if(p.r < start_r)
				start_r = p.r;
			if(p.c < start_c)
				start_c = p.c;
			
			// 끝나는 위치 저장 (끝나는 위치는 가장 큰 r,c이니까) 
			if(p.r > end_r) 
				end_r = p.r;
			if(p.c > end_c)
				end_c = p.c;
			
			//갈수있는 곳 탐색 
			for(int i=0; i<4; i++) {
				int nr = dr[i] + p.r;
				int nc = dc[i] + p.c;
				
				//배열 범위 확인 
				if(nr<0 || nc<0 || nr>= N || nc>= N)
					continue;
				
				//방문했던곳이 아니고, 빈병(0)이 아니면 큐에 담는다!
				if(map[nr][nc]!=0) {
					//방문표시 
					map[nr][nc]=0;
					queue.add(new Pos(nr,nc));
				}
			}//end 4방체크 
		}//end while
		
		//queue에 더이상 아무것도 남아있지 않을 때 도달.
		//4각형의 크기를 구할 수 있음, 결과 list에 넣기.
		squareList.add(new Pos(end_r-start_r+1, end_c-start_c+1));
	}//end findChem method
}
