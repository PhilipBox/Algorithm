import java.util.Arrays;

// Logic

// �迭�� ���ؼ� �ڽ��� �θ� ���������ν� Ʈ���� ǥ��.
// makeSet�� �ڽ��� �θ� �ڽ����� �����ִ� ��.
// findSet�� �ڽ��� �θ� �ڽ��̸� �ڽ��� ��ǥ��. �ƴϸ� �θ� ���ؼ� ���ȣ�� (���ȣ���� ���ϰ���� �ڽ��� �θ�� ����).
// unionSet(a,b)�� b�� ��ǥ���� �θ� a�� ��ǥ�ڷ� ����.

public class ��ȣ��Ÿ���� {
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
