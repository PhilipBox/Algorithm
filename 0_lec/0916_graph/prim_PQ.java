import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class prim_PQ {
	static String src = "7 11\n"
			+"0 1 31\n"
			+"0 2 31\n"
			+"0 6 31\n"
			+"0 5 60\n"
			+"1 2 21\n"
			+"2 4 46\n"
			+"2 6 25\n"
			+"3 4 34\n"
			+"4 6 51\n"
			+"5 3 18\n"
			+"5 4 40\n";
	
	static class Edge implements Comparable<Edge>{
		int dst;
		int cost;
		public Edge(int d, int c){
			this.dst = d;
			this.cost= c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		int V = sc.nextInt();
		int E = sc.nextInt();
		// �� �������� ��������Ʈ ��������
		ArrayList<Edge>[] adj = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adj[i] = new ArrayList<>();
		}
		// �ԷµǾ����� ���� �迭�� ��������Ʈ�� ����
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a].add(new Edge(b,c));
			adj[b].add(new Edge(a,c));
		}
		
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		//0���� �湮�Ѱɷ�üũ�ϰ�, 0������ �̾����� ��� ������ queue�� ����.
		visited[0] = true;
		//0������ ����ϴ� ������� ���� ��.
		queue.addAll(adj[0]);
		
		//Ȯ���� ������ ����
		int cnt = 1;
		int result = 0;
		
		//��� ������ Ȯ���Ҷ�����
		while(cnt != V) {
			Edge edge = queue.poll();
			
			// ���´µ� �̹� Ȯ���� ������ ������ �ٽ�.
			if( visited[edge.dst])
				continue;
			
			// Ȯ������ ���� ���� ������, �湮üũ�ϰ� ,�׳𿡼����� ������ ������ ť�� �߰�
			result += edge.cost;
			queue.addAll(adj[edge.dst]);
			visited[edge.dst] = true;
			cnt++;
		}
		System.out.println(result);
		
		
		
	}
	
	
}


