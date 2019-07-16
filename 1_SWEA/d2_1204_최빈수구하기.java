package homework;

import java.util.Scanner;

public class hw_1204_최빈수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt();
		
		for(int i=0; i<ts; i++) {
			int arr[] = new int[101];
			int max=0;
			int max_idx=0;
			
            int t = sc.nextInt();

			for(int j=0; j<1000; j++) {
				int input = sc.nextInt();
				arr[input]++;
			}
			
			for(int j=0; j<101; j++) {
				if(max <= arr[j]) {
					max=arr[j];
					max_idx = j;
				}
			}
			System.out.println("#"+(i+1)+" "+max_idx);
			
		}// test case loop
	
			
	}//end main
}//end class
