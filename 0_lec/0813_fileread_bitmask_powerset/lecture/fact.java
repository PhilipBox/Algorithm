package lecture;

import java.util.Scanner;

public class fact {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(facto(sc.nextInt()));
		
	}
	
	
	static int facto(int n) {
		
		if(n==1)
			return 1;
		
		return n * facto(n-1);
	}
	
	static int power_of_2(int k) {
		if( k == 0)
			return 1;
		else if ( k==1)
			return 2;
		
		int tmp = power_of_2(k/2);
		if(k%2==0) {
			return tmp * tmp;
		}
		else {
			return tmp * tmp * 2;
		}
	}
}
