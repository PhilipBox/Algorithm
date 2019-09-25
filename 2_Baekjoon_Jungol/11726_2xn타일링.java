import java.util.Scanner;

public class bj_11726_2xn타일링 {
	static final int K = 10007;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		arr[0] =1;
		if(N>1)
			arr[1] = 2;
		for(int i=2; i<N; i++)
			arr[i] = (arr[i-2] + arr[i-1])%K;
		System.out.println(arr[N-1]);
	}
}
