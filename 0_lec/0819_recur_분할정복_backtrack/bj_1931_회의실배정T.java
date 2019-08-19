import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_1931_회의실배정T {

	static class Meeting implements Comparable<Meeting>{
		int startTime;
		int endTime;
		public Meeting(int st, int et) {
			this.startTime=st;
			this.endTime=et;
		}
		
		@Override
		public int compareTo(Meeting o) {
			
			//음수가 나오면 내가 먼저, 내가 더 작으면 먼저 나가겠다는 것.
			// 이 문제에서는 끝나는 시간이 같으면 시작시간이 빠른놈이 먼저 나가야해 .
			if(endTime == o.endTime) {
				return startTime - o.startTime;
			}
			return startTime - o.startTime;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // <= 100_000
		ArrayList<Meeting> list = new ArrayList<>(N);
		for(int i=0; i<N; i++) {
			list.add(new Meeting(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list);
		//배정된 회의의 갯수
		int cnt =0;
		int lastFinishedTime = 0;
		for(Meeting meeting : list) {
			//해당 회의의  시작시간이 ,마지막에 끝난 회의보다 더 늦으면 추가 가능한 화의
			if(meeting.startTime >= lastFinishedTime) {
				//회의 하나 세고 
				cnt++;
				lastFinishedTime = meeting.endTime;
			}
		}
		System.out.println(cnt);
	}
	
	
}
