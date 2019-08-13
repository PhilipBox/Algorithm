package studyClass;

import java.util.Scanner;

public class d3_1240_단순2진암호코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[] code = new char[56];
			
			//N개의 line이 주어짐
			for(int i=0; i<N; i++) {
			//한줄 받아
			String tmp = sc.next();
			
				//한줄받아서 검사하고 코드를 발견했으면 break
				findCode(code, tmp);
			}//end N line
			
			//code에 56개의 코드가 들어와있음.
			//String으로 8개의 코드로 옮김
			String[] newCode = sevenCode(code);
			int[] numCode = new int[8];
			numCode = returnNumCode(newCode);
			
			
			if(checkCode(numCode)) {
				System.out.print("#"+tc+" ");
				int result=0;
				for(int i=0; i<8; i++) {
					result+=numCode[i];
				}
				System.out.println(result);
			}
			else
				System.out.println("#"+tc+" "+"0");
		}//end test cases
	}//end main
	
	static void findCode(char[] str, String tmp) {
		int cnt=55;
		if(str[55]==0) {
		for(int i=tmp.length()-1; i>=0; i--) {
			//1을 발견했으면 그 지점부터 str에 싹 담는다.
			if(tmp.charAt(i)=='1') {
				int t=i;
				while(true) {
					str[cnt]=tmp.charAt(t);
					cnt--;
					t--;
					if(cnt<0)
						break;
				}
				break;
			}
			//1을 못봤으면 그냥 다 돌고 return false하겠지.
		}
//		return false;
		}
	}
	
	static String[] sevenCode(char[] str) {
		StringBuilder sb = new StringBuilder();
		String[] strCode = new String[8];
		int idx =0;
		for(int i=0; i<56; i++) {
			if(i!=0 && i%7==0) {
				strCode[idx] = sb.toString();
				idx++;
				sb = new StringBuilder();
			}
			sb.append(str[i]);
			if(i+1==56)
				strCode[idx]=sb.toString();
		}
		return strCode;
	}
	
	static int[] returnNumCode(String[] str) {
		int[] numCode = new int[8];
		int idx =0;
		for(String s : str) {
			switch(s) {
			// 0
			case "0001101" :
				numCode[idx] = 0;
				break;
				
			// 1
			case "0011001" :
				numCode[idx] = 1;
				break;
				
			// 2	
			case "0010011" :
				numCode[idx] = 2;
				break;
				
			// 3
			case "0111101" :
				numCode[idx] = 3;
				break;
			
			// 4
			case "0100011" :
				numCode[idx] = 4;
				break;
				
			// 5
			case "0110001" :
				numCode[idx] = 5;
				break;
				
			// 6
			case "0101111" :
				numCode[idx] = 6;
				break;
				
			// 7
			case "0111011" :
				numCode[idx] = 7;
				break;
				
			// 8
			case "0110111" :
				numCode[idx] = 8;
				break;
				
			// 9
			case "0001011" :
				numCode[idx] = 9;
				break;
			}
			idx++;
		}
		return numCode;
	}

	static boolean checkCode(int[] numCode) {
		//0 2 4 6 
		int sum1=0;
		
		//1 3 5
		int sum2=0;
		for(int i=0; i<7; i++) {
			if(i%2==0)
				sum1+= numCode[i];
			else
				sum2+= numCode[i];
		}
		if( (sum1*3 + sum2 + numCode[7])%10==0)
			return true;
		else
			return false;
	}
}
