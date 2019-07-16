package homework;

import java.util.Scanner;

public class hw_2063_중간값찾기 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int arr[] = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<N-1; i++) {
				for(int j=0; j<N-i-1;j++) {
					if(arr[j]>arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}//end sort loop

			System.out.println(arr[N/2]);
			
	}//end main
}//end class
