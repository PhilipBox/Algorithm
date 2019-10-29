import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {
	static int N;
	static int M;
	static int[][] WBR;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// N,M(3≤N,M≤50)
			M = Integer.parseInt(st.nextToken());
			WBR = new int[N][3];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					switch (str.charAt(j)) {
					case 'W':
						WBR[i][0]++;
						break;
					case 'B':
						WBR[i][1]++;
						break;
					default:
						WBR[i][2]++;
						break;
					}
				}
			}
			//색구분선 경우의수 찾기
			min = 987654321;
			comb(new int[2], 0, 1);
			System.out.println("#"+tc+" "+min);
		}
	}

	static void comb(int[] sel, int idx, int pick) {
		if(idx==sel.length) {
//			System.out.println(sel[0]+" "+sel[1]);
			int sum = 0;
			for (int i = 0; i < sel[0]; i++) {
				sum+=WBR[i][0];
			}
			for (int i = sel[0]; i < sel[1]; i++) {
				sum+=WBR[i][1];
			}
			for (int i = sel[1]; i < N; i++) {
				sum+=WBR[i][2];
			}
			min = Math.min(min, N*M-sum);
			return;
		}
		if(pick>N-1) {
			return;
		}
		sel[idx] = pick;
		comb(sel, idx+1, pick+1);
		comb(sel, idx, pick+1);
	}
}
