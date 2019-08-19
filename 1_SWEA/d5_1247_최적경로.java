package solving2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class d5_1247_최적경로 {
	
//	static ArrayList<pos> list;
	static ArrayList<Integer> resultList;
	static int result =0;
	
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
//			//들려야할 집을 담을 list
//			list = new ArrayList<>();
			
			//거리들을 담을 list
			resultList = new ArrayList<>();
			
			// 들릴곳의 수 
			int N = sc.nextInt();
			int[] goX = new int[N];
			int[] goY = new int[N];
			
			// 회사 위치 (start)
			pos company = new pos(sc.nextInt(), sc.nextInt());
			// 집위치(end)
			pos home = new pos(sc.nextInt(), sc.nextInt());
			// 들려야할 곳
			for(int i=0; i<N; i++) {
				goX[i] = sc.nextInt();
				goY[i] = sc.nextInt();
//				list.add(new pos(sc.nextInt(), sc.nextInt()));
			}
			
			permutation(goX, goY, new int[N], new boolean[N], 0);

			
		}//end test cases;
	}//end main
	
	
	
	
	
	
	
	static void permutation(int[] goX, int[] goY, int[] sel, boolean visited[], int k) {
		//종료 조건이 2가지
		if( k == sel.length) {
			//목적을 만족시킴. 다 고른것!
			System.out.println(Arrays.toString(sel));
			//여기서 인덱스별로 넣으면서 합을 계산.
			//더할때 static int보다 크면 빠끄
			int sum=0;
			for(int i=0; i<sel.length-1; i++) {
				int distance = dist(goX[i], goX[i+1], goY[i], goY[i+1]);
				sum += distance;
			}
			
			
			return;
		}
		
		for(int i=0; i< sel.length; i++) {
			//
			if(visited[i])
				continue;
			
			//가기전에 고르고 가고, 고르고 간걸 체크하고 간다.
//			sel[k] = arr[i];
			sel[k] = i;
			visited[i] = true;
			permutation(goX, goY, sel, visited, k+1);
			visited[i] = false;
		}
	}
	
	
	static int dist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2)+ Math.abs(y1-y2);
	}//end dist 
	
}
