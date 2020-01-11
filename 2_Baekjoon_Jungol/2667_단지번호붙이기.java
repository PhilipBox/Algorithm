package _solving;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class bj_2667_단지번호붙이기 {

	static int[][] map;
	static boolean[][] visited;
	static int N;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					visited[i][j]=true;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}// end main

	static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// 배열범위체크
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (map[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc]=true;
				cnt++;
				dfs(nr,nc);
			}
		}
	}// end dfs method

}
