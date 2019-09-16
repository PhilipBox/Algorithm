import java.util.Arrays;
import java.util.Scanner;

public class d4_창용마을무리의개수 {

	static int parents[];
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for(int tc=1; tc<=T; tc++) {
				int N = sc.nextInt();
				int M = sc.nextInt();
				
				parents = new int[N+1];
				for(int i=1; i<=N; i++) {
					makeSet(i);
				}
				
				for(int i=0; i<M; i++) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					unionSet(x,y);
					System.out.println(Arrays.toString(parents));
				}
				
				int cnt=0;
				for(int i=1; i<=N; i++) {
					if(i == parents[i])
						cnt++;
				}
				System.out.println("#"+tc+" "+cnt);
			}//end test cases
		}
		
		static void makeSet(int x) {
			parents[x] = x;
		}
		
		static int findSet(int x) {
			if( x == parents[x])
				return x;
			else {
				return parents[x] = findSet(parents[x]);
			}
		}
		static void unionSet(int x, int y) {
			
			int px = findSet(x);
			int py = findSet(y);
			
			if(px!=py)
				parents[py] = parents[px];
		}
}



