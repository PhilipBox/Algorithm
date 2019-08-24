import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1012_유기농배추T {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
			for(int tc=1; tc<=T; tc++) {
			//배추밭의 가로길이  1<=M<=50
			int M = sc.nextInt();
			//배추밭의 세로길이 1<=N<=50	
			int N = sc.nextInt();
			//배추밭에 존재하는 배추의 갯수 1<=K<=2500
			int K = sc.nextInt();
			
			int[][] map = new int[N][M];//우리는 이게 더 익숙해
			for(int i=0; i<K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X]= 1;
			}
			
			// 1이 발견되면 지렁이 투척. 지럭이 카운트++
			// 지렁이는 해당 지역에서 연결된 모든 배추들을 커버함을표시.
				//방법 1. 배추밭과 같은 크기의 boolean 배열을 준비.
				//방법 2. 배추밭의 상태값을 바꿔서 표시
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1){
						cnt++;
						//지렁이 전 파 !
						dfs(map,i,j);
					}
				}
			}
			System.out.println(cnt);
			
		}//end test cases
	}//end main
	
	
	static class Cabbage{
		int r;
		int c;
		public Cabbage(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void bfs(int[][] map, int r, int c) {
		Cabbage cabbage = new Cabbage(r, c);
		Queue<Cabbage> queue = new LinkedList<>();
		boolean[][] visited = new boolean[map.length][map[0].length];
		
		queue.add(cabbage);
		map[cabbage.r][cabbage.c] = 0;
		
		while(!queue.isEmpty()) {
			Cabbage cab = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nr = cab.r + dr[i];
				int nc = cab.c + dc[i];
				if(nr<0 || nc <0 || nr >= map.length || nc >=map[nr].length)
					continue;
				if(map[nr][nc]==1) { 
					map[nr][nc]=0;
					queue.add(new Cabbage(nr,nc));
				}
			}
		}
	}
	
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	
	//시작점을 주면.
	//자신의 위치 커버 마크 후
	//상하좌우에 1이 존재하면 재귀호출!

	//즉, 방문해야될 좌표가 매개변수로 들어오면
	//해당 좌표에 마크를 하고
	//해당 위치로부터 상하좌우의 1들을 방문(재귀호출)
	static void dfs(int[][] map, int r, int c) {
		//방문했으니까 지워버령
		map[r][c] = 0;
		
		//4방 검색
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if(nr<0 || nc <0 || nr >= map.length || nc >=map[nr].length)
				continue;
			
			if(map[nr][nc]==1) 
				dfs(map,nr, nc);
		}
	}
}
