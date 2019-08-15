package selfStudy;

import java.util.Scanner;

public class d3_4676_늘어지는소리만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			// 위치를 횟수를 저장할 배열 
			int[] hyphen = new int[str.length()+1];
			int N = sc.nextInt();
			
			//하이픈을 넣을 자리 ++ 
			for(int i=0; i<N; i++) {
				int tmp = sc.nextInt();
				hyphen[tmp]++;
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<str.length(); i++) {
				if(hyphen[i]==0)
					System.out.print(str.charAt(i));
				else {
					while(true) {
						System.out.print("-");
						hyphen[i]--;
						if(hyphen[i]==0)
							break;
					}
					System.out.print(str.charAt(i));
				}//end else
			}//end for loop

			if(hyphen[str.length()]!=0) {
				while(true) {
					System.out.print("-");
					hyphen[str.length()]--;
					if(hyphen[str.length()]==0)
						break;
				}
			}
			System.out.println();
		}//end test cases
	}//end main
}
