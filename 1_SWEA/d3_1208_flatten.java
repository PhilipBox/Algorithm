package homework;

import java.util.Arrays;
import java.util.Scanner;

public class hw_1208_flatten {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int ts=1; ts<=10; ts++) {
			//덤프 수 입력
			int dumps = sc.nextInt();
			int[] box = new int[100];
		
			// 100개의 박스값 입력
			for(int i=0; i<box.length; i++) {
				box[i] = sc.nextInt();
			}
			Arrays.sort(box);

			for(int i=0; i<dumps; i++) {
				box[0]++;
				box[box.length-1]--;
				Arrays.sort(box);
			}
			System.out.println("#"+ts + " "+ (box[box.length-1]-box[0]));
		}// end 10 cases	
	}//end main
}//end class
