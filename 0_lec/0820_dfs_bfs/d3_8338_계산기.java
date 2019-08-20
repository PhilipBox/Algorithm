import java.util.Scanner;

public class d3_8338_계산기 {
	static int val ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			//수 입력
			for(int i=0; i<N; i++) {
				num[i] = sc.nextInt();
			}
//			int temp=0;
//			temp = num[0];
//			for(int i=0; i<N-1; i++) {
//				if(temp+num[i+1] > temp*num[i+1]) {
//					temp += num[i+1];
//				}
//				else {
//					temp *= num[i+1];
//				}
//			}
//			System.out.println("#"+tc+" "+temp);
			val = num[0];
			cal(num, 1);
			System.out.println("#"+tc+" "+val);
		}//end test cases
	}//end main
	
	
	static void cal(int[] num, int idx) {
		if(idx==num.length)
			return;
		
		if(val+num[idx] > val*num[idx]) {
			val += num[idx];
		}
		else {
			val *= num[idx];
		}
		cal(num, idx+1);
		
	}
}
