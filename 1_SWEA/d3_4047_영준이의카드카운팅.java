package solving3;

import java.util.Scanner;

public class d3_4047_영준이의카드카운팅 {
	// A : 1
	//card: 2~10
	// J : 11 
	// Q : 12
	// K : 13
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int[][] card = new int[4][14];
			// 0 : S
			// 1 : D
			// 2 : H
			// 3 : C
			String str = sc.next();
			if(findCard(card, str)) {
				//여기 들어왔으면 중복된 카드가 없다는 것.
				System.out.print("#"+tc+" ");
				countCard(card);
			}
			else {
				System.out.println("#"+tc+" ERROR");
			}
		}//end test cases
	}//end main
	
	static boolean findCard(int[][] card, String str) {
		
		for(int i=0; i<str.length()-2; i++) {
			if(i%3==0) {
				int num = (str.charAt(i+1)-'0')*10 + (str.charAt(i+2)-'0');
				switch(str.charAt(i)) {
				case 'S' :
					if(card[0][num]==0)
						card[0][num]++;
					else
						return false;
					break;
				case 'D':
					if(card[1][num]==0)
						card[1][num]++;
					else
						return false;
					break;
				case 'H' :
					if(card[2][num]==0)
						card[2][num]++;
					else
						return false;
					break;
				case 'C' :
					if(card[3][num]==0)
						card[3][num]++;
					else
						return false;
					break;
				}
			}
			else {
				continue;
			}
		}
		return true;
	}
	
	static void countCard(int[][] card) {
		int s=0, d=0, h=0, c=0;
		for(int i=1; i<14; i++) {
			if(card[0][i]==1) {
				s++;
			}
			if(card[1][i]==1) {
				d++;
			}
			if(card[2][i]==1) {
				h++;
			}
			if(card[3][i]==1) {
				c++;
			}
		}
		System.out.println((13-s)+" "+(13-d)+" "+(13-h)+" "+(13-c));
	}
}
