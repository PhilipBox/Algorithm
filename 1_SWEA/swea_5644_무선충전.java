package _1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class swea_5644_무선충전 {
	static class BC implements Comparable<BC>{
		int r, c;
		int range;
		int power;

		public BC(int r, int c, int range, int power) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}
		@Override
		public int compareTo(BC o) {
			return power - o.power;
		}
	}

	static int M;
	static int A;
	static int[][] person;
	static BC[] charger;

	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); // 총 이동 시간
			A = sc.nextInt(); // BC의 개수
			person = new int[2][M + 1];
			charger = new BC[A];
			ans = 0;
			// 사람1,2의 T 0일때.
			person[0][0] = 0;
			person[1][0] = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= M; j++) {
					person[i][j] = sc.nextInt();
				}
			}
			// A개수 - 충전기의 r,c, range, power 입력
			for (int i = 0; i < A; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				charger[i] = new BC(r, c, sc.nextInt(), sc.nextInt());
			}

			int Ar = 1;
			int Ac = 1;
			int Br = 10;
			int Bc = 10;
			int sum=0;
			for(int time=0;  time<=M; time++) {
				Ar += dr[person[0][time]];
				Ac += dc[person[0][time]];
				Br += dr[person[1][time]];
				Bc += dc[person[1][time]];
				// 현재 좌표에서 영향을 받는 BC들을 각각 리스트에 담아 저장.
				List<BC> Ap = getBC(Ar,Ac);
				List<BC> Bp = getBC(Br,Bc);
				
				if(Ap.size() ==0 && Bp.size() != 0) {
					sum += Collections.max(Bp).power;
				}
				if(Ap.size() != 0 && Bp.size() ==0) {
					sum += Collections.max(Ap).power;
				}
				if(Ap.size() != 0 && Bp.size() != 0) {
					//둘다 1이상.
					int max = 0;
					for(int i=0; i<Ap.size(); i++) {
						for(int j=0; j<Bp.size(); j++) {
							int tmp = Ap.get(i).power + Bp.get(j).power;
							if(Ap.get(i) == Bp.get(j)) {
								tmp /=2;
							}
							max = Math.max(max, tmp);
						}
					}
					sum += max;
				}
			}//end M 시간동안 (time)
			System.out.println("#"+tc+" "+sum);
		} // end test cases
	}// endmain
	
	static List<BC> getBC(int r, int c){
		List<BC> list = new ArrayList<BC>();
		for(int i=0; i<charger.length; i++) {
			int dist = Math.abs(r - charger[i].r) + Math.abs(c - charger[i].c);
			if(dist <= charger[i].range) {
				list.add(charger[i]);
			}
		}
		return list;
	}//end getBC 
}
