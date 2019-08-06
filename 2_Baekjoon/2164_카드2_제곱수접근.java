package day00_study;

import java.util.Scanner;

public class bj {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int n = 1;
		while(n<N) {
			 n *= 2;
		}
		n /= 2;
		if(N==1)
			System.out.println(1);
		else
			System.out.println( (N-n)*2);
	}
}
