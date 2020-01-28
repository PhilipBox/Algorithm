package Solving;

import java.util.ArrayList;
import java.util.Scanner;

public class boj14502_연구소 {

	static class POS {
		int r;
		int c;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R;
	static int C;
	static int AREA;

	static int[][] map;
	static int[][] copy;

	static ArrayList<POS> VirusList = new ArrayList<POS>();

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		copy = new int[R][C];
		
		// 초기 연구소 상태 입력 및 모든 바이러스 위치 저장 
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==2)
					VirusList.add(new POS(i,j));
			}
		}
		setWall(0,0);
		System.out.println(AREA);
	}

	
	static void setWall(int start, int depth) {
		//벽을 모두 세운 경
		if(depth==3) {
			// 바이러스를 퍼뜨려 볼 벽을 복사
			copyMap();
			
			// 바이러스 퍼뜨리기
			for(POS p : VirusList) {
				// dfs 
				SpreadVirus(p.r, p.c);
			}
			
			// 안전지역 카운팅하기
			// 최대값과 비교하기 
			AREA = Math.max(AREA, SafeArea());
			return;
		}
		
		//2차원 배열에서의 조합.
		for(int i=start; i<R*C; i++) {
			int r = i/C;
			int c = i%C;
			
			//초기 지도에서 빈 공간이었다면.
			if(map[r][c]==0) {
				//벽을 세워본다.
				map[r][c]=1;
				setWall(i+1, depth+1);
				//원상복귀 
				map[r][c]=0;
			}
		}
	}


	static void SpreadVirus(int r, int c) {
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 배열범위 확인 
			if(nr<0 || nc<0 || nr >= R || nc >= C) continue;
			
			// 빈 공간이라면,바이러스 전파.
			if(copy[nr][nc]==0) {
				copy[nr][nc]=2;
				SpreadVirus(nr, nc);
			}
		}
	}
	
	static int SafeArea() {
		int total =0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(copy[i][j]==0)
					total++;
			}
		}
		return total; 
	}
	
	
	
	static void copyMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}// end copyMap method
}
