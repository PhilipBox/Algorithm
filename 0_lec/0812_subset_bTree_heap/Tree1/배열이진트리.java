package Tree1;


class Arr_BinaryTree{
	char[] tree;
	int root = 1;
	public Arr_BinaryTree(int max_level) {
		//max에 level에 맞게 할당

		// bitmask하는방법도 익혀보장
		tree = new char[1<<max_level];
	}
	
	public void setRoot(char data) {
		//루트 노드의 값을 data로 설정
		tree[1] = data;
	}
	
	public void setLeft(char data, int parent) {
		//parent인덱스에 위치한 노드의 왼쪽 자식 노드가 위치해야 되는 인덱스에 data 입력
		tree[parent*2]=data;
	}
	
	public void setRight(char data, int parent) {
		//parent인덱스에 위치한 노드의 오른쪽 자식 노드가 위치해야 되는 인덱스에 data 입력
		tree[parent*2+1]=data;
	}
	
	public char getLeft(int node) {
		//node인덱스에 위치한 노드의 왼쪽 노드의 값을 리턴
		return tree[node*2];
	}
	
	public char getRight(int node) {
		//node인덱스에 위치한 노드의 오른쪽 노드의 값을 리턴
		return tree[node*2+1];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<tree.length; i++) {
			sb.append(tree[i]).append(" ");
		}
		return sb.toString();
	}
	
	public void preorder(int node) {
		//기저부분
		if(node>= tree.length)
			return;
		if(tree[node] == '\0')
			return;
		//전위순회...
		//현재위치 출력 후
		System.out.print(tree[node] +" ");
		
		//왼쪽 방문
		preorder(node*2);
		//오른쪽 방문
		preorder(node*2+1);
	}//end preorder
	
	public void inorder(int node) {
		//기저부분
		if(node>= tree.length)
			return;
		if(tree[node] == '\0')
			return;
		//중위순회...

		//왼쪽 방문
		inorder(node*2);
		
		//현재위치 출력 
		System.out.print(tree[node] +" ");
		
		//오른쪽 방문
		inorder(node*2+1);
	}
	
	
	public void postorder(int node) {
		//기저부분
		if(node >= tree.length)
			return;
		if(tree[node] == '\0')
			return;
		//후위순회...

		//왼쪽 방문
		postorder(node*2);
		
		//오른쪽 방문
		postorder(node*2+1);
		
		//현재위치 출력 
		System.out.print(tree[node] +" ");
	}
	
	public void printParent(int node) {
		//Logic
		//나를 방문.
		//내 부모를 재귀호출.
		//루트에 도달하면 종료.
		//빈공간을 확인할필요는 없어. 부모가 있으니까 자식이 있는거니까.
		
		//나를 방문
		System.out.print(tree[node]+" ");
		//기저 - root에 도달하면 종료
		if(node==1) {
			return;
		}
		//내 부모를 재귀호출
		printParent(node/2);
	}//end printParent
	
}

public class 배열이진트리 {
	public static void main(String[] args) {
		
		Arr_BinaryTree tree = new Arr_BinaryTree(3);
		tree.setRoot('A');
		tree.setLeft('B', 1);
		tree.setRight('C', 1);
		
		tree.setLeft('D', 2);
		tree.setRight('E', 2);
		
		tree.setLeft('F', 3);
		tree.setRight('G', 3);
		
		System.out.println(tree);
		
		System.out.println("\n0. 부모찾기");
		tree.printParent(3);
		
		// 부모 왼 오 
		System.out.println("\n\n1. 전위순회 ()");
		tree.preorder(1);
		
		//왼 부모 오
		System.out.println("\n\n2. 중위순회 ()");
		tree.inorder(1);
		
		// 왼 오 부모
		System.out.println("\n\n3. 후위순회 ()");
		tree.postorder(1);
		
		
	}
}

