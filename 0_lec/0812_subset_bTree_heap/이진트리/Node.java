package 이진트리;

public class Node<Key> {
	Key item;
	
	public Node(Key item) {
		this.item = item;
	}
	
	public Node() {
	}
	
	Node<Key> left;
	Node<Key> right;
	
}
