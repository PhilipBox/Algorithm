package 부분집합;


//sel 배열을 통해서 원소선택여부를 기록한 부분집합 - 부분집합.class
//sum 변수에 원소의 합을 더해가며 부분집합의 함 - 부분집합의합.class (조건지우면됨)
//부분집합의 합 중에서 합이 특정 값 이상인 경우의 수 - 부분집합의합.class
//부분집합의 합 중에서 원소가 특정개 인 경우의 합. - 부분집합의합2.class


//5개 원소중 4개만 더한것만 알고 싶을때, 
public class 부분집합의합2 {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		powerset(arr, 0, 0, 0);
		System.out.println(cnt);
	}
	
	
	static int cnt=0;
	//누굴 골랐는지 알 필요가 없어, 합을 구할때는
	static void powerset(int[] arr, int idx, int sum,int n) {
		if(arr.length == idx) {
			//현재 위치가 배열의 끝에 도달했다면 종료.
			if(sum>=10 && n==4) {
				cnt++;
			}
			return;
		}
		
		powerset(arr, idx+1, sum, n);
		powerset(arr, idx+1, sum+arr[idx], n+1);
		
	}//end powerset method
}//


