package _solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 순열 - 중복값(결과)제거 
public class bj_15663_N과M9 {
	static int N;
	static int M;
	static int[] arr;
	static ArrayList<String> list;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		list = new ArrayList<String>();

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);

		perm_no_dupValue("", 0);

		for (String s : list)
			System.out.println(s);
	}//end main

	static void perm_no_dupValue(String s, int k) {
		if (k == M) {
			if (list.contains(s))
				return;
			else {
				list.add(s);
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			perm_no_dupValue(s + arr[i] + " ", k + 1);
			visited[i] = false;
		}
	}// end perm_no_dupValue method
}
