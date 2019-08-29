package _solving;

import java.util.Scanner;

public class bj_14888_연산자끼워넣기 {
	
	static int N;
	static int[] arr;
	static int[] operator;
	static int[] oper;
	static boolean[] visited;
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 수의 개수 입력 
		N = sc.nextInt();
		// 초기화
		arr = new int[N];
		operator = new int[4];
		visited = new boolean[N-1];
		
		// 수 입력 
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		// 연산자 입력
		int total=0;
		for(int i=0; i<4; i++) {
			operator[i] = sc.nextInt();
			total += operator[i];
		}
		oper = new int[total];
		
		int k=0;
		for(int i=0; i<4; i++) {
			if(operator[i]==0)
				continue;
			else {
				int j=0;
				while(j<operator[i]) {
				oper[k] = i+1;
				k++;
				j++;
				}
			}
		}//end for
		//연산자를 개수만큼 순서대로 정렬하여 새로운 배열에 저장완료 
		
		perm(new int[N-1], 0);
		System.out.println(MAX);
		System.out.println(MIN);
	}//end main
	
	static void perm(int[] sel, int k) {
		if(k==N-1) {
			//연산자 수를 모두 뽑았을 때.
			int sum=arr[0];
			for(int i=0; i<N-1; i++) {

				if(sel[i]==1)
					sum+=arr[i+1];
				if(sel[i]==2)
					sum-=arr[i+1];
				if(sel[i]==3)
					sum*=arr[i+1];
				if(sel[i]==4)
					sum/=arr[i+1];
			}
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		
		//가지고 있는 모든 연산자 수만큼 돌린다.
		for(int i=0; i<oper.length; i++) {
			//이미 사용한 연산자라면 다음으로
			if(visited[i])
				continue;
			
			visited[i] = true;
			sel[k] = oper[i];
			perm(sel, k+1);
			visited[i]= false;
		}
	}//end perm method
}
