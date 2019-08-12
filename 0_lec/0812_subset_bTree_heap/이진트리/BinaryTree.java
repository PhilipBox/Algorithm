package 이진트리;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key> {
	Node<Key> root;
	
	public BinaryTree(Key data) {
		root = new Node<>();
		root.item = data;
	}
	
	public Node getRoot() {
		return root;
	}
	
	
	public void setLeft(Node node, Node left) {
		node.left = left;
	}
	
	public void setRight(Node node, Node right) {
		node.right = right;
	}
	
	public Node getLeft(Node node) {
		return node.left;
	}
	
	public Node getRight(Node node) {
		return node.right;
	}
	
	public void preorder(Node node) {
		//기저
		if(node == null)
			return;
		System.out.print(node.item+ " ");
		
		preorder(node.left);
		preorder(node.right);
	}
	
	public void levelorder() {
		//루트노드를 큐에 삽입.
		
		//큐에서 한놈을 인출
		//그놈의 좌 우에 연결이 있다면 연결된 노드를 큐에 삽입.
		//그놈을 방문.
		//반복..
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(getRoot());
		
		while(!queue.isEmpty()) {
		Node node = queue.poll();
		if(node.left != null)
			queue.add(node.left);
		if(node.right != null)
			queue.add(node.right);
		System.out.print(node.item +" ");
		}
	}//end levelorder
	
	
}
