import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_3187_양치기꿍 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int sheep;
	static int wolf;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전역변수 초기화
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];
		sheep=0;
		wolf=0;
		// 초기 울타리 입력
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++)
				map[i][j] = s.charAt(j);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 울타리는 건너뛴다.
				if (map[i][j] == '#')
					continue;
				// 이미 휩쓸고 간 지역(울타리 영역)이라면
				if (visited[i][j])
					continue;
				// 그렇지 않은 울타리 영역이면 ㄱㄱ
				bfs(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);
	}// end main

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class animal {
		int r;
		int c;

		public animal(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void bfs(int r, int c) {
		// s, w 의 최대값 변수.
		int sMax = 0;
		int wMax = 0;
		visited[r][c] = true;
		
		Queue<animal> queue = new LinkedList<animal>();
		queue.add(new animal(r, c));
		if (map[r][c] == 'v')
			wMax++;
		else if (map[r][c] == 'k')
			sMax++;

		while (!queue.isEmpty()) {
			animal ani = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = ani.r + dr[i];
				int nc = ani.c + dc[i];

				// 배열범위 체크
				if (nr < 0 || nc < 0 || nr > R - 1 || nc > C - 1) continue;
				// 울타리 체크
				if(map[nr][nc]=='#') continue;
				// 갔던곳 체크
				if(visited[nr][nc]) continue;
				
				// 양 또는 늑대 체크 k : 양 , v:늑대
				if(map[nr][nc]=='k') sMax++;
				if(map[nr][nc]=='v') wMax++;
				
				visited[nr][nc]=true;
				queue.add(new animal(nr,nc));
			}
		} // end while loop
		if(sMax>wMax) {
			sheep += sMax;
		}
		else {
			wolf += wMax;
		}
	}// end bfs
}
