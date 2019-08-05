package day07_0805;

import java.util.Scanner;

public class 원형큐_T {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] Queue = new int[10];
		int front = 0;
		int rear = 0;
		
		while(true) {
			int sel = sc.nextInt();
			System.out.println("1. enQueue\n2. deQueue\n3.Empty\n4.Full");
			switch(sel) {
			case 1:
				if(front == (rear+1)% Queue.length)
					System.out.println("Queue is full");
				else {
					rear = (rear+1) % Queue.length;
					Queue[rear] = sc.nextInt();
				}
				break;
			case 2:
				if(front == rear) 				
					System.out.println("Queue is empty");
				else {
					front = (front+1) % Queue.length;
					System.out.println("Delete : " + Queue[front]);
				}
				break;
			case 3:
				if(front == rear)
					System.out.println("Queue is empty");
				else
					System.out.println("Queue is NOT empty");
				break;
			case 4:
				if(front == rear+1) 
					System.out.println("Queue is full");
				else 
					System.out.println("Queue is NOT full");
				break;
			}//end switch
		}
		
		
	}
}
