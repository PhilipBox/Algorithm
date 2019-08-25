package _BASE;

import java.util.Scanner;

public class bj_2468_안전영역 {
	static int N;
	static int[][] map;	
	static boolean[][] visited;
	static boolean[][] check;

	static int min = 99999;
	static int max = -1;
	
	static int ans ;
	// 아무지역도 물에 잠기지 않으면(높이가 모두 같으면 1이겠지!)
	static int ans_MAX=1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 2][N + 2];
		visited = new boolean[N+2][N+2];
		// 입력 및 최소 최대 추출 
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				if(min>map[i][j])
					min = map[i][j];
				if(max<map[i][j])
					max = map[i][j];
			}
		}
		
		for(int height=min; height<max; height++) {
			ans=0;
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map.length; j++) {
					// 높이보다 같거나 작으면 true로 방문체크. 
					if(map[i][j]<=height) {
						visited[i][j]=true;
					}
				}
			}
			
			check = new boolean[N+2][N+2];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					//방문하지 않은 곳(현재 높이보다 높은 곳이라면 )
					if(!visited[i][j] && !check[i][j]) {
						ans++;
						dfs(i,j);
					}
				}
			}
			if(ans_MAX < ans)
				ans_MAX = ans;
		}
		System.out.println(ans_MAX);
	}// end main

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void dfs(int r, int c) {
		//방문했던 곳이라면 빠끄 
		if(visited[r][c] || check[r][c])
			return;
		
		//방문하지 않았다면 방문체크를 해준다. 
		check[r][c]= true;
		
		//주변 4방체크. 
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			
			//배열을 행,열 한줄씩 늘려놨기 때문에 배열범위 예외처리를 해주지 않아도 된다. 
			dfs(nr,nc);
		}
	}
}
