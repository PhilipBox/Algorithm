package day07_0805;

import java.util.LinkedList;
import java.util.Queue;



class candy {
	
	static class person{
		int no = 1;
		int cnt = 1;
		person(int no, int cnt){
			this.no = no;
			this.cnt = cnt;
		}
	}
	
	
	
	public static int candy = 20;
	public static Queue<person> Queue = new LinkedList<>();
	
	public static void main(String[] args) {
		
		int num=1;
		
		person p = null;
		while(candy>0) {

			Queue.add(new person(num, 1));
			p = Queue.poll();
			candy -= p.cnt;
			if(candy<0) {
				System.out.println(p.no);
				break;
			}
			Queue.add(new person(p.no ,++p.cnt));

			num++;
		}
		
		// (1,1)줄서
		// (1,1)먹어, 
		
		// (1,2) (2,1) 줄서
		// (1,2)먹어	
		
		
		// (2,1) (1,3) (3,1) 줄서
		// (2,1) 먹어
		
		// (1,3) (3,1) (2,2) (4,1) 줄서
		// (1,3) 먹어
		
		// (3,1) (2,2) (4,1) (1,4) (5,1) 줄서
		
	}
}
