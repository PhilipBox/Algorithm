package programmers;

import java.util.Arrays;

public class H_Index {
	public static void main(String[] args) {
		int[] arr = { 3, 0, 6, 1, 5 };
		int ans = solution(arr);
		System.out.println(ans);
	}

	public static int solution(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int doc = arr[i];
			if (doc >= arr.length - i)
				return arr.length-i;
		}

		return 0;
	}
}
