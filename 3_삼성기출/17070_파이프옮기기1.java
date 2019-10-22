import java.util.Scanner;

public class bj_17070_파이프옮기기1 {
	static class Pipe{
		int r,c,dir;
		public Pipe(int r, int c ,int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static int[][] map;
	static int N;
	
	// 큐
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				map[i][j] = sc.nextInt();
		}
		map[1][1]=1;
		map[1][2]=1; 
		
		dfs(new Pipe(1,2,1));
		System.out.println(cnt);
		
	}
	
	static void dfs(Pipe p) {
		
		if(p.r == N && p.c == N) {
			cnt++;
			return;
		}

		int dir = p.dir;
		switch(dir) {
		
		//가로 
		case 1:
			// 방향 가능여부 탐색 
			 Garo(p.r, p.c);
			// 방향 만족하면 큐에 넣기 .
			break;
			
		//세로	
		case 2:
			 Sero(p.r, p.c);
			break;
		
		//대각
		case 3:
			 Degak(p.r, p.c);
			break;
		}
		//파이프의 현재 위치(dir) 확인 - 1,2,3중 하나겠지.
		
	}//end dfs

	//가로방향기준 탐색
		static void Garo(int r, int c) {
			if(c+1 != N+1 && map[r][c+1]==1)
				return;
			
			// 우
			if(c+1 != N+1 && map[r][c+1]!=1) {
				//우측으로 한번 가는거는 우측 한칸만 있으면 갈 수 있으니까. 배열의 끝만 아니면 됨.
				//그리고 벽이 아니면 됨.
				dfs(new Pipe(r,c+1,1));
			}
			// 우하각
			// 4칸여유가 있는지 봐야해.
			
			// 배열범위 체크부터.
			//우측끝초과 & 아래끝초과 여부
			if(c+1 != N+1 && r+1 != N+1) {
				//우측, 아래, 우측아래에 1이 아닌지 
				if(map[r][c+1]!=1 && map[r+1][c]!=1 && map[r+1][c+1]!=1) {
					//우측아래위치 넣어주고, 방향은 대각선으로.
					dfs(new Pipe(r+1,c+1,3));
				}
			}
		}//end Garo method
		
		//세로방향 기준 탐색
		static void Sero(int r, int c) {
			if(r+1 != N+1 && map[r+1][c] == 1)
				return;
			
			// 하(1칸)
			//아래 한칸 여유가 있고, 1이 아니면.
			if(r+1 != N+1 && map[r+1][c] != 1) {
				dfs(new Pipe(r+1,c,2));
			}
			
			// 우하각(4칸)
			// 배열범위 체크부터
			//우측끝초과 & 아래끝초과 여부
			if(c+1 != N+1 && r+1 != N+1) {
				//우측, 아래, 우측아래에 1이 아닌지 
				if(map[r][c+1]!=1 && map[r+1][c]!=1 && map[r+1][c+1]!=1) {
					//우측아래위치 넣어주고, 방향은 대각선으로.
					dfs(new Pipe(r+1,c+1,3));
				}
			}
		}//end Sero method
		
		//대각방향 기준 탐색
		static void Degak(int r, int c) {
			// 하(1칸)
			//아래 한칸 여유가 있고, 1이 아니면.
			if(r+1 != N+1 && map[r+1][c] != 1) {
				dfs(new Pipe(r+1, c,2));
			}
			
			if(c+1 != N+1 && map[r][c+1]==1)
				return;
			
			// 우
			if(c+1 != N+1 && map[r][c+1]!=1) {
				//우측으로 한번 가는거는 우측 한칸만 있으면 갈 수 있으니까. 배열의 끝만 아니면 됨.
				//그리고 벽이 아니면 됨.
				dfs(new Pipe(r,c+1,1));
			}
			
			// 우하각(4칸)
			// 배열범위 체크부터
			//우측끝초과 & 아래끝초과 여부
			if(c+1 != N+1 && r+1 != N+1) {
				//우측, 아래, 우측아래에 1이 아닌지 
				if(map[r][c+1]!=1 && map[r+1][c]!=1 && map[r+1][c+1]!=1) {
					//우측아래위치 넣어주고, 방향은 대각선으로.
					dfs(new Pipe(r+1, c+1,3));
				}
			}
		}//end Degak method
}
