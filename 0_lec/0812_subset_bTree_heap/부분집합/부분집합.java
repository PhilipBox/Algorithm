package 부분집합;

public class 부분집합 {
	public static void main(String[] args) {
		
		int[] arr = {1,3,5};
		powerset(arr, 0, new boolean[3]);
	}
	
	static void powerset(int[] arr, int idx, boolean[] sel) {
		if(arr.length == idx) {
			//현재 위치가 배열의 끝에 도달했다면 종료.
			
			for(int i=0; i<arr.length; i++) {
				if(sel[i])
					System.out.print(arr[i] + " ");
			}System.out.println();
			
			return;
		}
		
		sel[idx] = false;
		powerset(arr, idx+1, sel);
		sel[idx] = true;
		powerset(arr, idx+1, sel);
		
	}//end powerset method
}//
