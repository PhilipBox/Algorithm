import java.util.Scanner;

public class bj_2490_윷놀이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 도 0001
		// 개 0011
		// 걸 0111
		// 윷 0000
		// 모 1111
		for (int i = 0; i < 3; i++) {
			int total = 0;
			for (int j = 0; j < 4; j++) {
				total += sc.nextInt();
			}
			switch (total) {
			case 0:
				System.out.println("D");
				break;
			case 1:
				System.out.println("C");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("A");
				break;
			case 4:
				System.out.println("E");
				break;
			}
		}
	}
}
