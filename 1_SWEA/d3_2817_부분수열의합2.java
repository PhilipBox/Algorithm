package day04_0723;

import java.util.Scanner;

public class d3_2817_부분수열의합2 {
	static int ans =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			//N개의 원소가 입력됨
			int[] arr = new int[N];
			for(int i=0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			boolean[] selected = new boolean[N];
			ans=0;
//			powerset(arr, selected, 0, K);
			powerset2(arr, 0, 0, K);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void powerset2(int[] arr, int sum, int idx, int K) {
		
		if(sum == K)
			ans++;
		if( idx == arr.length) {
			return;
		}
		
		if(sum>=K) {
			return;
			//가지치기
		}
		
		powerset2(arr, sum + arr[idx], idx+1, K);
		powerset2(arr, sum, idx+1, K);
	}
	
	
	
	
	public static void powerset(int[] arr, boolean[] selected,int idx, int K) {
		
		if( idx == arr.length) {
			//true로 마킹된 친구들만 더해서 K가 나오는지 확인
			int sum=0;
			for(int i=0; i<arr.length; i++) {
				if(selected[i])
					sum += arr[i];
				//근데 sum이 이미 K보다 커진다면 나가리야. 
			}
			if(K==sum) {
				ans++;
			}
			return;
		}
		selected[idx] = true;
		powerset(arr, selected, idx+1, K);
		selected[idx] = false;
		powerset(arr, selected, idx+1, K);
	}//end powerset method
}
