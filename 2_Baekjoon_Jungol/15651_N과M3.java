package _solving;

import java.util.Scanner;

public class bj_15651_N과M3 {
	static int[] arr;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = i+1;
		
		re_perm(0, "");
	}
	
	static void re_perm(int k, String a) {
		if(k == M) {
            System.out.println(a);
            return;
        }

        for(int i=1; i<=N; i++) {
        	re_perm(k+1, a+i + " ");
        }
	}//end re_perm
}
