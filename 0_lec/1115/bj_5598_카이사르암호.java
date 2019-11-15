package _1115;

import java.util.Scanner;
public class bj_5598_카이사르암호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			c -= 3;
			if(c<'A') {
				System.out.print((char) (c+26));
			}
			else {
				System.out.print(c);
			}
		}
	}
}
