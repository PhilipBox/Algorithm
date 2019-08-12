package swea;

import java.util.Scanner;

public class d4_1233_사칙연산유효성검사 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++){
			int N = sc.nextInt();
			sc.nextLine();
			String[] tree = new String[N+1];
			
			for(int i=0; i<N; i++) {
				String str = sc.nextLine();
				String[] arr = str.split(" ");
				tree[Integer.parseInt(arr[0])] = arr[1];
			}
			
			
			System.out.print("#"+tc+" ");
			if(preorder(tree, 1, N)) 
				System.out.println("-1");
			else
				System.out.println("-0");
		}
	}//end main
	
	static boolean preorder(String[] tree, int idx, int N) {
		
		//끝까지 다 가서 만족해야 true.
		if(idx==N)
			return true;
		
		//왔는데, 자식노드가 없을수도 있잖아.
		//이건 숫자일때만 검사하자.
		// tree[idx]
		
		//tree요소가 숫자인지 보는 것.
		if(Character.isDigit(tree[idx].charAt(0))) {
			//현재 idx에서 자식노드가 있다면? - 하나라도 있으면 안됨.
			if(idx*2 >= N) {
				System.out.println(idx+"a");
				return false;
			}
		}
		// 숫자가 아니면, 수식이겠지. ==============================================당연히 수식 아래에는 수식이 올수있는데 이건 그거를 무시했음 수정해라
		else {
			//일단 있어야해.
			if(idx*2+1<=N) {
				// 일단 자식노드가 있고. 그 자식노드들이 숫자인지.
				System.out.println(tree[idx*2].charAt(0));
				System.out.println(tree[idx*2+1].charAt(0));
				if( Character.isDigit(tree[idx*2].charAt(0))==false || Character.isDigit(tree[idx*2+1].charAt(0))==false) {
					System.out.println(idx+"b?");
					return false; //둘중하나가 숫자가 아니면 false
				}
			}
			else {
				System.out.println(idx+"c");
				return false;
			}
		}
		
		System.out.println(idx+"d");
		return false;
	}
	
	
}
