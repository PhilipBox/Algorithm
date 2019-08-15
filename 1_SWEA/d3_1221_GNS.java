package selfStudy;

import java.util.Scanner;

public class d3_1221_GNS {
	static String[] str = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sc.next();
			int N = sc.nextInt();
			int[] digit = new int[10];
			for(int i=0; i<N; i++) {
				String s = sc.next();
				typeDigit(digit, s);
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<10; i++) {
				if(digit[i]==0)
					continue;
				else {
					while(true) {
						System.out.print(str[i]+" ");
						digit[i]--;
						if(digit[i]==0)
							break;
					}
				}//end else
			}
			System.out.println();
		}//end test cases
	}
	
	static void typeDigit(int[] digit, String s) {
		
		switch(s) {
		// "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"
		case "ZRO" :
			digit[0]++;
			break;
		case "ONE" :
			digit[1]++;
			break;
		case "TWO" :
			digit[2]++;
			break;
		case "THR" :
			digit[3]++;
			break;
		case "FOR" :
			digit[4]++;
			break;
		case "FIV" :
			digit[5]++;
			break;
		case "SIX" :
			digit[6]++;
			break;
		case "SVN" :
			digit[7]++;
			break;
		case "EGT" :
			digit[8]++;
			break;
		case "NIN" :
			digit[9]++;
			break;
		}//end switch
	}//end typeDigit method
}
