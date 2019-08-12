package 부분집합;

public class 부분집합의합 {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		powerset(arr, 0, 0);
		System.out.println(cnt);
	}
	
	static int cnt=0;
	//누굴 골랐는지 알 필요가 없어, 합을 구할때는
	static void powerset(int[] arr, int idx, int sum) {
		if(arr.length == idx) {
			//현재 위치가 배열의 끝에 도달했다면 종료.
			if(sum>=10) {
				cnt++;
			}
			return;
		}
		
		powerset(arr, idx+1, sum);
		powerset(arr, idx+1, sum+arr[idx]);
		
	}//end powerset method
}//
