// 백준 1966
// https://www.acmicpc.net/problem/1966
package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ejik_1w_프린터큐 {

	static class Person {
		int priority;
		int k;

		Person(int p) {
			this.priority = p;
			this.k = -1;
		}

		Person(int p, int k) {
			this.priority = p;
			this.k = k;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Person> queue = new LinkedList<Person>();

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt(); // 문서의 수
			int K = sc.nextInt(); // 궁금한 문서(idx); 

			queue.clear(); // 매 tc마다 queue 초기화
			for (int i = 0; i < N; i++) {
				int doc = sc.nextInt();

				if (i == K) {
					queue.add(new Person(doc, i));
				} else {
					queue.add(new Person(doc));
				}
			}

			int max = -1;
			int cnt = 0;
			while (!queue.isEmpty()) {
				max = find_max(queue);	//현재 queue에서 최대값 확인
				System.out.println("중요도 : " + max);
				Person p = queue.poll();	// 한개 뽑음
				
				// 뽑은 문서가 최대값이 아니라면 맨 뒤로 다시 넣음
				if(max > p.priority) {
					queue.add(p);
				}
				else if(max == p.priority){	// 최대값이라면 , 뽑은횟수 증가 후 궁금했던 문서라면 END 아니라면 다시 넣지않고 진행.
					cnt++;		
					if(p.k==K)	// 궁금했던 문서라면 END
						break;
				}
			}
			System.out.println(cnt);
		}
	}

	// queue 중요도 max값 최신화 후, 원상복귀
	public static int find_max(Queue<Person> q) {
		int max = -1;
		for (int i = 0; i < q.size(); i++) {
			Person p = q.poll();
			if(max<p.priority) {
				max = p.priority;
			}
			q.add(p);
		}
		return max;
	}
}
