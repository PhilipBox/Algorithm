import java.util.Scanner;

public class d5_숫자게임 {

	static boolean[] sel;
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			String[] arr = new String[str.length()];
			int N = str.length();
			sel = new boolean[N];

			// 입력받은 수를 각각 쪼개버렷
			for (int i = 0; i < str.length(); i++) {
				arr[i] = Character.toString(str.charAt(i));
			}

			// 모든 경우의 수
			powerset(new boolean[N], 0, arr, 0);
			if (max <= 0) {
				if (Integer.parseInt(str) <= 9)
					System.out.println("#" + tc + " " + 0);
				else
					System.out.println("#" + tc + " " + 1);
			} else
				System.out.println("#" + tc + " " + (max + 1));
		}
	}

	static void powerset(boolean[] sel, int idx, String[] sarr, int cnt) {
		max = Math.max(max, cnt);
		for (int i = 0; i < sarr.length - 1; i++) {
			sel[idx++] = true;
			System.out.println(sel);
			// 여기서 구현
			String left = "";
			String right = "";
			for (int j = 0; j < sel.length; j++) {
				if (sel[j]) {
					left += sarr[j];
				} else {
					right += sarr[j];
				}
			}
			// 2부류로 쪼갰어.
			int leftNum = Integer.parseInt(left);
			int rightNum = Integer.parseInt(right);
			if (leftNum * rightNum >= 10) {
				String[] tmparr = intToSarr(leftNum * rightNum);
				powerset(new boolean[tmparr.length], 0, tmparr, cnt + 1);
			}
		}
	}// end powerset

	static String[] intToSarr(int n) {
		String s = Integer.toString(n);
		String[] arr = new String[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = Character.toString(s.charAt(i));
		}
		return arr;
	}// end intToSarr method

}
