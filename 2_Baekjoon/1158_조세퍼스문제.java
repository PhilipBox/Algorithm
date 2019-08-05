package day00_study;

import java.util.ArrayList;
import java.util.Scanner;

public class bj_1158_조세퍼스문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList <Integer> list = new ArrayList<>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		// N입력
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		int cnt=0;
		int K_cnt = 0;
		while(true) {
			for(int i = 0; i<N; i++) {
				
				if(arr[i]>0 && (K_cnt!=K)) {
					K_cnt++;
				}
				if(arr[i]>0 && (K_cnt==K)) {
					list.add(arr[i]);
					arr[i] = -1;
					cnt++;
					K_cnt= 0;
				}
			}
				if(cnt==N)
					break;
		}//end while
		System.out.print("<");
		for(int i=0;i<list.size()-1; i++) {
			System.out.print(list.get(i)+", ");
		}
		System.out.print(list.get(list.size()-1));
		System.out.println(">");
	}//end main
}
