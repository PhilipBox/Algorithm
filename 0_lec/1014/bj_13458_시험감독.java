import java.util.Scanner;

public class bj_13458_시험감독 {

	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long[] area = new long[N];
		for(int i=0; i<N; i++) {
			area[i] = sc.nextInt();
		}
		long B = sc.nextInt();
		long C = sc.nextInt();
		
		// 총감독은 무조건 있어야하니까
		for(int i=0; i<N; i++) {
			area[i] -= B;
		} 
		long total = N;
		for(int i=0; i<N; i++) {
			if(area[i]>0 && area[i]%C==0) {
				total += area[i]/C;
			}
			else if(area[i]>0 && area[i]%C!=0){
				total += area[i]/C;
				total++;
			}
		}
		System.out.println(total);
	}
}
