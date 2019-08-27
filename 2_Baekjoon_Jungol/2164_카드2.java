package day00_study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2164_카드2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int card = sc.nextInt();
		if(card==1) {
			System.out.println("1");
			return;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=card; i++) {
			queue.add(i);
		}

		
		int flag = 0;
		//최대횟수 수정
		while(!queue.isEmpty()) {
		//뽑아서 버리기
			if(flag==0) {
				queue.poll();
				flag=1;
			}
			//뽑아서 아래로
			else {
				int tmp = queue.poll();
				queue.add(tmp);
				flag=0;
			}
			if(queue.size()==1) {
				System.out.println(queue.poll());
				break;
			}
		}//end while
	}
}
