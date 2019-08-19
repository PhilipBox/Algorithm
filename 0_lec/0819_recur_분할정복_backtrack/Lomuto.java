
public class Lomuto {

	public static void main(String[] args) {
		int[] arr = { 0, -1, 100, 3, 3, 2, 4, 6, -1 , 9, 1, 8, 7, 5 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");

	}

	static int partition_lomuto(int[] arr, int left, int right) {
		int x = arr[right];
		//x보다 작은 값들 중 가장 오른쪽을 지키자.
		int i = left;
		for(int j= left; j<right; j++) {
			if(arr[j] <= x) {
				swap(arr, i,j);
				i++;
			}
		}
		swap(arr, i, right);
		return i;
	}
	
	
	static int partition(int[] arr, int left, int right) {
		// 피벗
		int p = arr[left];

		int i = left;
		int j = right;
		while (i <= j) {
			while (i<= j && arr[i] <= p) {
				i++;
			}
			while (i<= j && arr[j] > p) {
				j--;
			}
			if (i < j)
				swap(arr, i, j);
		}
		swap(arr, left, j);
		return j;
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	static void quickSort(int[] arr, int left, int right) {
		if(left>=right)
			return;
		
		if (left < right) {
//			int pivot = partition(arr, left, right);
			int pivot = partition_lomuto(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}
	}// end quickSort
}
