package day07_0805;

import java.util.Scanner;

public class 선형큐 {
	

	public static int front=-1;
	public static int rear=-1;
	public static int[] Q = new int[100];
	
	public static void main(String[] args) {
		//1차원 배열 하나와 front, rear 커서로 사용할 변수를 준비
		//enQueue는 rear+1 시키고, rear위치에 원소삽입. rear는 지금까지 중 마지막에 들어온 원소의 위치
		//deQueue는 front+1시키고, 위치의 원소 인출	front는 지금까지 중 마지막에 인출했던 위치.
	
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. enQueue\n2. deQueue");
			int sel = sc.nextInt();
			
			if(sel==1) {
				int input = sc.nextInt();
				enQueue(input);
			}else if(sel==2){
				System.out.println(deQueue());
			}else if(sel==3) {
				print();
			}else {
				break;
			}
			
		}//end while
	}
	
	
	public static void enQueue(int key) {
		rear++;
		Q[rear] = key;
	}
	
	public static int deQueue() {
		front++;
		return Q[front];
	}
	
	public static void print() {
		System.out.println("Queue : ");
		for(int i=front+1; i<=rear; i++) {
			System.out.print(Q[i]+" ");
		}
		System.out.println();
		System.out.println();
	}
	
}
