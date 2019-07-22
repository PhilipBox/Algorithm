package day03_0722;

import java.util.Scanner;

public class 카운팅정렬 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		int[] arr = new int[8];
		int[] arr = {0,4,1,3,1,2,4,1};
		
		//0. 최대치인 자료를 인덱스로 담을 수 있는 크기의 넉넉한 카운트배열을 준비
		// counts배열을 만들 때, 크기는 arr 값의 가장 최대값+1로 해야한다.
		// e.g. arr의 최대값이 7이면, index 7을 넣어야 하니까 8칸이 필요.
		int[] counts = new int[8];

		//1. 각 자료들의 빈도를 카운트배열에 작성
		// 카운팅 배열에 각 수 counting 추가
		for(int i=0; i<counts.length; i++) {
			counts[arr[i]]++; 
		}
		
		
		//2. 1을 누적합으로 변경
		//카운팅배열 재배열 
		for(int i=1; i<counts.length; i++) {
			counts[i] += counts[i-1];
		}
		// 0 1 2 3 4
		// 1 4 5 6 8 

		
		//3. 원래 자료배열 크기의 배열을 하나 준비 -> 정렬배열이라고 하자.
		int[] temp = new int[arr.length];

		// 정렬 시작
		for(int j=0; j<arr.length; j++) {
//		for(int j=arr.length-1; j>=0; j--) {
			counts[arr[j]]--;
			temp[counts[arr[j]]]=arr[j];
			//한줄로 표현 temp[--counts[arr[j]]]=arr[j];
		}
		
		// 정렬된 결과 출력 (temp)
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		
	}//end main
}
