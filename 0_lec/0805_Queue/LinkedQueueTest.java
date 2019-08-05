package day07_0805;


class LinkedQueue {
	static class Node{
		int data;
		Node link;
	}
	//연결큐는 다음번에 꺼낼 자료의 위치인 front와 마지막에 넣은 자료의 위치인 rear가 있음.
	//각각의 자료의 타입은 Node이니까.
	Node front;
	Node rear;
	
	void enQueue(int data) {
		//enQueue는 새로운 데이터가 추가되는거니까 하나의 자료를 생성, 그 안에 넣고자하는 데이터를 담아.

		
		//data를 저장하는 Node객체 하나를 생성.
		Node newData = new Node();
		newData.data = data;
		
		if(isEmpty()) {
			//Queue가 공백일때. - 다음번에 꺼내야되는 놈이 지금 넣는놈이고, 지금 넣은 놈이 마지막에 넣은 놈.
		front = newData;
		rear = newData;
		}
		else {
			//Queue가 공백이 아닐때.
			// 현재 rear가 바라보고있는 친구!의 다음 위치에 새로만든걸 연결시켜주고, rear도 그놈을 바라봄.
			rear.link = newData;
			rear = newData;
		}
		
	}
	
	int deQueue() {
		//큐가 비었으면 -1을 리턴하는걸로 약속하장
		if(isEmpty()) {
			return -1;
		}
		else {
		//큐가 안비었으면 
		//현재 front가 기리키고 있는 자료의 data값을 리턴해야하니까 확보해야함.
			int data = front.data;
		//현재 front가 가리키고 있는 자료의 link위치의 자료를 front가 바라보도록 조정
			front = front.link;
		//지금 꺼낸게 마지막이었다면, 새로운 front는 NULL이 되겠지
		//공백상태는 front와 rear가  둘다 NULL인걸로 약속했으니, 공백이 될 때 rear도 NULL설정
			if(front == null)
				rear = null;
			
			
			//확보한 자료를 리턴
			return data;
			
			
		}
		
	}
	
	boolean isEmpty() {
		if(front==null && rear==null)
			return true;
		else
			return false;
	}
	
	
}

public class LinkedQueueTest {
	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		queue.enQueue(10);
	}
}
