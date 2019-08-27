package _solving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1697_숨바꼭질 {
	static class Pair{
		int pos;
		int time;
		
		public Pair(int p, int t) {
			this.pos = p;
			this.time = t;
		}
	}
	
	static boolean[] visited;
	static int N;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		visited = new boolean[100001];
		
		//수빈이 위치 
		N = sc.nextInt();
		// 잡아야할 놈 위치 
		K = sc.nextInt();
		
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(N,0));
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			//확인해봐야할 숫자들의 수 
			for(int i=0; i<size; i++) {
				Pair p = queue.poll();
				
				// 값이 같으면 끄읏-
				if(p.pos==K) {
					System.out.println(p.time);
					break;
				}
			
				// 방문확인 
				if(p.pos-1>=0 && !visited[p.pos-1] ) {
					visited[p.pos-1] = true;
					queue.add(new Pair(p.pos-1, p.time+1));
				}
				
				if(p.pos+1<= 100000 && !visited[p.pos+1]) {
					visited[p.pos+1]=true;
					queue.add(new Pair(p.pos+1, p.time+1));
				}
				
				if(p.pos*2<= 100000 && !visited[p.pos*2]) {
					visited[p.pos*2]=true;
					queue.add(new Pair(p.pos*2, p.time+1));
				}
			}//end for loop
		}//end while 
	}//end main
}
