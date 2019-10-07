import java.util.Scanner;

public class bj_2355_시그마 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long temp;
		if (B < A) {
			temp = B;
			B = A;
			A = temp;
		}
		//항상 A<B
		if(A>=0 && B>=0) {
			System.out.println(sum(B)-sum(A-1));
		}
		else if( A<0 && B>=0) {
			System.out.println( (sum((A*-1))*-1)+sum(B));
		}
		else{
			System.out.println((sum((A*-1))*-1) + (sum((B+1)*-1)));
		}
	}
	static long sum(long n) {
		return (n*(n+1))/2;
	}
	
}
