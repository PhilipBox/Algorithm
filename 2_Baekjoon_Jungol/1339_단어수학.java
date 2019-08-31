package _solving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bj_1339_단어수학 {

	static class Word implements Comparable<Word> {
		String s;
		int len;

		public Word(String s, int l) {
			this.s = s;
			this.len = l;
		}

		@Override
		public int compareTo(Word o) {
			return o.len-this.len;
		}
	}

	static int N;
	static ArrayList<Word> list;
	static char[][] arr;
	static int[] alpha;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		list = new ArrayList<Word>();
		alpha = new int[26];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			list.add(new Word(str, str.length()));
		}
		
		Collections.sort(list);
		int len = list.get(0).len;
		arr = new char[N][len];
		
		int k=0;
		for(Word s : list) {
			for(int j=0; j<len; j++) {
				if(j<len-s.len)
					arr[k][j]='-';
				else {
					arr[k][j]=s.s.charAt(j-(len-s.len));
				}
			}
			k++;
		}

		int digit = 9;
		// 세로로 검사 
		for(int i=0; i<len; i++) {
			for(int j=0; j<N; j++) {
				if(Character.isAlphabetic(arr[j][i])) {
					if(alpha[arr[j][i]-'A']==0) {
						alpha[arr[j][i]-'A']=digit;
						digit--;
					}
					//이미 숫자가 들어가있는 것. 
					else
						continue;
				}
				else {
					continue;
				}//end else
			}//end for 
		}
		
		int sum=0;
		// 원래 배열 순회하면서 스트링에 숫자 만들기 
		for(int i=0; i<arr.length; i++) {
			String str = "";
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]=='-')
					continue;
				else {
					str += alpha[arr[i][j]-'A'];
				}
			}//end j for 
			sum += Integer.parseInt(str);
		}
		System.out.println(sum);
	}//end main
}
