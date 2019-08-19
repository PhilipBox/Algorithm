package selfStudy;

import java.util.Scanner;

public class d5_1247_최적경로 {
	static int result =99999999;
	static pos company;
	static pos home;
	
	static class pos{
		int x;
		int y;
		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			result=99999999;
			
			// 들릴곳의 수 
			int N = sc.nextInt();
			int[] goX = new int[N];
			int[] goY = new int[N];
			
			// 회사 위치 (start)
			company = new pos(sc.nextInt(), sc.nextInt());
			// 집위치(end)
			home = new pos(sc.nextInt(), sc.nextInt());
			// 들려야할 곳
			for(int i=0; i<N; i++) {
				goX[i] = sc.nextInt();
				goY[i] = sc.nextInt();
			}
			
			permutation(goX, goY, new int[N], new boolean[N], 0);
			System.out.println("#"+tc+" "+result);
		}//end test cases;
	}//end main
	
	static void permutation(int[] goX, int[] goY, int[] sel, boolean visited[], int k) {
		if( k == sel.length) {
			int temp_sum=0;
			
			// 회사에서 첫번째 지점까지 거리
			temp_sum += dist(company.x, company.y, goX[sel[0]], goY[sel[0]]);
			// 마지막 지점에서 집까지의 거리 
			temp_sum += dist(home.x, home.y, goX[sel[sel.length-1]], goY[sel[sel.length-1]]);
			
			//지점들간 거리의 합 
			for(int i=0; i<sel.length-1; i++) {
				int distance = dist(goX[sel[i]], goY[sel[i]], goX[sel[i+1]], goY[sel[i+1]]);
				temp_sum += distance;
				
				//더하다가 기존의 최소값보다 커지면 빠끄 
				if(result<temp_sum)
					return;
			}
			//다돌고나와서 기존의 최소값과 비교 후 초기화 
			if(result>temp_sum) {
				result=temp_sum;
			}
			return;
		}
		
		for(int i=0; i< sel.length; i++) {
			if(visited[i])
				continue;
			//가기전에 고르고 가고, 고르고 간걸 체크하고 간다.
//			sel[k] = arr[i];
			// 기존 perm에서는 값을 넣어줬는데 이번에는 index를 넣어줬다 
			sel[k] = i;
			visited[i] = true;
			permutation(goX, goY, sel, visited, k+1);
			visited[i] = false;
		}
	}
	
	// 거리구하기 빠끄 
	static int dist(int x1, int y1, int x2, int y2) {
		return (Math.abs(x1-x2)+Math.abs(y1-y2));
	}//end dist 
	
}
