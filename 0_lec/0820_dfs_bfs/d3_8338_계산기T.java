import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class d3_8338_계산기T {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
//			int N = sc.nextInt();
			int N = Integer.parseInt(br.readLine());
//			int result = sc.nextInt();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = Integer.parseInt(st.nextToken());
//			int result = Integer.parseInt(br.readLine());
			for(int i=0; i<N-1; i++) {
//				int n = sc.nextInt();
				int n = Integer.parseInt(st.nextToken());
				result = Math.max(result+n, result*n);
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}//end test cases
		System.out.println(sb.toString());
	}
}
