import java.util.Arrays;
import java.util.Scanner;

public class N_Queen {
	static int cnt=0;
	static int result=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		//N이 4라고 하자
		//각 라인에 퀸을 세우는 코드를 짜려면,
		// 0행
		// 1행
		// 2행
		// 3행 
		// 9부터 3까지 반복을 하며 각 라인에 퀸을 세우면 됨.
		// 그냥 각 열에 퀸을 세우는 경우의 수가 하나만 존재한다면, 반복만 한번 돌면 되지만, 
		// 각 라인별로 여러 경우의 수가 존재하기 떄문에, 중복순열과 유사한 스타일의 재귀함수가 필요.
		backtrack(map,0);
//		System.out.println(result);
//		System.out.println("호출횟수 :" + cnt );
		
	}
	
	//map은 0으로 초기화된 상태
	static void backtrack(int[][] map, int line) {
		cnt++;
		if(line == map.length) {
			result++;
		//각 줄에 하나의 퀸을 모두 배치하였다.
//			for(int i=0; i<map.length; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}System.out.println();
			return;
		}
		
		for(int i=0; i<map[line].length; i++) {
			// 여기에 놓을떄, 퀸을 놔도 꺠지지 않는지 보고 판별해도 프루닝(가지치기)
			// 위에서부터 놓는중.
			if(isPossible(map,line, i)) {
				//열의 자리에 퀸을 세워보자
				map[line][i] = 1; // 갈때 체크하고 가고 
				backtrack(map, line+1);
				map[line][i] = 0; // 원래대로 돌려놔야해.
			}
		}
	}
	
	static boolean isPossible(int[][]map, int r, int c) {
		//내 위로 퀸이 있었는지.
		//위에서부터 놓는 중이니까 아래에는 없어.
		
		//내 위로 퀸이 있는지.
		for(int i=r; i>=0; i--) {
			if(map[i][c]==1)
				return false;
		}
		
		//내 왼쪽위로 있는지.
		for(int i=r, j=c; i>=0 && j>=0; i--, j--) {
			if(map[i][j]==1)
				return false;
		}
		
		//내 오른쪽 위로 있는지.
		for(int i=r, j=c; i>=0 && j < map[i].length; i--, j++) {
			if(map[i][j]==1)
				return false;
		}
		return true;
	}//end isPossible
}
