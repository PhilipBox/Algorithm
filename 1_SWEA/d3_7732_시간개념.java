package studyClass;

import java.util.Scanner;

public class d3_7732_시간개념 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			String now = sc.next();
			String dst = sc.next();
			
			String now_s[] = now.split(":");
			String dst_s[] = dst.split(":");
			
			int now_t = Integer.parseInt(now_s[0])*3600;
			now_t += Integer.parseInt(now_s[1])*60;
			now_t += Integer.parseInt(now_s[2]);
			
			int dst_t = Integer.parseInt(dst_s[0])*3600;
			dst_t += Integer.parseInt(dst_s[1])*60;
			dst_t += Integer.parseInt(dst_s[2]);	
			
			int result=0;
			
			if(dst_t>=now_t) {
				result = dst_t - now_t;
			}
			else {
				result += (24*3600)-now_t;
				result += dst_t;
			}
			System.out.println("#"+tc+" "+convert(result));
		}//end test cases

	}//end main
	
	
	static StringBuilder convert(int time) {
		StringBuilder sb = new StringBuilder();
		
		if(time/3600 <10)
			sb.append(0).append(time/3600);
		else
			sb.append(time/3600);
		time%=3600;

		sb.append(":");
		if(time/60<10)
			sb.append(0).append(time/60);
		else
			sb.append(time/60);
		time%=60;
		sb.append(":");

		if(time<10)
			sb.append(0).append(time);
		else
			sb.append(time);
		
		return sb;
	}
}
