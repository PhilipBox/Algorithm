import java.util.Scanner;

public class 정삭각형방 {
	static int[][] map;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			//상하좌우에 맨 첫줄과 맨 끝줄을 그냥 만들어둬서 경계선으로 활용합시다.
			map = new int[N+2][N+2];
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++)
					map[i][j] = sc.nextInt();
			}
			//최초 정답객체에는 후진답을 하나 넣어두고 ㅎㅎ
			result = new Ans(987654321,0);
			//dfs출발. dfs는 모든 방으로 부터 출발
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++)
					dfs(i, j, map[i][j], 1);
			}
			System.out.println("#" + tc + " " + result.toString());
		}
	}
	static class Ans implements Comparable<Ans>{
		int pos;//시작점의 값
		int cnt;//내가 밟아온 칸의 갯수
		Ans(int pos, int cnt){
			this.pos = pos;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Ans o) {
			// TODO Auto-generated method stub
			if( this.cnt == o.cnt )
				return this.pos - o.pos;
			return o.cnt - this.cnt;
		}
		public String toString() {
			return this.pos + " " + this.cnt;
		}
	}
	static Ans result;
	//상태공간트리에서 각각의 상태에 필요한 값. 현재 좌표. 처음칸이 몇이었는지. 몇칸 이동했는지.
	static void dfs(int r, int c, int init, int cnt) {
		//기저파트는 생각하지않아도. 언젠간 갈길이 사라질거임.
		//그때그때 현재의 상태가 최적의 답인지 갱신해나가야됨.
		Ans ans = new Ans(init, cnt);
		if( result.compareTo(ans) > 0 )
			result = ans;
		
		//사방에 대해서
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//이동하려는 곳이 현재위치보다 1크다면ㅋㅋ
			if(map[nr][nc] == map[r][c]+1) {
				dfs(nr, nc, init, cnt+1);
			}
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
}








