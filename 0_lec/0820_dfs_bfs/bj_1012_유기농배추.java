import java.util.Scanner;

public class bj_1012_유기농배추 {
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] matrix;
	static int[][] visited;
	static int M;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			//가로길이
			M = sc.nextInt();
			//세로길이
			N = sc.nextInt();
			// 배추위치의 개수
			int K = sc.nextInt();
			
			matrix = new int[50][50];
			visited = new int[50][50];
			
			//배추위치 입력
			for(int i=0; i<K; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				matrix[b][a]=1;
			}
			System.out.println();
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++) {
					System.out.print(matrix[i][j]+" ");
				}System.out.println();
			}
			
			int cnt =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
			        if(matrix[i][j]!=0 && visited[i][j]==0){
	                    cnt++;
	                    visited[i][j]++;
	                    dfs(i,j);
	                }
				}
			}//end for
			System.out.println(cnt);
		}
	}//end main
	
	static void dfs(int y, int x) {
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
	        if(ny<0 || ny>=N || nx<0 || nx>=M)
				continue;
	        
	        if(matrix[ny][nx]!=0 && visited[ny][nx]==0){
	            visited[ny][nx]++;
	            dfs(ny,nx);
	        }
		}
	}//end dfs
}
