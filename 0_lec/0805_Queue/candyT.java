package day07_0805;

import java.util.LinkedList;
import java.util.Queue;

public class candyT {

	static class Person{
		int num;
		int cnt;
		int sum;
		Person(int n, int c){
			num = n;
			cnt = c;
		}
	}
	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>();
		int pNum =1; //입장하는 사람의 번호
		int candyCnt = 20;
		queue.add(new Person(pNum, 1));
		Person p = null;
		while( candyCnt>0) {
			p = queue.poll();
			//큐에서 맨앞사람 빼서.
			
			int qnt = p.cnt > candyCnt ? candyCnt : p.cnt;
			p.sum += qnt;
			
			candyCnt -= p.cnt;
			//그놈이 먹어야되는 캔디 갯수만큼 candyCnt에서 까고
			p.cnt++;
			queue.add(p);
			//다시 맨뒤에 갯수하나 늘려서 줄을세우고
			//새로운 사람 줄에 추가
			queue.add(new Person(++pNum, 1));
		}
		System.out.println(p.num);
		// 심화 : 각 사람이 몇개씩 드셨는지 마지막에 출력
		
		for(Person pp : queue) {
			System.out.println(pp.num + "  " + pp.sum);
		}
		
	}
}

