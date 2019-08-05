package day00_study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1966_프린터큐 {

	static class Person{
		int priority;
		int k;
		int total=0;
		Person(int p){
			this.priority = p;
			this.k = -1;
		}
		Person(int p, int k){
			this.priority = p;
			this.k = k;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Person> queue; 
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			//문서의 수 N
			int N = sc.nextInt();
			//궁금한 문서 K (0~N-1)
			int K = sc.nextInt();
			
			int max = -1;
			queue = new LinkedList<Person>();
			for(int i=0; i<N; i++) {
				int pr = sc.nextInt();

				if(i==K) {
					queue.add(new Person(pr, i));
				}
				else
					queue.add(new Person(pr));
			}
			
			int cnt=0;
			while(!queue.isEmpty()) {
				max = find_max(queue);
				//가장 앞에있는거를 뽑아서 확인
				Person p = queue.poll();
				
				//최대값이 아니라면 맨뒤로 넣기
				if(p.priority < max) {
					queue.add(p);
				} 
				//최대값이라면
				else if(p.priority == max){
					//뽑은횟수 더하고 다시 넣어주지 않아.
					cnt++;
					//근데 내가 처음에 궁금해했던 거라면
					if(p.k == K) {
						break;
					}
				}
			}
			System.out.println(cnt);
		}//end test case
	}//end main
	
	public static int find_max(Queue<Person> q) {
		int max = -1;
		for(int i=0; i<q.size(); i++) {
			Person p = q.poll();
			if(max<p.priority) {
				max = p.priority;
			}
			q.add(p);
		}
		return max;
	}
}
