package _1112;
import java.util.*;

public class bj_14890_경사로 {
	static int N;
	static int L;
	static int ans;
	static int[][] garo = new int[101][101];
	static int[][] sero = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) {
				garo[i][j] = sc.nextInt();
				sero[j][i] = garo[i][j];
			}

		for (int i = 0; i < N; i++) {
			check(i, garo);
			check(i, sero);
		}
		System.out.println(ans);
	}

	static void check(int row, int map[][]) {
		boolean visited[] = new boolean[N];
		//가장 앞에 있는 높이
		int temp = map[row][0];
		for (int i = 0; i < N; i++) {
			// 높이가 다르다면
			if (map[row][i] != temp) {
				// 높이 차이가 2 이상이면  안됨.
				if (Math.abs(map[row][i] - temp) > 1)
					return;
				
				// 다음것이 나보다 작을 경우(오른쪽 경사로 - 내려가는 경사로)
				if (map[row][i] < temp) { 
					// 현재 위치높이를 기억할 변수(연속됨을 확인하기 위해서)
					int num = -1;
					// 현재 위치부터 , 현재위치 + 길이 -1 까지 반복 (경사로를 세울 수 있는 거리)
					for (int j = i; j <= i + L - 1; j++) {
						// 그 거리를 만족하지 못하거나, 이미 세워진 곳이라면 안됨.
						if (j >= N || visited[j])
							return;
						
						// 그렇지 않다면 세운다.
						visited[j] = true;
						
						//내려가고나서의 숫자를 저장
						if (num == -1) {
							num = map[row][j];
							continue;
						}
						
						// 연속되는 숫자인지 확인 - 경사로로 내려가고 연속되지 않는다면 안됨
						// 놓을 수 있는 위치는  visit으로 확인했음.
						// 그럼에도, 높이가 달라지는게 있다면 경사로를 놓을 수 없음
						// 경사로는 동일한 높이 + 세워지지않은(visited)곳에 놓을 수 있음.
						if (num != -1 && map[row][j] != num)
							return;
					}
					
					// i의 위치를 이동
					// 경사로를 모두 세우고 난 뒤의 지점으로.
					i = i + L - 1;
					// 그 길이가 마지막이면 break.
					if (i >= N)
						break;
				} else { // 다음것이 나보다 큰 경우(왼쪽 경사로)
					// 현재 위치높이를 기억할 변수(연속됨을 확인하기 위해서)
					int num = -1;
					//현재 높이의 위치에서 경사로를 놓을 수 있는 길이만큼 반대방향으로 가본다.
					for (int j = i - 1; j >= i - L; j--) {
						// 이미 경사로가 놓아진 상태라면, 겹치므로 안된다.
						if (j < 0 || visited[j])
							return;
						
						// 경사로를 놓는다.
						visited[j] = true;
						
						//내려가고나서의 숫자를 저장
						if (num == -1) {
							num = map[row][j];
							continue;
						}
						
						// 연속되는 숫자인지 확인 - 경사로로 내려가고 연속되지 않는다면 안됨
						// 놓을 수 있는 위치는  visit으로 확인했음.
						// 그럼에도, 높이가 달라지는게 있다면 경사로를 놓을 수 없음
						// 경사로는 동일한 높이 + 세워지지않은(visited)곳에 놓을 수 있음.
						if (num != -1 && map[row][j] != num)
							return;
					}
				}
				//비교할 temp 변수 업데이트.
				temp = map[row][i];
			}
		}
		// 여기까지 return되지 않고 도달했다면 조건을 만족한다는 것.
		++ans;
	}
}
