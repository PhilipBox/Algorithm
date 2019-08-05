package day07_0805;

import java.util.Scanner;

public class 선형큐T {
	public static void main(String[] args) {
		//1차원 배열 하나와 front, rear 커서로 사용할 변수를 준비
		//enQueue는 rear+1 시키고, rear위치에 원소삽입. rear는 지금까지 중 마지막에 들어온 원소의 위치
		//deQueue는 front+1시키고, 위치의 원소 인출	front는 지금까지 중 마지막에 인출했던 위치.
	
		int[] Queue = new int[100];
		int front = -1;
		int rear = -1;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. enQueue\n2. deQueue\n3.print");
			int sel = sc.nextInt();
			
			if(sel==1) {
				int data = sc.nextInt();
				Queue[++rear] = data;
			}else if(sel==2){
				if(front == rear)
					System.err.println("Empty Queue");
				else
					System.out.println("delete : " + Queue[++front]);
			}else if(sel==3) {
				System.out.print("Queue : ");
				for(int i=front+1; i<=rear; i++) {
					System.out.print(Queue[i]+ " ");
				}
				System.out.println();
			}else {
				break;
			}
			
		}//end while
	}
}
