// ���� 1966
// https://www.acmicpc.net/problem/1966
package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ejik_1w_������ť {

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
			int N = sc.nextInt(); // ������ ��
			int K = sc.nextInt(); // �ñ��� ����(idx); 

			queue.clear(); // �� tc���� queue �ʱ�ȭ
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
				max = find_max(queue);	//���� queue���� �ִ밪 Ȯ��
				System.out.println("�߿䵵 : " + max);
				Person p = queue.poll();	// �Ѱ� ����
				
				// ���� ������ �ִ밪�� �ƴ϶�� �� �ڷ� �ٽ� ����
				if(max > p.priority) {
					queue.add(p);
				}
				else if(max == p.priority){	// �ִ밪�̶�� , ����Ƚ�� ���� �� �ñ��ߴ� ������� END �ƴ϶�� �ٽ� �����ʰ� ����.
					cnt++;		
					if(p.k==K)	// �ñ��ߴ� ������� END
						break;
				}
			}
			System.out.println(cnt);
		}
	}

	// queue �߿䵵 max�� �ֽ�ȭ ��, ���󺹱�
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
