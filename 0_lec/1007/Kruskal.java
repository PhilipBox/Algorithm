import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	
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
	static class Node{
		int src;
		int dst;
		int cost;
		
		public Node(int src, int dst, int cost) {
			this.src = src;
			this.dst = dst;
			this.cost = cost;
		}
		
		@Override
		public String toString() {
			return ""+src+" , " + dst + " , " + cost;
		}
	}
	
	static class MyComp implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return o1.cost-o2.cost;
		}
	}
	
	static ArrayList<Node> list = null;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			parents = new int[V];
			list = new ArrayList<Node>();
			for(int i=0; i<E; i++) {
				Node node = new Node(sc.nextInt(), sc.nextInt(),sc.nextInt());
				list.add(node);
			}
			
			MyComp mycomp = new MyComp();
			Collections.sort(list, mycomp);
			
			for(int i=0; i<V; i++) {
				parents[i] = i;
			}
			
			int cnt=0;
			int total=0;
			for(int i=0; i<E; i++) {
				if(find(list.get(i).src) != find(list.get(i).dst)) {
					union(list.get(i).src, list.get(i).dst);
					total += list.get(i).cost;							
					cnt++;
				}
				else
					continue;
				if(cnt== (V-1))
					break;
			}
			System.out.println(total);
	}
	
	static int find(int x) {
		if(x==parents[x]) {
			return x;
		}
		else {
			parents[x] = find(parents[x]);
			return parents[x];
		}
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		parents[py] = px;
	}
}