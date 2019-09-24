import java.util.Arrays;
import java.util.Scanner;

public class 최장증가부분수열_hard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			//자신이 속할 수 있는 가장 긴 증가수열의 길이를 저장할 배열 
			int[] lis = new int[N];
			int ans = 0;
			
			//증가수열의 각 자리에 들어갈 수 있는 제일 작은 수를 기억할 배열
			int[] tmp = new int[N];
			
			int tmp_idx = 0; // tmp배열의 현재 크기
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				//tmp 배열에서 내 위치를 찾자.
				int left =0;
				int right = arr.length -1;
				int target = 9;
			
				while(left <= right) {
					int mid = (left + right) / 2;
					if(arr[mid] > target)
						right = mid - 1;
					else
						left = mid +1;
				}
				// -1이 나왔다? -> tmp[0]이 나, lis[i] = 1;
				if(right == -1) {
					tmp[0] = arr[i];
					lis[i] = 1;
				}
				// 나온위치가 tmp_idx다? -> tmp의 마지막자리에 나, lis[i] = tmp_idx+1 이고  tmp_idx는 하나 증가
				else if(tmp_idx == right) {
					tmp[tmp_idx++] = arr[i];
					lis[i] = tmp_idx;
				}
				// 둘다 아니라면? -> lis[i] = lis[찾아진위치+1] +1
				else {
					lis[i] = lis[right] +1;
					tmp[right+1]=arr[i];
				}
				ans = Math.max(lis[i], ans);
			}
			
			System.out.println("#"+tc+" "+ans);
		} // end test cases
	}

}
