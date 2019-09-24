import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class d4_3234_준환이의양팔저울 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			memo = new HashMap<String, Integer>();
			int cnt = dfs(0,0,0, arr, visited, N);
			System.out.println("#"+tc+" "+cnt);
		}//end test cases
	}
	
	static HashMap<String, Integer> memo;
	
	static int dfs(int r, int l, int k, int[] arr, boolean[] visited, int N) {
		//현재 상태 ( 고른패턴, 왼쪽무게합, 몇번째꺼까지 골랐는지 )
		String status = Arrays.toString(visited)+ l + "/" +k;
		System.out.println(status);
		if(memo.containsKey(status))
			return memo.get(status);
		if(k==N) {
			//끝까지 오면 되는거니까 +1 해주는 것처럼 return 1
			return 1;
		}
		int cnt =0;
		//재귀 팡팡
		for(int i=0; i<N; i++) {
			//쓴게 아니라면 
			if(!visited[i]) {
				visited[i] = true;
				
				// 왼쪽 vs 오른쪽+새로운거
				// 왼쪽이 더 크거나 같으니까 조건만족.(진행가능)
				if(r + arr[i] <= l) {
					cnt += dfs(r + arr[i], l , k+1, arr, visited, N);
				}
				// 바꿔서도 해봐야지
				cnt += dfs(r, l+arr[i], k+1, arr, visited, N);
				visited[i] = false;
			}
		}
		memo.put(status, cnt);
		return cnt;
	}
}
