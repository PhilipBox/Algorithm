package studyClass;

import java.util.Scanner;

public class d2_1288_새로운불면증치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int NN = sc.nextInt();
			int[] digit = new int[10];
			
			int N = NN;
			int mul=1;
			int cnt=0;
			int flag=0;
			while(flag==0) {
				if(check(digit))
					break;
				N = NN*mul;
				String str = Integer.toString(N);
				for(int i=0; i<str.length(); i++) {
					int c = str.charAt(i)-'0';
					digit[c]=1;
				}
				mul++;
				cnt++;
			}
			System.out.println("#"+tc+" "+(cnt*NN));
			
		}//end test cases
		
	}//end main
	
	static boolean check(int[] digits) {
		for(int i=0;i<10; i++) {
			if(digits[i]==0) {
				return false;
			}
		}
		return true;
	}//end check method
}
