package _solving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class d4_4408_자기방으로돌아가기 {
	
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			max = 0;
			int N = sc.nextInt();
			
			int[] src = new int[401];
			int[] dst = new int[401];
			int[] room = new int[401];
			
			for(int i=0; i<N; i++) {
				src[i] = sc.nextInt();
				dst[i] = sc.nextInt();
				if(max<dst[i] || max<src[i]) {
					if(dst[i]>src[i])
						max=dst[i];
					else
						max=src[i];
				}
			}
		}
	}
}
