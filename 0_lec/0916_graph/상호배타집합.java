import java.util.Arrays;

// Logic

// 배열을 통해서 자신의 부모를 저장함으로써 트리를 표현.
// makeSet은 자신의 부모를 자신으로 정해주는 것.
// findSet은 자신의 부모가 자신이면 자신이 대표자. 아니면 부모에 대해서 재귀호출 (재귀호출의 리턴결과를 자신의 부모로 지정).
// unionSet(a,b)는 b의 대표자의 부모를 a의 대표자로 지정.

public class 상호배타집합 {
	static int[] parent;
	static int[] rank;

	public static void main(String[] args) {
		parent = new int[6];

		for (int i = 0; i < 6; i++) {
			makeSet(i);
		}

		System.out.println(Arrays.toString(parent));
		unionSet(2, 3);
		unionSet(4, 5);
		System.out.println(Arrays.toString(parent));
		unionSet(3, 5);
		System.out.println(Arrays.toString(parent));

	}

	static void makeSet(int x) {
		parent[x] = x;
	}

	static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}

	static void unionSet(int x, int y) {

		int px = findSet(x);
		int py = findSet(y);

		if (px != py) {
			parent[py] = parent[px];
		}
	}

}
