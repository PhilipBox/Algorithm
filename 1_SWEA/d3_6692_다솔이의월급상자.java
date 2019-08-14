package solving2;

import java.util.Scanner;

public class d3_6692_다솔이의월급상자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			double[] pct = new double[n];
			double[] pay = new double[n];
			double sum=0;
			for(int i=0; i<n; i++) {
				pct[i] = sc.nextDouble()*10;
				pay[i] = sc.nextDouble();
				sum += pct[i]*pay[i];
			}
			System.out.println("#"+tc+" "+sum/10);
		}//end test cases
	}//end main
}
