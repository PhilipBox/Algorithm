package beakjoon;

import java.util.Scanner;

public class bj_10026_적록색약 {
	
	static char[][] map1;
	static char[][] map2;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int N;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static int cnt1=0;
	static int cnt2=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map1 = new char[N][N];
		map2 = new char[N][N];
		
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map1[i][j] = str.charAt(j);
				if(str.charAt(j)=='G') {
					map2[i][j] = 'R';
				}
				else
					map2[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited1[i][j]) {
					visited1[i][j]=true;
					cnt1++;
					dfs1(i,j, map1[i][j]);
				}
				if(!visited2[i][j]) {
					visited2[i][j] = true;
					cnt2++;
					dfs2(i,j, map2[i][j]);
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
		
	}//end main
	
	// 정상인 dfs
	static void dfs1(int r, int c, char color) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 배열범위 체크 
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			// 방문했던 곳이면 패스 
			if(visited1[nr][nc]) continue;
			// 다른색깔이면 패스
			if(map1[nr][nc] != color) continue;
			
			visited1[nr][nc]=true;
			dfs1(nr,nc, color);
		}
	}//end dfs1 method
	
	// 색약자 dfs
	static void dfs2(int r ,int c, char color) {
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 배열범위 체크
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			// 방문했던 곳이면 패스 
			if(visited2[nr][nc]) continue;
			// 다른색깔이면 패스 
			if(map2[nr][nc] != color) continue;
			
			visited2[nr][nc] = true;
			dfs2(nr,nc, color);
		}
	}//end dfs2 method
}
