package selfStudy;

import java.util.Scanner;

public class d3_6900_주혁이의복권당첨 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 당첨번호 
			String[] lotto = new String[N];
			// 당첨번호 별 당첨금 
			int[] money = new int[N];
			
			// 내가 산 복권의 수
			String[] myLotto = new String[M];
			
			// 당첨복권/당첨금 입력 
			for(int i=0; i<N; i++) {
				lotto[i] = sc.next();
				money[i] = sc.nextInt();
			}
			// 나의 복권 입력 
			for(int i=0; i<M; i++) {
				myLotto[i] = sc.next();
			}
			
			int total=0;
			// 당첨복권의 수 
			for(int i=0; i<N; i++) {
				// 내가 가진 복권의 수 
				for(int j=0; j<M; j++) {
					int flag=0;
					// 복권 글자수 비교 
					for(int k=0; k<8; k++) {
						// *은 모든 수 가능이니까 pass
						if(lotto[i].charAt(k)=='*')
							continue;
						else if(lotto[i].charAt(k)!=myLotto[j].charAt(k)) {
							flag=-1;
							break;
						}
					}//end 8글자 loop 
					// 한글자라도 틀린게 있다는 것. 
					if(flag==-1)
						continue;
					// 모든글자가 매칭
					else {
						total+= money[i];
					}
				}//end M
			}//end N
			
			
			System.out.println("#"+tc+" "+total);
			
		}//end test cases
	}//end main
}
