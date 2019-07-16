package day02_0716;

import java.util.Scanner;

//광주 B-2 문지환
public class gravity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Test Cases
//		int[] data = {7,4,2,0,0,6,0,7,0}; // 7
//		int[] data = {7,4,2,0,0,6,0,7,0,0}; // 8
//		int[] data = {9,5,4,9,9,3,2,4,8,6}; //7
//		int[] data = {1,9,3,5,2,0,5,3,4,5}; //8
		
		int len = sc.nextInt();
		int[] data = new int[len];
		
		//상자 입력
		build_data(data);
		
		//낙차 배열 선언
		int[][] diff = new int[100][100];

		for(int i=0; i<data.length-1; i++) {
			for(int j=i; j<data.length-1; j++) {
				int idx = data[i]-data[j+1]; // 3				
				int cnt = 0;
				if(idx>=0) {
					for(int x=idx; x>=1; x--) {
						
						diff[i][data[i]-cnt-1]++;
						cnt++;
					}
				}//end if (idx>=0)
			}//end for loop
		}//end for loop
		
		int max=0;
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<diff[i].length; j++) {
				if(max<diff[i][j])
					max=diff[i][j];
//				System.out.print(diff[i][j]+ " ");
			}
//			System.out.println();
		}//낙차 출력
		
		
		System.out.println("max diff : "+ max);
	}//end main
	
	
	
	static void build_data(int arr[]) {
		Scanner sc = new Scanner(System.in);

		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
	}//end build_data method
}//end class
