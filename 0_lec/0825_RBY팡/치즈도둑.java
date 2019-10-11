import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 치즈도둑 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); //N(2 ≤ N ≤ 100)
			int[][] map = new int[N+2][N+2];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int max = 1;
			for (int day = 0; day <= 100; day++) {
				boolean[][] visited = new boolean[N+2][N+2];
				int cnt = 0;
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						//현재 위치가 day보다 큰 덩어리를 세자.
						if( !visited[i][j] && map[i][j] > day) {
							cnt++;
							//dfs 혹은 bfs탐색을 통해서. 상하좌우 위치이면서 날짜보다 더 큰 값들에 대해 방문체크
							//todo
//							dfs(map, visited, i, j, day);
							
							//Point객체를 담을 큐를 준비.
							Queue<Point> queue = new LinkedList<>();
							//처음 방문하는 위치에 대해 방문체크하고 Point객체를 큐에 삽입.
							queue.add(new Point(i,j));
							visited[i][j] = true;
							//큐에 Point객체가 바닥날때까지
							while( !queue.isEmpty() ) {
								//	큐에서 하나 꺼내서.
								Point p = queue.poll();
								//  상하좌우로 먹을 수 있는 치즈가 있다면 큐에 추가
								for(int d = 0; d < 4; d++) {
									int nr = p.r + dr[d];
									int nc = p.c + dc[d];
									//상하지 않았고 (날짜보다 크고) 먹지않았다면(방문체크안되있으면)
									if( map[nr][nc] > day && !visited[nr][nc] ) {
										visited[nr][nc] = true;
										queue.add(new Point(nr,nc));
									}
								}
							}
						}
					}
				}
				max = Math.max(max, cnt);
			}
			System.out.println("#" + tc + " " + max);
		}
	}
	static class Point{
		int r,c;
		Point(int r,int c){
			this.r = r;
			this.c = c;
		}
	}
	
	
	
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static void dfs(int[][] map, boolean[][] visited, int r, int c, int day) {
		visited[r][c] = true;
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if( !visited[nr][nc] &&map[nr][nc] > day ) {
				dfs(map, visited, nr, nc, day);
			}
		}
	}
}










