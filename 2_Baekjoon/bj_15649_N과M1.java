package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj_15649_N과M1 {
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		visited = new boolean[N];
		perm(new int[M], 0);
	}

	static void perm(int[] sel, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;

			sel[k] = arr[i];
			visited[i] = true;
			perm(sel, k + 1);
			visited[i] = false;

		}
	}
}
