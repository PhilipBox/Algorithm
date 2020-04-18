package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

// 단어정렬
public class bj_1181 {
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 중복제거를 위한 set으로 input을 받음.
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<N; i++)
			set.add(br.readLine());
		
		// List 변환
		ArrayList<String> list = new ArrayList<String>(set);
		
		
		// Comparator를 사용하여 custom 정렬 구현
		// 단어의 길이기준으로 선 정렬, 길이가 같다면 사전순 정렬.
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length())
					return 1;
				else if(o1.length() < o2.length())
					return -1;
				else
					return o1.compareTo(o2);
			}
		});
		
		for(String s : list)
			System.out.println(s);
		
	}
}
