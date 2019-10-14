import java.util.Arrays;
import java.util.Scanner;

public class bj_17471_게리맨더링 {

	static int[] area;
	static int N;
	static int[][] adj;

	static boolean[] visited;

	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		area = new int[N+1];
		visited = new boolean[N];
		adj = new int[N+1][N+1];

		// 지역구 인원 입력 (인덱스 1~N까지)
		for (int i = 1; i <= N; i++)
			area[i] = sc.nextInt();

		
		// 지역구 연결 상태
		for (int i = 1; i <= N; i++) {
			int k = sc.nextInt();
			for (int j = 0; j < k; j++) {
				int y = sc.nextInt();
				adj[i][y] = 1;
				adj[y][i] = 1;
			}
			System.out.println(Arrays.toString(adj[i]));
		}

		// 지역구 나누기
		//powerset(new boolean[N], 0);

	}// end main

	static void powerset(boolean[] sel, int idx) {
		if (idx == N) {
			int Tflag = -1;
			int Fflag = -1;
			for (int i = 0; i < sel.length; i++) {
				// 둘다 겟
				if (Tflag != -1 && Fflag != -1)
					break;
				if (sel[i]) {
					if (Tflag != -1)
						continue;
					Tflag = i;
				}
				if (!sel[i]) {
					if (Fflag != -1)
						continue;
					Fflag = i;
				}
			}

			if (Tflag == -1 || Fflag == -1)
				return;

			
			Tvisited = new boolean[N];
			Fvisited = new boolean[N];
			// 각각 들어가서 진행
			Tvisited[Tflag] = true;
			Tdfs(sel, Tflag+1);

			Fvisited[Fflag] = true;
			Fdfs(sel, Fflag+1);

			
		
//			System.out.println(Arrays.toString(sel));
			return;
		}
		sel[idx] = false;
		powerset(sel, idx + 1);
		sel[idx] = true;
		powerset(sel, idx + 1);
	}

	static int Tcnt = 0;
	static int Fcnt = 0;
	static boolean[] Tvisited;
	static boolean[] Fvisited;

	static void Tdfs(boolean[] sel, int n) {
		//들어와서 인구수 더하기
		Tcnt += area[n];
		
		// 선택지 모두 순회
		for(int i=0; i<sel.length; i++	) {
			//T니까 F면 빠끄
			if(!sel[i]) continue;
			if(adj[n][i+1]==1) {
				Tvisited[i]=true;
				Tdfs(sel, i+1);
			}
		}
	}

	static void Fdfs(boolean[] sel, int n) {
		//들어와서 인구수 더하기
		Fcnt += area[n];
		
		// 선택지 모두 순회
		for(int i=0; i<sel.length; i++	) {
			//F니까 T면 빠끄
			if(sel[i]) continue;
			if(adj[n][i+1]==1) {
				Fvisited[i]=true;
				Fdfs(sel, i+1);
			}
		}
	}
	
}
