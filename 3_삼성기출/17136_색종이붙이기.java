package _solving;

import java.util.Scanner;

public class bj_17136_색종이붙이기 {
	static int[][] origin;
	static int[][] map;
	
	static final int N = 10;
	static int flag=0;
	static int total =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		origin = new int[N][N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				origin[i][j]= sc.nextInt();
			}
		}
		
		map = origin;
		
		for(int i=5; i>0; i--) {
			search(i);
			if(flag==-1) {
				System.out.println("-1");
				return;
			}
		}
		System.out.println(total);
	}//end main

	static boolean check(int r, int c, int k) {
		for(int i=r; i<r+k; i++) {
			for(int j=c; j<c+k; j++) {
				if(map[i][j]!=1)
					return false;
			}
		}
		return true;
	}
	
	static void cover(int r, int c , int k) {
		for(int i=r; i<r+k; i++) {
			for(int j=c; j<c+k; j++) {
				//지워버령
				map[i][j] = k;
			}
		}
	}

	static void search(int N) {
		int papers =5;
		for(int i=0; i<=(10-N); i++) {
			for(int j=0; j<=(10-N); j++) {
				// 색종이가 있으면 5*5검사 
				if(map[i][j]==1) {
					if(check(i,j,N)) {
						if(papers==0) {
							flag=-1;
							return;
						}
						cover(i,j,N);
						total++;
						papers--;
						j+=(N-1);
					}
				}
				else if(N!=1 && map[i][j]==N)
					j+= (map[i][j]-1);
			}
		}
		
	}

	//출력함수 
	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++){
				System.out.print(origin[i][j]+" ");
			}System.out.println();
		}
	}
	
	static void print2() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++){
				System.out.print(map[i][j]+" ");
			}System.out.println();
		}
	}
}
