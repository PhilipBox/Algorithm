package etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class jungol_1828_냉장고 {		
	
	static class Pair implements Comparable<Pair>{
		int start;
		int end;
		public Pair(int s, int e) {
			this.start = s;
			this.end = e;
		}
		
		@Override
		public int compareTo(Pair o1) {
			return this.end - o1.end;
		}
	}
	
	static int cnt=0;
	public static void main(String[] args) {

		ArrayList<Pair> list = new ArrayList<Pair>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int src = sc.nextInt();
			int dst = sc.nextInt();
			list.add(new Pair(src, dst));
			
		}//end N loop
		Collections.sort(list);
		
		int limit = -271;
		for(Pair p : list) {
			//내가 가지고있는 냉장고의 최대치랑 비교
			if(p.start<=limit)
				continue;
			else {
				cnt++;
				limit=p.end;
			}
		}
		System.out.println(cnt);
	}
}
