package studyClass;
import java.util.Scanner;

public class d3_7964_부먹왕국의차원관문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int[] potal = new int[N];
			//관문 입력받기 
			for(int i=0; i<N; i++) {
				potal[i]= sc.nextInt();
			}
			
			int result=0;
			int cnt=D;
			
			for(int i=0; i<N-1; i++) {
				
				if(potal[i]==1) {
					cnt=D;
				}
				else {
					if(cnt==1){
						result++;
						cnt=D;
					}
					else
						cnt--;
				}
			}//end for loop
			System.out.println("#"+tc+" "+result);
		}//end test cases
	}//end main
}