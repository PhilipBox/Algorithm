import java.util.Scanner;

public class d5_1247_최적경로T {
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();//고객의 수
			
			int cx = sc.nextInt();	//회사의 x좌표
			int cy = sc.nextInt();	//회사의 y좌표
			
			int hx = sc.nextInt(); 	// 집의 x좌표
			int hy = sc.nextInt();	// 집의 y좌표
			
			int[][] customers = new int[N][N]; // 고객들의 좌표를 저장할 배열 
			
			for(int i=0; i<customers.length; i++) {
				customers[i][0] = sc.nextInt();
				customers[i][1] = sc.nextInt();
			}
			// 부분집합을 짜는 코드에서 원소를 선택하는건 선택배열에 체크하는것이지만,
			// 햄버거 다이어트 문제에서 원소를 선택하는건 해당원소(재료)의 맛 점수와 칼로리 점수를 누적합 하는 것.
			// 지금 이 문제도
			// 중복 순열에서는 n개의 경우에 대해서 반복을 돌며 재귀를 호출.
			// 순열에서는 똑같은걸 두번 고르지 않기 위해서 방문체크를 하며 n개의 경우에 대해 반복을 돌며 재귀호출.
			// 순열에서는 다음 번  순서를 고른다는게 그 원소를 기억하는 것.
			// 이 문제에서는 n명의 고객을 방문하는 반복에서 재귀호출 하되,
			// 순열처럼 방문했던 고객은 방문하지 않도록 방문체크가 필요하고.
			// @@원소를 선택하는 것이 아닌. ''마지막'' 방문했던 위치에서 다음번 선택하는 위치까지의 거리를 누적합 해 나가는것.!
			
			// 그러니까, 이 문제를 해결하는 재귀함수에서는
			// 마지막 방문했던 좌표와 지금까지 이용한 누적거리합을 들고다녀야 한다.
			ans = 987654321;
			backtrack(customers, new boolean[N], 0, hx, hy, cx, cy, 0);
			System.out.println("#"+ tc+" "+ans);
		}
	}//end main
	
	/* parameters
	 * 이 함수는 호출 전에 ans static 변수를 987654321로 초기화 해야합니다. 
	 * p1 : 고객들의 위치가 저장된 배열 
	 * p2 : 각 고객에 대한 방문 체크 배열
	 * p3 : 현재까지 누적 거리
	 * p4 : 최종 도착해야하는 집의 좌표
	 * p5 : 최종 도착해야하는 집의 좌표
	 * p6 : 마지막 방문했던 좌표
	 * p7 : 마지막 방문했던 좌표
	 * p8 : 현재 방문할 고객의 idx 
	 * 
	 * */
	
	static void backtrack(int[][] customers, boolean[] visited, int dist, int destx, int desty, int lastx, int lasty, int idx) {
		//기저파트  - 모든 고객을 방문하면 종료 
		if(idx == customers.length) {
			//지금까지 걸어온 거리에다가 , 현재 방문했던 위치에서 마지막 목적지인 집까지의 더 더하자.
			//해서 그 거리가 최소값이라면 갱신.
			int ndist = Math.abs(lastx - destx) + Math.abs(lasty - desty);
			dist += ndist;
			if(ans> dist)
				ans = dist;
			return;
		}
		
		// 재귀호출파트 - N명의 고객에 대해 반복돌면 재귀호출(방문체크하면서)
		for(int i=0; i<customers.length; i++) {
			if(ans < dist) {
				return;
			}
			
			if(visited[i])
				continue;
			
			visited[i] = true;
			//현재 위치ㅔ서 다음 방문할 고객까지의 거리를 계산
			int ndist = Math.abs(lastx- customers[i][0]) + Math.abs(lasty - customers[i][1]); 
			backtrack(customers, visited, dist+ndist, destx, desty, customers[i][0], customers[i][1], idx+1);
			visited[i] = false;
		}
		
	}
	
	
	
	
	
}
