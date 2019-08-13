package solving2;

import java.util.Scanner;

public class d3_7675_통역사성경이 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			StringBuilder rst = new StringBuilder();
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			int cnt = N;
			
			while(cnt!=0) {
				//
				String str = sc.next();
				
				if(str.contains(".") || str.contains("?") || str.contains("!")) {
						str.replace("\n", "");
						sb.append(str);
						sb.deleteCharAt(sb.length()-1);
						cnt--;
						
						rst.append(check(sb));
						//초기화 
						sb = new StringBuilder();
						continue;
				}
				//구두점이 없으면 붙여라.(끝나지 않는다는 거니까.)
				else {
					sb.append(str).append(" ");
				}
//				System.out.println(sb.toString());
			}//end for loop
			System.out.print("#"+tc);
			for(int i=0; i<rst.length(); i++) {
				System.out.print(" "+ rst.charAt(i));
			}
				
			System.out.println();
		}//end test cases
	}//end main
	
	static int check(StringBuilder sb) {
		//구두점까지의 한문장이 sb로 옴.
		
		//한 문장을 string으로 반환
		String tmp = sb.toString();
		//공백기준으로 스플릿
		String[] str = tmp.split(" ");
		int total = 0;
		for(String s : str) {
//			System.out.print(s + " ");
			//한단어별로 모두 스캔
			int flag=1;
			for(int i=0; i<s.length(); i++) {
				//첫글자는 반드시 대문자 영어
				if(i==0) {
					//알파벳이 아니면  + 대문자
					if(Character.isUpperCase(s.charAt(0))==false) {
						//다음 단어탐색 시작.
						flag=0;
						break;
					}
				}
				
				if(i !=0 && Character.isAlphabetic(s.charAt(i))==false) {
					flag=0;
					break;
				}
				if(i !=0 && Character.isUpperCase(s.charAt(i))) {
					flag=0;
					break;
				}
				
			}
			if(flag==1)
				total++;
			//단어스캔완료
			
		}
		return total;
	}//end check
}
