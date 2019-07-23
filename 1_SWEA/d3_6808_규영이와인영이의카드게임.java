package day04_0723;

import java.util.Scanner;

public class d3_6808_규영이와인영이의카드게임 {
	static int N =0;
	static int Win=0;
	static int Lose=0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int ts=1; ts<=T; ts++) {
			N=0;
			Win=0;
			Lose=0;
			int[] alpha = new int[9];
			int[] beta = new int[9];
			boolean[] card = new boolean[19];
			// 규영이 카드 입력 받기
			for(int i=0; i<alpha.length; i++) {
				alpha[i] = sc.nextInt();
				card[alpha[i]]=true;
			}
			
	
			// 인영이 카드 배열에 입력
			int j=0;
			for(int i=1; i<=18; i++) {
				if(card[i]==false) {
					beta[j]=i;
					j++;
				}
			}
		
			//규영이 카드 확인
//			System.out.println("규영:" + Arrays.toString(alpha));
			//인영이 카드 확인
//			System.out.println("인영:" + Arrays.toString(beta));
			
			perm(alpha,beta, 0);
			System.out.println("#"+ts+" "+Win+" "+Lose);
		}//end test cases
	}//end main
	
	
	static void perm(int[] alpha, int[] arr, int idx) {
		if(idx==arr.length) {
//			System.out.println(Arrays.toString(arr));
			if(compute_score(alpha, arr)==1)
				Win++;
			else if(compute_score(alpha, arr)==2)
				Lose++;
			N++;
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			swap(arr, i, idx);
			perm(alpha, arr, idx+1);
			swap(arr, i, idx);
		}
	}
	
	static void swap(int[] arr, int a, int b) {
		int tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}//end swap method
	
	static int compute_score(int[] arr1, int[] arr2) {
		int score1 =0;
		int score2 =0;
		for(int i=0; i<9; i++) {
			if(arr1[i]>arr2[i])
				score1 += (arr1[i]+arr2[i]);
			else
				score2 += (arr1[i]+arr2[i]);
		}
		
		if(score1>score2)
			return 1;
		else if(score1<score2)
			return 2;
		else
			return 0;
	}//end compute_score method
}
