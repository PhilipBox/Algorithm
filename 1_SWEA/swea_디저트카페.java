import java.util.Scanner;
public class swea_디저트카페 {
	static int[][] map;
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			ans = -1;
			for(int i=0; i<N; i++) for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					recur(i,j, i ,j , new boolean[101], 0, 1);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}//end test cases
	}//end main
	
	static int ans;
	static void recur(int tr, int tc, int nr, int nc, boolean[] desert, int dir, int sum) {
		desert[map[nr][nc]]=true;
		// 방향 초과(0~3)
		if(dir>3) return;
		// 각 방향에 따른 좌표 변화
		nr += dr[dir];
		nc += dc[dir];
		
		//돌아서 원래 점으로 돌아옴
		if(nr==tr && nc==tc) {
			ans = Math.max(ans, sum);
			return;
		}
		
		// 가장 위에 찍힌 점보다 더 위에 올라갈 수 없음.(작을 수 없음)
		if(nr<tr) return;
		if(nr<0 || nc<0 || nr> N-1|| nc>N-1) return;
		
		//이미 방문했던 디저트 가게라면 return
		if(desert[map[nr][nc]]) return;
		
		desert[map[nr][nc]]=true;
		recur(tr,tc,nr,nc,desert, dir, sum+1);
		recur(tr,tc,nr,nc,desert, dir+1, sum+1);
		desert[map[nr][nc]]=false;
	}//end recur 
}