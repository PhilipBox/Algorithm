import java.util.Arrays;
import java.util.Scanner;

public class d4_성수의프로그래밍강좌시청 {
	static int N;
	static int K;
	static int[] course;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			course = new int[N];
			for(int i=0; i<N; i++)
				course[i] = sc.nextInt();
			Arrays.sort(course);
			double level = 0;
			for(int i=N-K; i<N; i++) {
				level = (level + course[i])/2;
			}
			System.out.print("#"+tc);
			System.out.format(" %.6f%n", level);
		}//end test cases
	}//end main
}
