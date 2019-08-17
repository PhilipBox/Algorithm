package selfStudy;

import java.util.Scanner;

public class d3_3809_화섭이의정수나열 {
	static boolean[] digit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			digit = new boolean[1001];
			int N = sc.nextInt();
			int[] card = new int[N];
			//숫자입력받기 
			for(int i=0; i<N; i++) {
				card[i]= sc.nextInt();
				digit[card[i]] = true;
			}
			
			System.out.print("#"+tc+" ");
			// 한자리수 검증 
			if(firstStep() != -1) {
				System.out.print(firstStep());
			}
			else {
				// 두자리수 검증 
				if(secondStep(card)!=-1) {
					System.out.print(secondStep(card));
				}
				else {
					//세자리수 검증 
					System.out.print(thirdStep(card));
				}
				
			}
			
			// 두자리수 검증 
			
			System.out.println();
		}//end test cases
	}//end main
	
	static int firstStep() {
		for(int i=0; i<=9; i++) {
			if(digit[i] == false) {
				return i;
			}
		}
		return -1;
	}//end firstStep method

	static int secondStep(int[] card) {
		
		String s = "";
		
		//2자리 숫자 true로 
		for(int i=0; i<card.length-1; i++) {
			s="";
			if(card[i]==0)
				continue;
			else {
				//두자리 붙이기. 
				int temp = 0;
				temp += card[i]*10;
				temp += card[i+1];
				digit[temp] = true;
			}
		}
		
		// 가장 작은 수 찾기 
		for(int i=10; i<=99; i++) {
			if(digit[i]==false)
				return i;
		}
		
		//모든수가 있는 것.
		return -1;
	}
	
	static int thirdStep(int[] card) {
		
		String s = "";
		
		//3자리 숫자 true로 
		for(int i=0; i<card.length-2; i++) {
			s="";
			if(card[i]==0)
				continue;
			else {
				//3자리 붙이기 
				int temp = 0;
				temp = card[i]*100;
				temp += card[i+1]*10;
				temp += card[i+2];
				digit[temp] = true;
			}
		}
		
		// 가장 작은 수 찾기 
		for(int i=100; i<=999; i++) {
			if(digit[i]==false)
				return i;
		}
		
		return -1;
	}//end thirdStep method
	
}