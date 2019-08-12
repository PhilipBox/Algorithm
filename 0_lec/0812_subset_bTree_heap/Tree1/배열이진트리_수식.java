package Tree1;

public class 배열이진트리_수식 {
	public static void main(String[] args) {
		
		Arr_BinaryTree tree = new Arr_BinaryTree(4);
		tree.setRoot('+');
		tree.setLeft('*', 1);
		tree.setRight('/', 1);
		
		tree.setLeft('-', 2);
		tree.setRight('1', 2);
		
		tree.setLeft('2', 3);
		tree.setRight('3', 3);
		
		System.out.println(tree);
		
		System.out.println("\n0. 부모찾기");
		tree.printParent(3);
		
		System.out.println("\n\n1. 전위순회 (preorder)");
		tree.preorder(1);
		
		System.out.println("\n\n2. 중위순회 (Inorder");
		tree.inorder(1);
		
		System.out.println("\n\n3. 후위순회 (Postorder");
		tree.postorder(1);
		
	}
}

