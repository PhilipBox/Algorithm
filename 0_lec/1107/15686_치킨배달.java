import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static class Home {
		int r, c;
		int[] dist;
		public Home(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Store {
		int r, c;
		public Store(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int M;
	static int[][] map;

	static Home[] home;
	static Store[] store;

	static int hCnt;
	static int sCnt;
	static int[] sarr;
	static int ans =987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		ArrayList<Home> hlist = new ArrayList<Home>();
		ArrayList<Store> slist = new ArrayList<Store>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0)
					continue;
				else if (map[i][j] == 1)
					hlist.add(new Home(i, j));
				else {
					slist.add(new Store(i, j));
				}
			} // end for loop - j
		} // end for loop - i

		hCnt = hlist.size();
		sCnt = slist.size();
		home = new Home[hCnt];
		store = new Store[sCnt];
		for (int i = 0; i < hCnt; i++) {
			home[i] = hlist.get(i);
			home[i].dist = new int[sCnt];
		}
		for (int i = 0; i < sCnt; i++) {
			store[i] = slist.get(i);
		}

		sarr = new int[sCnt];
		for (int i = 0; i < sCnt; i++) {
			sarr[i] = i;
		}

		// 집으로부터 각 치킨집까지의 거리를 저장
		for (int i = 0; i < hCnt; i++) {
			for (int j = 0; j < sCnt; j++) {
				home[i].dist[j] = Math.abs(home[i].r - store[j].r) + Math.abs(home[i].c - store[j].c);
			}
		}
		ans = 987654321;
		comb(new int[M], 0, 0);
		System.out.println(ans);
	}// end main

	static void comb(int[] sel, int k, int idx) {
		if (idx == sel.length) {
			// 살리는것만 골라놨음.
			int sum=0;
			for (int i = 0; i < hCnt; i++) {
				int cDist=987654321;
				for(int j=0; j<sel.length; j++) {
					cDist = Math.min(cDist, home[i].dist[sel[j]]);
				}
				sum += cDist;
			}
			//sum은 모든 집에서의 치킨거리의 합.
			ans = Math.min(ans, sum);
			
			return;
		}
		if (k == sarr.length)
			return;

		sel[idx] = sarr[k];
		comb(sel, k + 1, idx + 1);
		comb(sel, k + 1, idx);
	}// end comb

}
