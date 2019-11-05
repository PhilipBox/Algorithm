package _1105;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 점심식사시간T {
	static class Person implements Comparable<Person> {
		// 가까운 사람을 먼저 뽑기 위해서
		int r, c;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
			dist = new int[2];
		}

		int dist[];
		int sel; // 자신에게 배정된 계단 번호

		@Override
		public int compareTo(Person o) {
			// 정렬을 하면, 자신이 배정된 계단으로까지의 거리가 짧은 애가 먼저 나옴.
			return dist[sel] - o.dist[o.sel];
		}
	}

	static class Stair {
		int r, c, height;

		public Stair(int r, int c, int height) {
			this.r = r;
			this.c = c;
			this.height = height;
		}
	}

	static int[][] map;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// N*N을 순회하면서 입력을 받는데,
			// 사람일경우 사람 배열에 사람정보를 저장 (행,열 좌표)
			// 계단일 경우 계단 배열에 계단정보를 저장(행,열 좌표, 깊이)
			N = sc.nextInt();
			map = new int[N][N];
			Stair[] stairs = new Stair[2]; // 2개 고정
			Person[] person = new Person[10]; // 최대 10명
			int sCnt = 0;
			int pCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 0)
						continue;
					else if (map[i][j] == 1) {
						// 사람
						person[pCnt++] = new Person(i, j);
					} else { // 계단 정보 입력
						stairs[sCnt++] = new Stair(i, j, map[i][j]);
					}
				}
			}

			// 사람과 계단간의 거리를 구해놓는 것이 편함.
			// 1. 각 모든 사람들이 각 계단까지의 거리를 기억.
			// 2. 각 모든 계단이 각 사람들까지의 거리를 기억
			// 3. 다른 자료 공간을 준비.
			// 1번으로 해보자.

			// 모든 사람들이 각 게단까지의 거리를 계산
			for (int i = 0; i < pCnt; i++) {
				for (int j = 0; j < sCnt; j++) {
					person[i].dist[j] = Math.abs(person[i].r - stairs[j].r) + Math.abs(person[i].c - stairs[j].c) + 1;
				}
			}
			ans = 987654321;
			powerSet(person, stairs, 0, pCnt);
			System.out.println("#"+tc+" "+ans);
			
			// 각 사람들을 모든 경우의 수로 계단에 배정하기 위한 부분집합.

		} // end test cases
	}// end main

	static int ans = 987654321;
	
	// idx 는 사람
	static void powerSet( Person[] person, Stair[] stairs, int idx, int pCnt ) {
		if(idx == pCnt) {
			int[][] timeTable = new int[2][200];
			PriorityQueue<Person> pq = new PriorityQueue<>();
			int max = 0;
			for(int i = 0; i < pCnt; i++) {
				pq.add(person[i]);
			}
			while(!pq.isEmpty()) {
				Person p = pq.poll();
				int from = p.dist[p.sel];
				int to = from + stairs[p.sel].height;
				for(int j = from; j < to; j++){
					if( timeTable[p.sel][j] == 3) {
						to++;
						continue;
					}
					timeTable[p.sel][j]++;
				}
				if( max < to )
					max = to;
			}
			ans = Math.min(ans, max);
			return;
		}
		
		person[idx].sel = 0;
		powerSet(person, stairs, idx+1, pCnt);
		person[idx].sel = 1;
		powerSet(person, stairs, idx+1, pCnt);
	}

}
