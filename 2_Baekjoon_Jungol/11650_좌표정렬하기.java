package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj_11650_좌표정렬하기 {
	static class POS {
		int r;
		int c;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 		int N = Integer.parseInt(st.nextToken());
 		int[][] arr = new int[N][2];
 		
 		for(int i=0; i<N; i++) {
 			st = new StringTokenizer(br.readLine());
 			arr[i][0] = Integer.parseInt(st.nextToken());
 			arr[i][1] = Integer.parseInt(st.nextToken());
 		}
 		
 		Arrays.sort(arr, new Comparator<int[]>() {
 			@Override
 			public int compare(int[] o1, int[] o2) {
 				// x봐표가 같으면 y좌표로 비교
 				if(o1[0]==o2[0])
 					return Integer.compare(o1[1], o2[1]);
 				
 				//아니면 x좌표로 비교한 결과를 출력
 				return Integer.compare(o1[0], o2[0]);
 			}
		});
 		
 		for(int i=0; i<N; i++) {
 			System.out.println(arr[i][0] +" "+arr[i][1]);
 		}
 		
	}
}
