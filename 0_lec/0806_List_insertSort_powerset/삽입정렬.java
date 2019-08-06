package day08_0806;

public class 삽입정렬 {
	public static void main(String[] args) {
		int[] arr = {69, 10, 30, 2, 16, 8, 31, 22, 30,1,60,659};
		
		sortT(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void sort(int[] arr) {
		
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			for(int j=i-1; j>=0; j--) {
				if(key<arr[j]) {
					swap(arr,j+1,j);
					key = arr[j];
				}

			}
		}
	}
	
	// 1번째 원소부터 끝까지 검사하면서 		검사기준점 : arr[i]
	// arr[i]로부터 왼쪽으로 가며 검사.  (arr[j])
	//arr[i]보다 크면오른쪽으롤 한칸 이동 아니면 
	
	static void sortT(int[] arr) {
		int j;
		for(int i=1; i<arr.length; i++) {
			int key = arr[i];
			for(j=i-1; j>=0 && key <arr[j]; j--){
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;
		}
	}
	
	

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
