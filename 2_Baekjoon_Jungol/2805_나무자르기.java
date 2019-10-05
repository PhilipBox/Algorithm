package beakjoon;

import java.util.Scanner;

public class bj_2805_나무자르기 {

	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//나무의 수 
		N = sc.nextInt();
		arr = new int[N];
		//가져가야하는 나무의 길이 
		M = sc.nextInt();
		int max=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		long left=0;
		long right = max;
		long res=0;
		
		while(left<=right) {
			long mid = (left+right)/2;
			long total =0;
			for(int i=0; i<N; i++) {
				if(mid<arr[i]) {
					total += arr[i] - mid; 
				}
			}
			if(total >= M) {
				res=mid;
				left = mid+1;
			}
			else {
				right = mid-1;
			}
		}//end while loop
		System.out.println(res);
	}
}
