import java.util.Scanner;

public class bj_14501_퇴사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] talk = new int[N][2];
		// 0은 소요시간
		// 1은 금액
		for (int i = 0; i < N; i++) {
			talk[i][0] = sc.nextInt();
			talk[i][1] = sc.nextInt();
		}

		int maxSal=0;
		for(int i=0; i<N; i++) {
			int total=0;
			for(int j=i; j<N; ) {
				if(j==N-1 && talk[j][0]==1) {
					total += talk[j][1];
					break;
				}
				if(j+talk[j][0]>N) break;
				total += talk[j][1];
				System.out.println(j +" "+ talk[j][1]);
				if(j+talk[j][0]<N)
					j+= talk[j][0];
				else
					break;
			}
			System.out.println(total);
			System.out.println("----------");
			maxSal= Math.max(maxSal, total);
		}
		System.out.println(maxSal);
	}// end main
}
