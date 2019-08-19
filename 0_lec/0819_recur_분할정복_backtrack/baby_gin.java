import java.util.Scanner;

public class baby_gin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			
			
		}//end test cases
	}//end main
	
	static boolean search(String str, int idx, int flag) {
		//마지막조건 하나
		
		// 최종
		if(idx==str.length()) {
			System.out.println();
			return true;
		}

		// 같은수의 진행이라면 
		if(flag != 0) {
			if( (str.charAt(idx)-'0')==(str.charAt(idx+1)-'0')) {
				flag++;
				search(str, idx+1, flag);
			}
			
		}
		//flag가 0이 아니면 같은 연속된 수로 검색, 3이면 flag 0으로 
		//flag가 0이면 증가하는 수 
		
		

		
		// 연속된거 검색
		if( (str.charAt(idx)-'0') - (str.charAt(idx+1)-'0') >1)
			return false;
		
		search(str, idx+1, flag);
		
		
		return false;
	}
	
}
