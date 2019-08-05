package day07_0805;

import java.util.ArrayList;
import java.util.Scanner;

//N과 K가 주어짐
//N은 출력되어져야 되는 전체 숫자. 1부터 N까지의 숫자가 한번씩 출력되어야함.
//N이 7이라면
//1 2 3 4 5 6 7가 있겠지?
// 이게 한번씩 출력되어야 하는데, 규칙은
// K번 건너뛰고 하나씩 출력.
// K가 3이라면
//3 6 2 7 5 1 4

// 백준 1158

public class 조세퍼스 {
	
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
