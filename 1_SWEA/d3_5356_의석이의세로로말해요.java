package selfStudy;

import java.util.Scanner;

public class d3_5356_의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			char[][] word = new char[5][15];
			for(int i=0; i<5; i++) {
				String s = sc.next();
				// 한줄씩 입력받기 
				for(int j=0; j<15; j++) {
					if(j<s.length())
						word[i][j]= s.charAt(j);
					else
						word[i][j]= '#';
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++) {
					if(word[j][i]!='#')
						sb.append(word[j][i]);
					else
						continue;
				}
			}
			System.out.println("#"+tc+" "+sb.toString());
			//최종출력 
		}//end test cases
	}//end main
}
