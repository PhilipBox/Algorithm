package 정렬;

public class Counting_sort {
	public static void main(String[] args) {
		int temp = 0;
		int[] count = new int[6];
		int[] arr = {1, 3, 2, 4, 3, 2, 5, 3, 1, 2,
					 3, 4, 4, 3, 5, 1, 2, 3, 5, 2,
					 3, 1, 4, 3, 5, 1, 2, 1, 1, 1};
		
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i=0; i<count.length; i++) {
			if(count[i]==0) 
				continue;
			for(int j=0; j<count[i]; j++) {
				System.out.print(i +" ");
			}
		}
	}
}
