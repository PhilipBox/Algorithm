package day00_study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d3_3499_퍼펙트셔틀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N = sc.nextInt();
			List<String> first = new ArrayList<String>();
			List<String> second = new ArrayList<String>();
			
			//카드 절반 분배 완료
			if(N%2==0) {
				for(int i=0; i<N; i++) {
					if(i<(N/2))
						first.add(sc.next());
					else
						second.add(sc.next());
				}
			}
			else {
				for(int i=0; i<N; i++) {
					if(i<(N/2+1))
						first.add(sc.next());
					else
						second.add(sc.next());
				}
			}
			int cnt1=0;
			int cnt2=0;
			List<String> perfect = new ArrayList<String>();
			for(int i=0; i<N; i++) {
				if(i%2==0) {
					perfect.add(first.get(cnt1));
					cnt1++;
				}else {
					perfect.add(second.get(cnt2));
					cnt2++;
				}
				System.out.println(i);
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<perfect.size(); i++) {
				System.out.print(perfect.get(i)+" ");
			}
			System.out.println();
		}//end test cases
	}//end main
}
