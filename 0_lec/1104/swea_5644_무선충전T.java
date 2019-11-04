package _1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class swea_5644_무선충전T {
	static class Charger implements Comparable<Charger> {
		int r, c, coverage, power;

		public Charger(int r, int c, int coverage, int power) {
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.power = power;
		}

		@Override
		public int compareTo(Charger o) {
			return power - o.power;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt();//이동횟수
			int A = sc.nextInt();//충전기의 수
			int[][] person = new int[2][M];
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < M; j++)
					person[i][j] = sc.nextInt();
			}
			Charger[] charger = new Charger[A];
			for(int i = 0; i < A; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				charger[i] = new Charger(r, c, sc.nextInt(), sc.nextInt());
			}
			int personA_r = 1;
			int personA_c = 1;
			int personB_r = 10;
			int personB_c = 10;
			int sum = 0;

			// M번 반복을 하면서 충전->이동->충전->이동 ..... 인데 M 번이라 함은 충이 충이 충이 충- 까지야! 그래서 1번 더많게.
			for (int i = 0; i <= M; i++) {
				// 충전
				// -> 각 사람별로 범위에 닿은 모든 충전기를 구한다.
				// -> 상황별로 충전량을 sum에 더할거야.
				List<Charger> pA = getCharger(personA_r, personA_c, charger);
				List<Charger> pB = getCharger(personB_r, personB_c, charger);
				if( pA.size() == 0 && pB.size() != 0) {
					sum += Collections.max(pB).power;
				}
				if( pA.size() != 0 && pB.size() == 0) {
					sum+= Collections.max(pA).power;
				}
				if( pA.size() != 0 && pB.size() != 0) {
					//모든 조합
					int max = 0;
					for(int k = 0; k < pA.size(); k++) {
						for(int j = 0; j < pB.size(); j++) {
							// A,B충전기들의 모든 경우
							int tmp = pA.get(k).power + pB.get(j).power;
							if( pA.get(k) == pB.get(j) )
								tmp /= 2;
							max = Math.max(max, tmp);
						}
					}
					sum += max;
				}
				// 마지막 loop는 충전으로 끝나게.
				if (i == M)
					break;
				// 이동
				personA_r += dr[person[0][i]];
				personA_c += dc[person[0][i]];
				personB_r += dr[person[1][i]];
				personB_c += dc[person[1][i]];
			}
			System.out.println("#" + tc + " " + sum);

		} // end test cases
	}// end main
	static int[] dr = {0, -1 ,0 , 1, 0};
	static int[] dc = {0, 0 , 1, 0 , -1};
	static List<Charger> getCharger(int r, int c, Charger[] charger){
		List<Charger> list = new ArrayList<>();
		for(int i = 0; i < charger.length; i++) {
			if( Math.abs(r - charger[i].r) + Math.abs(c - charger[i].c) <= charger[i].coverage)
				list.add(charger[i]);
		}
		return list;
	}
}// end class