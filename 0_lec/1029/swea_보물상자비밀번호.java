import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class swea_보물상자비밀번호 {
	
	static class sorting implements Comparator<Long>{
		@Override
		public int compare(Long o1, Long o2) {
			return Long.compare(o2, o1);
		}
	}
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			int K = sc.nextInt();
			String s = sc.next();
			String[] PW = new String[N];
			for(int i=0; i<N; i++)
				PW[i] = s.charAt(i)+"";
			
			ArrayList<Long> pwList = new ArrayList<Long>();
			
			//0회전 값 추가.
			getSum(pwList, PW);
			for(int i=0; i<N/4-1; i++) {
				// N번 회전시킴.
				rotate(PW);
				//각변의 합 구하기
				getSum(pwList, PW);
			}
			Collections.sort(pwList, new sorting());
			System.out.println("#"+tc+" "+pwList.get(K-1));
		}//end test cases
	}//end main
	
	static void rotate(String[] PW) {
		String s = PW[N-1];
		for(int i=N-1; i>0; i--) {
			PW[i]=PW[i-1];
		}
		PW[0] = s;
	}
	
	static void getSum(ArrayList<Long> pwlist, String[] PW) {
		int DIV = N/4;
		int cnt = 0;
		String hex="";
		for(int i=0; i<N;i++) {
			hex += PW[i];
			cnt++;
			if(cnt==DIV){
				cnt=0;
				Long N = Long.parseLong(hex, 16);
				if(!pwlist.contains(N))
					pwlist.add(N);
				hex="";
			}
		}
	}//end getSum method
}
