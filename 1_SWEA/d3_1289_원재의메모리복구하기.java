package studyClass;

import java.util.Scanner;

public class d3_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int n =1;
		while(n<=T) {
			String bit = sc.next();			
			int cnt=0;
			int flag=0;
			
			for(int i=0; i<bit.length(); i++){
				if(flag==0 && (bit.charAt(i)=='1')){
					cnt++;
					flag=1;
				}
				else if(flag==1 && (bit.charAt(i)=='0')) {
					cnt++;
					flag=0;
				}
			}
			System.out.println("#"+n+" " + cnt);
			n++;
		}//end test cases loop
		
	}//end main
}//end class



