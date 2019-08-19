package solving2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class d3_5948_새샘이의735게임 {
	static ArrayList<Integer> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			list = new ArrayList<Integer>();
			int[] num = new int[7];
			//7개 수 입력
			for(int i=0; i<7; i++) {
				num[i] = sc.nextInt();
			}
		
			comb(num, new int[3], 0, 0);
			
			Collections.sort(list);
			System.out.println("#"+tc+" "+list.get(list.size()-5));
		
		}//end test cases
	}//end main
	
	static void comb(int[] arr, int[] sel, int idx, int k ) {
		if(k == sel.length) {
			int sum =0;
			for(int i=0; i<sel.length; i++) {
				sum += sel[i];
			}
			if(!list.contains(sum))
				list.add(sum);
			return;
		}
		
		if(idx == arr.length)
			return;
		
		sel[k] = arr[idx];
		comb(arr, sel, idx+1, k+1);
		comb(arr, sel, idx+1, k);
	}
	
}
