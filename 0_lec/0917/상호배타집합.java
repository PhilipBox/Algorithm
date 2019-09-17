import java.util.Arrays;

//배열을 통해서 자신의 부모를 저장함으로써 트리를 표현.

//makeSet은 자신의 부모를 자신으로 정해주는 것
//findSet은 자신의 부모가 자신이면 자신이 대표자. 아니면. 부모에 대해서 재귀호출 (재귀호출의 리턴결과를 자신의 부모로 지정).
//unionSet(a,b) 은 b의 대표자의 부모를 a의 대표자로 지정.


public class 상호배타집합 {
	static int[] parents;
	public static void main(String[] args) {
		parents = new int[6];
		for(int i = 0; i < 6; i++)
			makeSet(i);
		System.out.println(Arrays.toString(parents));
		union(2, 3);
		union(4, 5);
		System.out.println(Arrays.toString(parents));
		union(3,5);
		System.out.println(Arrays.toString(parents));
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	static int findSet(int x) {
		if( parents[x] == x )
			return x;
		parents[x] = findSet(parents[x]);
		return parents[x];
	}
	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if( px != py ) {
			parents[py] = parents[px];
		}
	}
}








