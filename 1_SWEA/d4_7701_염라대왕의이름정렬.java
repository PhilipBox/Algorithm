import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class d4_7701_염라대왕의이름정렬 {

	static class NAME implements Comparable<NAME> {
		String name;
		int len;

		public NAME(String str, int len) {
			this.name = str;
			this.len = len;
		}

		@Override
		public int compareTo(NAME o) {
			if (this.len == o.len) {
				return this.name.compareTo(o.name);
			}
			return this.len - o.len;
		}
	}
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ArrayList<NAME> list = new ArrayList<NAME>();
			// 이름 받기
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				// 중복확인
				if (list.contains(new NAME(str, str.length())))
					continue;
				else
					list.add(new NAME(str, str.length()));
			}
			Collections.sort(list);
			String str = "";
			System.out.println("#"+tc);
			for (NAME n : list) {
				if (str.equals(n.name)) {
					continue;
				} else {
					str = n.name;
					System.out.println(n.name);
				}
			}

		} // end test cases;
	}// end main

}
