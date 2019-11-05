package _1105;

import java.util.Scanner;

public class swea_2383_점심식사시간 {

	static class Person {
		int r, c;
		int[] dist;
		int sel;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
			dist = new int[2];
		}
	}

	static class Stair {
		int r, c;
		int height;

		public Stair(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.height = h;
		}
	}

	static int N;
	static int[][] map;
	static Person[] person;
	static Stair[] stair;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // map의 크기
			map = new int[N][N];
			person = new Person[10]; // 최대 10명
			stair = new Stair[2]; // 계단 2개 고정

			int pCnt = 0;
			int sCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 0)
						continue;
					else if(map[i][j] == 1) 	
						person[pCnt++] = new Person(i,j);
					else
						stair[sCnt++] = new Stair(i,j,map[i][j]);
				}
			}
			
			for(int i=0; i<pCnt; i++) {
				for(int j=0; j<sCnt; j++) {
					// 도착해서 1분 대기하는 것 1 더해준다
					person[i].dist[j] = Math.abs(person[i].r-stair[j].r) + Math.abs(person[i].c - stair[j].c) + 1; 
				}
			}

		} // end test cases
	}// end main
	
	static void powerset(int idx, int pCnt) {
		if(idx == pCnt) {
			// 다 골라진 상태
			
			return;
		}
		person[idx].sel = 0;
		powerset(idx+1, pCnt);
		person[idx].sel = 1;
		powerset(idx+1, pCnt);
	}//end powerset method
	
	
	
}
