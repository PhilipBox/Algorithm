
public class 퀵정렬 {

	public static void main(String[] args) {
		int[] arr = { 0, -1, 100, 3, 3, 2, 4, 6, -1 , 9, 1, 8, 7, 5 };
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr)
			System.out.print(i + " ");

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

	static void quickSort(int[] arr, int l, int r) {
		if(l>=r)
			return;
		
		if (l < r) {
			int pivot = partition(arr, l, r);
			quickSort(arr, l, pivot - 1);
			quickSort(arr, pivot + 1, r);
		}
	}// end quickSort
}
