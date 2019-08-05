package day00_study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class d3_1225_암호생성기_Queue {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue; 
		
		for(int tc=1; tc<=10; tc++) {
			int T = sc.nextInt();
			 queue = new LinkedList<Integer>();
			for(int i=0; i<8; i++) {
				queue.add(sc.nextInt());
			}
			
			int flag=1;
			while(true) {
				for(int i=1; i<=5; i++) {
					int pop = queue.poll()-i;
					if(pop<=0) {
						queue.add(0);
						flag=0;
						break;
					}
					else {
						queue.add(pop);
					}
					
				}
				if(flag==0)
					break;
			}//end while
			System.out.print("#"+tc + " ");
			for(int i=0; i<8; i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
			
		}
	}
}
