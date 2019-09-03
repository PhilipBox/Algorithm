import java.util.Scanner;

public class d4_정사각형방 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int Max = 0;
	static int MaxV =-1;
	static int MaxValue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			Max =0;
			MaxValue = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			}
			
			// 모든 좌표에 대해서 고려 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = true;
					MaxV = map[i][j];
					dfs(i,j,0);
					visited[i][j] = false;
				}
			}
			System.out.println("#"+tc+" "+MaxValue+" "+(Max+1));
		}//end test cases
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void dfs(int r, int c, int cnt) {
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			
			// 배열범위 밖
			if(nr<0 || nc<0 || nr>=N || nc>=N)
				continue;
			
			if(!visited[nr][nc] && map[nr][nc] == map[r][c]+1) {
				visited[nr][nc] = true;
				dfs(nr,nc, cnt+1);
			}
			visited[nr][nc]=false;
			
			if(cnt>=Max) {
				if(cnt==Max) {
					MaxValue = Math.min(MaxValue, MaxV);
				}
				else
					MaxValue = MaxV;
				Max = cnt;
			}
		}
	}
}
