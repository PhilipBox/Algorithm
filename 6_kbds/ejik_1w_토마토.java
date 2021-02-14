// ���� 7576
// https://www.acmicpc.net/problem/7576
package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ejik_1w_�丶�� {
	static int N;
	static int M;
	static int map[][];
	static boolean visited[][];

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static Queue<tomato> queue = new LinkedList<>();

	static class tomato {
		int r;
		int c;

		public tomato(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int n = sc.nextInt();
				map[i][j] = n;
				
				// ó�� ���� �丶���� ��ġ add(start point)
				if (n == 1) {
					queue.add(new tomato(i, j));
				}
			}
		} // end for loop

		 bfs();

	}

	static void bfs() {
		int rst = 0;
		// �ּ� ��¥�� üũ�� ����(answer)
		while (!queue.isEmpty()) {

			tomato tmt = queue.poll();
//			System.out.println(tmt.r +","+tmt.c);
			visited[tmt.r][tmt.c] = true;

			for (int i = 0; i < 4; i++) {
				int nr = tmt.r + dr[i];
				int nc = tmt.c + dc[i];

				// �迭����üũ
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				else {
					// �丶�䰡 �����ʰ�(0), �湮���� �ʾҴ� ��(false)�̶��
					if (map[nr][nc] == 0 && visited[nr][nc] == false) {
						
						visited[nr][nc] = true; // �湮üũ
						queue.add(new tomato(nr, nc)); // ť�� ����
						map[nr][nc] = map[tmt.r][tmt.c] + 1; // ��¥���
						rst = map[nr][nc]; // ���������
					}
				}
			}
		} // end while

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					rst = -1;
				}
			} 
		}
		
		//��� �丶�䰡 ����µ� -1�� ������� 
		if(rst>0)
			System.out.println(rst-1);
		else
			System.out.println(rst);
	}//end bfs

}
