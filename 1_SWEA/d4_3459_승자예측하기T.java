package _solving;

import java.util.Scanner;

public class d4_3459_승자예측하기T {
	//1 : Bob
	//2-5 : Alice
	//6-9 : Bob
	//10-25 : Alice
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			boolean isAlice = true;
			long range = 1;
			while(N>0) {
				N -= range;
				if(isAlice) {
					range *= 4;
				}
				isAlice = !isAlice;
			}
			System.out.println("#"+tc+" "+ (isAlice? "Alice" : "Bob"));
		}
	}
	
}
