import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//greedy algorithm
public class bj_1931_회의실배정 {
	static long cnt=0;
	static class pair{
		long start;
		long end;
		public pair(long start, long end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static class MyComparator implements Comparator<pair>{
		@Override
		public int compare(pair o1, pair o2) {
			
			if(o1.end==o2.end) {
				return (int) (o1.start - o2.start);
			}
			return (int) (o1.end - o2.end);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cnt=0;
		int T = sc.nextInt();
		ArrayList<pair> meeting = new ArrayList<pair>();
		for(int i=0; i<T; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			meeting.add(new pair(start,end));
		}
		MyComparator myComparator = new MyComparator();
		Collections.sort(meeting, myComparator);
		
//		for(pair p : meeting)
//			System.out.println(p.start +","+ p.end);
		
		long selected = 0;
		for(int i=0; i<meeting.size(); i++) {
			if(meeting.get(i).start < selected)
				continue;
			else {
				selected = meeting.get(i).end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

