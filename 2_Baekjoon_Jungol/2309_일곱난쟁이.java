package day00_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class bj_2309_일곱난쟁이 {
	
	static List<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] smurf = new int[9];
		for(int i=0; i<9; i++) {
			smurf[i] = sc.nextInt();
		}
		
		powerset(smurf, 0,0, new ArrayList<Integer>());

		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	static void powerset(int[] arr , int idx, int tall, List<Integer> list) {
		
		if(tall ==100 && list.size()==7) {
			Collections.sort(list);
			result.clear();
			for(int i=0; i<list.size(); i++) {
				result.add(list.get(i));
//				System.out.println(list.get(i));
			}
			return;
		}
		if(idx == arr.length)
			return;
		
		list.add(arr[idx]);
		powerset(arr, idx+1, tall+arr[idx], list);
	
		list.remove((Object)arr[idx]);
		powerset(arr, idx+1, tall, list);
		
	}//end powerset
}
