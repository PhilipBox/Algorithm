package day03_0722;

public class 선택정렬 {
	public static void main(String[] args) {
		
		int[] arr = {3,1,0,4,5,2,3,7};
		
		// 첫번째부터 맨 끝까지 순회하면서 제일 작은 값을 찾는다.
		for(int i=0; i<arr.length; i++) {
			int min = 1322234;
			int min_idx=i;
			for(int j=i;j<arr.length; j++) {
				if(min>arr[j]) {
					min = arr[j];
					min_idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min_idx];
			arr[min_idx] = tmp;
		}
		
		
		for(int i=0 ;i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}//emd main
}
