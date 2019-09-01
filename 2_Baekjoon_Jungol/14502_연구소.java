package _solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_14502_연구소 {
	
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[][] map;
	static int[][] copy;
	static ArrayList<Pos> Viruslist = new ArrayList<Pos>();
	
	static int R;
	static int C;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int AREA;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		copy = new int[R][C];
		AREA=0;
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					Viruslist.add(new Pos(i,j));
			}
		}
		setWall(0,0);
		System.out.println(AREA);
	}//end main
	
	static void setWall(int start, int depth) {
		if(depth==3) {
			// 3개의 벽을 모두 세웠다면. 
			// 바이러스를 퍼뜨려볼 벽을 복사 
			copyMap();
			
			// 바이러스 퍼뜨리기. 
			for(Pos p : Viruslist) {
				SpreadVirus(p.r, p.c);
			}
			
			// 안전한 영역 크기를 구해보기 
			AREA = Math.max(AREA, getSafeArea());
			return; 
		}
		

		//2차원 배열에서의 조합 
		for(int i=start; i<R*C; i++) {
			int r = i/C;
			int c = i%C;
			
			//처음지도에서 빈공간이었으면 
			if(map[r][c]==0) {
				// 벽으로 만들어보고 
				map[r][c]=1;
				setWall(i+1, depth+1);
				// 원상복귀 시키기 
				map[r][c]=0;
			}
		}
	}//end setWall method
	
	static void copyMap() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++)
				copy[i][j] = map[i][j];
		}
	}//end copyMap method
	
	static void SpreadVirus(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			
			//배열범위 체크 
			if(nr<0 || nc<0 || nr>= R || nc >= C)
				continue;
			
			//빈공간이면 바이러스 전파! 
			if(copy[nr][nc]==0) {
				copy[nr][nc]=2;
				SpreadVirus(nr, nc);
			}
		}
	}//end SpreadVirus method
	
	static int getSafeArea() {
		int sum=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++){
				if(copy[i][j]==0)
					sum++;
			}
		}
		return sum;
	}//end getSafeArea method
}//end class