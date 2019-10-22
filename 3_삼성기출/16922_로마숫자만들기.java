package _solving;

import java.util.ArrayList;
import java.util.Scanner;

public class bj_16922_로마숫자만들기 {

	static int[] arr = { 1, 5, 10, 50 };
	static int N;
	static int[] sel;

	static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sel = new int[N];
		list = new ArrayList<Integer>();
		
		re_comb(0, 0);
		System.out.println(list.size());
	}

	static void re_comb(int idx, int k) {
		if (k >= N) {
			int sum=0;
			for(int i=0;i<N; i++)
				sum += sel[i];
			if(!list.contains(sum))
				list.add(sum);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			re_comb(i, k + 1);
		}
	}

}
