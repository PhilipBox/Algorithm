package _1113;

import java.util.Scanner;

public class bj_1941_소문난칠공주 {

	static char[][] origin; //초기 원본 배열(입력받음)
	static boolean[][] map;	// 멤버 선택 방문배열(인접여부를 확인할 때 쓸것)
	static boolean[] visited; // 1차원으로 표현한 멤버 선택 배열 
	static int ans; 
	static int cnt; // 인접여부를 확인할 때 사용할 멤버 카운트 배열(7명을 확인하기 위함)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		origin = new char[5][5];
		ans =0;
		for (int i = 0; i < 5; i++) {
			String s = sc.next();
			for (int j = 0; j < 5; j++) {
				origin[i][j] = s.charAt(j);
			}
		}

		//0~19의 idx까지만 봐도 됨. 들어가서 i 다음의 index부터 7개를 확인할 것이기 때문.
		for (int i = 0; i < 25; i++) {
			visited = new boolean[25];
			map = new boolean[5][5];
			dfs(i, 1, 0);
		}

		System.out.println(ans);
	}// end main

	static void dfs(int idx, int total, int scnt) {
		// 다솜파 인원 증가
		if (origin[idx / 5][idx % 5] == 'S')
			scnt++;

		//뽑은 인원 멤버로 추가 (1차원 2차원)
		visited[idx] = true;
		map[idx / 5][idx % 5] = true;

		// 뽑고나서 7명이 된다면
		if (total == 7) {
			// snct가 4 이상이면 7명이 인접해있는지 확인한다.
			if (scnt >= 4) {
				adjCheck();
			}
		} else {
			// 뽑은거 다음으로 들어가서 확인
			for (int i = idx + 1; i < 25; i++) {
				// 선택된놈이 아니라면
				if (!visited[i])
					dfs(i, total + 1, scnt);
			}
		}
		// backtracking (원상복귀)
		visited[idx] = false;
		map[idx / 5][idx % 5] = false;
	}// end dfs

	static void adjCheck() {
		// 사용된 녀석 하나만 찾으면 됨 dfs로 확인할거니까
		for(int i=0; i<25; i++	) {
			if(visited[i]) {
				int r = i/5;
				int c = i%5;
				
				boolean[][] adjVisited = new boolean[5][5];
				adjVisited[r][c] = true;
				cnt=1;
				goAdj(r,c,adjVisited);
				return; // 하나 찾았으면  return ( dfs로 퍼져나감 )
			} 
		}
	}

	static void goAdj(int r, int c , boolean[][] adjVisited) {
		// 인접해있음을 확인한 경우
		if(cnt == 7) {
			ans++;
		}
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 배열범위초과
			if(nr<0 || nc <0 || nr >= 5 || nc >=5) continue;
			// 인접 방문배열 확인
			if(adjVisited[nr][nc]) continue;
			
			//뽑았던 멤버가 인접해 있다면 
			if(map[nr][nc]) {
				adjVisited[nr][nc]=true;
				++cnt;
				goAdj(nr,nc,adjVisited);
			}
		}
	}
}
