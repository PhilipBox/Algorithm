package studyGroup;

import java.util.Scanner;

public class bj_9095_123더하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int ts=0; ts<T; ts++) {
			int num = sc.nextInt();
			
			System.out.println(add(num));
			
			
		}//end test cases
	}//end main method
	
	static int add(int n) {
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		else if(n==3)
			return 4;
		
		return add(n-3)  + add(n-2) + add(n-1);
	}//end add method
}
