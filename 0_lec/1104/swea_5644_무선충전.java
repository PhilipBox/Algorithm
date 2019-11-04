package _1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_5644_무선충전 {
	static class BC {
		ArrayList<Integer> bc;
		int dup;

		public BC() {
			bc = new ArrayList<Integer>();
			dup = 0;
		}
	}

	static class POS implements Comparable<POS> {
		int r;
		int c;
		int range;
		int power;

		public POS(int c, int r) {
			this.r = r;
			this.c = c;
		}

		public POS(int c, int r, int range, int power) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}

		@Override
		public int compareTo(POS o) {
			return power - o.power;
		}

	}

	static BC[][] map;
	static POS[] BCarr;
	static int TIME;
	static int BCcnt;

	static Queue<Integer> A;
	static Queue<Integer> B;
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			TIME = sc.nextInt(); // 총 이동시간
			BCcnt = sc.nextInt(); // BC의 개수
			map = new BC[11][11]; // 맵 선언
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					map[i][j] = new BC();
				}
			}
			BCarr = new POS[9]; // BC를 담을 배열
			A = new LinkedList<Integer>(); // 유저 A 선언
			B = new LinkedList<Integer>(); // 유저 B 선언
			for (int i = 0; i < TIME; i++) // 유저 A 입력(TIME)
				A.add(sc.nextInt());
			for (int i = 0; i < TIME; i++) // 유저 B 입력(TIME)
				B.add(sc.nextInt());
			for (int i = 1; i <= BCcnt; i++) { // BC에 대한 정보 입력
				BCarr[i] = new POS(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}

			for (int bc = 1; bc <= BCcnt; bc++) {
				int bcRange = BCarr[bc].range;
				int bcR = BCarr[bc].r;
				int bcC = BCarr[bc].c;
				for (int i = 1; i <= 10; i++) {
					for (int j = 1; j <= 10; j++) {
						if (bcRange >= getDist(bcR, bcC, i, j)) {
							map[i][j].bc.add(bc);
							map[i][j].dup++;
						}
					}
				}
			} // drawing map

			// 중복되는 지역은 dup가 2 이상이다.
			// dup가 2미만이면 바로 추가하면 된다.
			// A와B의 이동 방향은 queue에 0~5로 들어가 있다. poll 해서 쓰면 됨.

			// A는 1,1에서 출발
			// B는 10,10에서 출발
			int t = 0;
			int Ar = 1;
			int Ac = 1;
			int Br = 10;
			int Bc = 10;
			int sum = 0;
			while (t <= TIME) {

				int Apoll = A.poll();
				Ar += dr[Apoll];
				Ac += dc[Apoll];

				int Bpoll = B.poll();
				Br += dr[Bpoll];
				Bc += dc[Bpoll];

				// t초에 이동한 다음의 좌표가 각각 설정됨.

				int Adup = map[Ar][Ac].dup;
				int Bdup = map[Br][Bc].dup;
				// map - A
				// map - B

				if (Adup == 0 && Bdup == 0) {
					t++;
					continue;
				}
				if (Adup >= 1 && Bdup == 0) {
					// A중에서 제일 큰거
					sum += BCarr[Collections.max(map[Ar][Ac].bc)].power;
				}
				if (Adup == 0 && Bdup >= 1) {
					// B중에서 제일 큰거
					sum += BCarr[Collections.max(map[Br][Bc].bc)].power;
				}
				if (Adup == 1 && Bdup == 1) {
					int Abc = map[Ar][Ac].bc.get(0);
					int Bbc = map[Br][Bc].bc.get(0);
					if (Abc == Bbc) {
						// 같으니까 둘중하나 어느것이든 상관 없음. ( 2나눠서 2번더하나 한번더하나 같음 )
						sum += BCarr[Abc].power;
					} else {
						// 둘이 다른 영역이므로 각각의 배터리 power를 더해준다.
						sum += BCarr[Abc].power;
						sum += BCarr[Bbc].power;
					}
				}
				if (Adup == 1 && Bdup >= 2) {
					int Abc = map[Ar][Ac].bc.get(0);
					for (int i = 0; i < map[Br][Bc].bc.size(); i++) {
						if( map[Br][Bc].bc.get(i) == Abc) {
							map[Br][Bc].bc.remove(i);
							break;
						}
					}
					// A는 하나밖에 없으니까 더하고, B가 A랑 겹치면 지웠으니까 그 상태에서 가장 큰 배터리의 파워를 더함.
					sum+= BCarr[Abc].power;
					sum += BCarr[Collections.max(map[Br][Bc].bc)].power;
				}
				if (Adup >= 2 && Bdup >= 1) {
					int Bbc = map[Br][Bc].bc.get(0);
					for (int i = 0; i < map[Ar][Ac].bc.size(); i++) {
						if( map[Br][Bc].bc.get(i) == Bbc) {
							map[Br][Bc].bc.remove(i);
							break;
						}
					}
					// A는 하나밖에 없으니까 더하고, B가 A랑 겹치면 지웠으니까 그 상태에서 가장 큰 배터리의 파워를 더함.
					sum += BCarr[Collections.max(map[Ar][Ac].bc)].power;
					sum+= BCarr[Bbc].power;
				}
				// 둘다 dup2 이상일때.
				
				
				t++;
			} // end time loop

			// 최종 계산 area
			System.out.println("#"+tc+" "+sum);
		} // end test cases
	}// end main

	static int getDist(int ar, int ac, int br, int bc) {
		int A = Math.abs(ar - br);
		int B = Math.abs(ac - bc);
		return A + B;
	}// end getDist

}
