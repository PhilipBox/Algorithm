import java.util.Arrays;
import java.util.Scanner;

public class bj_10815_숫자카드 {
	static int N;
	static int M;
	static int[] arr;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//상근이가 가지고 있는 숫자 카드 N
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		Arrays.parallelSort(arr);
		// 확인해볼 카드 M
		M = sc.nextInt();
		chk = new int[M];
		for(int i=0; i<M; i++) {
			chk[i] = sc.nextInt();
			binarySearch(0, N-1, chk[i]);
		}
	}
	static void binarySearch(int left, int right, int target) {
		if(left > right) {
			System.out.print("0 ");
			return;
		}
		int mid = (left+right)/2;
		if(target < arr[mid]) {
			binarySearch(left, mid-1, target);
		} else if(target > arr[mid]) {
			binarySearch(mid+1, right, target);
		} else {
			System.out.print("1 ");
			return;
		}
	}
}
