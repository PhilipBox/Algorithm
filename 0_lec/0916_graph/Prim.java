import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prim {
	static class Node{
		
	}
	
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
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(src);
		
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		//������ ������ ������ �������
		int[][] adj = new int[V][V];

		//Ȯ���� ��尡 ������������ Ȯ���� �� �ִ� Ȯ���� ����� ����Ʈ
		List<Integer> nodeList = new ArrayList<Integer>();
		//Ȯ���� ����Ʈ�� ��ȸ���� �ʰ� Ȯ���� ������ �ƴ��� �����ϱ� ���� �湮 �迭
		boolean[] visited = new boolean[V];

		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a][b] = c;
			adj[b][a] = c;
		}
		
		
		
		//������ ��带 ù��° ���� ����.
		nodeList.add(0);
		//Ȯ���� ���� �湮üũ
		visited[0] = true;
		
		
		//�ּҰ�, �ּҰ��� ��ġ, ��������� ���� ������ ����
		int min, index, result=0;
		
		//���������� �� ������ ���� �� ��ŭ �ݺ�
		for(int i=0; i<V-1; i++) {
			min = Integer.MAX_VALUE;
			index = -1;
			//	Ȯ���� ������ �ϳ��� ������, ���س��� ��� �ݺ�
			for(int node : nodeList) {
				//	��������� �̿��Ͽ� �湮�ߴ� ���س�� �������� �� �� �ִ� �湮���� ���� ������� �Ÿ� �� �ּҰ��� ã��.
				for(int j=0; j<V; j++) {
					//�湮���� �ʾҴ� ��� -> !visited[j]
					//�����ִ� �� -> adj[node][j] !=0
					//�˰��ִ� �ּҰ����� ���� -> adj[node][j] < min
					if( !visited[j] && adj[node][j] !=0 && adj[node][j] < min) {
						min = adj[node][j];
						index = j; // Ȯ���ϰ��� �ϴ� ����
					}
				}
			}
			//�ش� ����� ������
			result += min;
			//�ּҰ� ������ Ȯ���� ��帮��Ʈ�� �߰�
			nodeList.add(index);
			//Ȯ���� ���� �湮üũ
			visited[index] = true;
		}
		System.out.println(result);
		

		
		

		
		
		
		
	}
}
