package day08_0806;


class MySinglyLinkedList{
	Node head;
	int size;

	int size() {
		return size;
	}
	Node get(int idx) {
		//idx번째의 엘리먼트의 data를 리턴
		if(idx >= size || idx < 0) {
			return null;
		}
		else {
			Node tmp = head;
			for(int i=0; i< idx; i++) {
				tmp = tmp.link;
			}
			return tmp;
		}
	}//end get
	
	//특정 위치에 끼어넣거나
	void add(int data, int idx) {
		if(idx>=size|| idx<0) {
			System.err.println("Out of index");
			return;
		}
		
		Node node = new Node();
		node.data = data;
		if( idx ==0) {
			node.link = head;
			head = node;
		}
		else if(idx== size-1) {
			addToLast(data);
		}
		else {
			Node pre = get(idx-1);
			Node target = pre.link;
			
			node.link = target;
			pre.link = node;
			size++;
		}
	}
	
	//특정 위치의 원소를 삭제
	void delete(int idx) {
		// idx가 0 이라면 head의 link로 지정
		if(size<1)
			return;
		if(idx==0)
			head = head.link;
		else {
			//idx번째 원소를 찾아온다.
			Node target = get(idx);
			//idx번째 원소의 link를 idx-1번째 원소의 link로 지정한다.
			Node pre= get(idx-1);
			pre.link = target.link;
		}
	}
	
	
	
	
	void addToFirst(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		size++;
		
		//head가 null이면, 리스트가 빈 상태임
		//새로운 노드 객체를 생성해서 head에 연결시키면 됨
		if(head == null) {
			head = newNode;
		}
		//head가 null이 아니면 리스트가 존재함.
		//새로운 노드 객체를 생성해서 head에 연결시키고, 기존 head에 연결되어있는 노드를 새로운 노드객체의 link로 저장
		else {
			newNode.link = head;
			head = newNode;
		}
	}//end addToFirst method
	
	
	void addToLast(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		size++;
		
		//head가없을때.
		if(head == null) {
			head = newNode;
			return;
		}
		else {
			Node tmp = head;
			while(tmp.link != null) {
				tmp = tmp.link;
			}
			tmp.link = newNode;
			
		}//end else
	}//end addToLast
	
	
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node tmp = head;
		while(tmp != null) {
			sb.append(tmp.data).append(" ");
			tmp= tmp.link;
		}
		return sb.toString();
	}//end toString
	
	
	
	static class Node{
		int data;
		Node link;
	}
}

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		
		MySinglyLinkedList n = new MySinglyLinkedList();
		n.addToFirst(5);
		n.addToFirst(50);
		n.addToLast(40);
		n.addToFirst(1);
		
		System.out.println(n.toString());
		n.add(99, 2);
		System.out.println(n.toString());
		n.delete(3);
		System.out.println(n.toString());
		n.add(323 , 4);
		System.out.println(n.toString());

//		MySinglyLinkedList.Node n1 = new MySinglyLinkedList.Node();
//		n1.data = 10;
//		
//		MySinglyLinkedList.Node n2 = new MySinglyLinkedList.Node();
//		n2.data = 20;
//		n1.link = n2;
//		
//		MySinglyLinkedList.Node n3 = new MySinglyLinkedList.Node();
//		n3.data = 30;
//		n2.link = n3;
//		
//		MySinglyLinkedList.Node n4 = new MySinglyLinkedList.Node();
//		n4.data = 40;
//		n3.link = n4;
//		
//		
//		n2 = n3 = n4 = null;
//
//		// 맨 마지막 node의 data를 출력해보세요(총 node의 개수를 모를 때)
//		
//		// n1의 다음녀석.. 
//		// 의 다음녀석..
//		// 의 다음녀석...
//		// 의 다음녀석....이 없다면 그녀석의 data.
//		
//		//임시로 참조변수를 하나 만들어.
//		MySinglyLinkedList.Node tmp = n1;
//		while(tmp.link != null) {
//			tmp = tmp.link;
//		}
//		System.out.println(tmp.data);
		
		
		
		
		
		
		
		
	}//end main
}
