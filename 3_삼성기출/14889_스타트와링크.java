package _solving;

import java.util.Scanner;

public class bj_14889_스타트와링크 {

	static int N;
	static int[][] adj;
	static int cnt;
	static int res = 987654321;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new int[N][N];
		// 능력치 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				adj[i][j] = sc.nextInt();
		}
		PS(new boolean[N], 0);

		System.out.println(res);
	}

	static void PS(boolean[] sel, int idx) {
		if (idx == sel.length) {
			if (cnt >= (int) (Math.pow(2, sel.length) / 2))
				return;
			cnt++;
			int Tcnt = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i])
					Tcnt++;
			}
			if (Tcnt == sel.length / 2) {
				// 여기서 진행
				// 딱 절반으로 나눠서 뽑음. 
				//T팀
				int Tp = getTpower(sel);
				//F팀 
				int Fp = getFpower(sel);
				res = Math.min(res, Math.abs(Tp-Fp));
			}
			return;
		}
		sel[idx] = true;
		PS(sel, idx + 1);
		sel[idx] = false;
		PS(sel, idx + 1);
	}// end PS method


	static int getTpower(boolean[] sel) {
		int Tpower =0;
		for(int i=0; i<sel.length; i++) {
			if(sel[i]) {
				for(int j=0; j<sel.length; j++) {
					if(sel[j]) {
						Tpower += adj[i][j];
					}
				}
			}
		}
		return Tpower;
	}
	

	static int getFpower(boolean[] sel) {
		int Fpower =0;
		for(int i=0; i<sel.length; i++) {
			if(!sel[i]) {
				for(int j=0; j<sel.length; j++) {
					if(!sel[j]) {
						Fpower += adj[i][j];
					}
				}
			}
		}
		return Fpower;
	}
}
