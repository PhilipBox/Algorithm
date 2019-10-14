import java.util.Scanner;

public class bj_1717_집합의표현 {
	static int N;
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parents[i] = i;

		int M = sc.nextInt();
		for(int i=0; i<M; i++) {
			int flag = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(flag==1) {
				if(isSameParents(x, y))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
			else union(x,y);
		}//end for loop M cnt
	}
	
	static boolean isSameParents(int x ,int y) {
		x = find(x);
		y = find(y);
		if(x==y)
			return true;
		else
			return false;
	}
	
	static int find(int x) {
		if(parents[x]==x) {
			return x;
		}
		else {
			return parents[x] = find(parents[x]);
		}
	}//end find method

	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parents[y] = x;
		}
		else {
			parents[x] = y;
		}
	}//end union method
	
}
