package homework;

import java.util.Scanner;

public class hw_5431_과제체크 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ts = sc.nextInt();
		
		for(int i=0; i<ts; i++) {
			
			int person = sc.nextInt();
			int hw = sc.nextInt();
			
			int[] students = new int[person];
			
			for(int j=0; j<hw; j++) {
				int sub = sc.nextInt();
				students[sub-1]++;
			}
			
			System.out.print("#"+(i+1));
			for(int j=0; j<person; j++) {
				if(students[j]==0) {
					System.out.print(" "+(j+1));
				}
			}
			
			System.out.println();
			
		}//end test cases
		
		
	}//end main
}//end class
