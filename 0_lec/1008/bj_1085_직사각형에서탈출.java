import java.util.Scanner;

public class bj_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int miny = Math.min(y, h-y);
		int minx = Math.min(x, w-x);
		int res = Math.min(minx, miny);
		System.out.println(res);
	}
}
