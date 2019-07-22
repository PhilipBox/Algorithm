package day02_0716;

import java.util.Arrays;
import java.util.Scanner;

public class baby_gin_game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		int[] arr = {1,2,3,4,5,6};
		int[] arr = new int[6];
		
		int[] counts = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			counts[arr[i]]++;
		}
		
	
		
		for(int i=0; i<counts.length; i++) {
			System.out.println(i+"# " + counts[i] + " ");
		}
		
		//트리플 확인 및 제거
		//트리플2개있을수도있음.
		
		//남은거에서 런 확인
		
		//트리플 1차확인
		
		//트리플 2개
		if(Triplet(counts)==2) {
			System.out.println("Baby-gin");
		}
		else if(Triplet(counts)==1) {
			
			for(int i=0; i<10; i++) {
				if(counts[i]>=3) {
					counts[i] = counts[i]-3;
					break;
				}// 트리플 제거 후 바로 break
			}
			
			if(Run(counts)==1)
				System.out.println("Baby-gin");
			else
				System.out.println("아닙니다.");
			//남은거 Run 확인
		}
		else {
			// Run 2개가 있어야함.
			if(doubleRun(arr)==1)
				System.out.println("Baby-gin");
			else
				System.out.println("아닙니다");
		}
		
		
		
		

//		완전탐색 때 사용할 메소드	
//		if ( isBabygin(arr))
//			System.out.println("Babygin입니다.");
//		else
//			System.out.println("아닙니다.");

	}//end main
	
	
	
	static int Triplet(int[] arr) {
		int count=0;
		for(int i=0; i<10; i++) {
			if(arr[i]>=3) {
				count=1;
			}
			else if(arr[i]>=3)
				count=2;
			else
				count=0;
		}
		return count;
	}//end Triplet method for greedy
	
	
	static int Run(int[] arr) {
		int result=0;
		for(int i=0; i<8; i++) {
			if(arr[i] ==1) {
				if( (arr[i]==arr[i+1]) && (arr[i+1]==arr[i+2])) {
					result = 1;
					break;
				}
				else
					result = 0;

			}
			

		}
		return result;
	}//end Run method for greedy
	
	
	static int doubleRun(int[] arr) {
		int result=0;		
		for(int i=0; i<10; i++) {
			if(arr[i]==2) {
				if( (arr[i]==2) && (arr[i+1]==2) &&(arr[i+2]==2)) {
					result = 1;
					break;
				}
				else
					result = 0;
			}
			else if(arr[i]==1){
				arr[i]--;
				arr[i+1]--;
				arr[i+2]--;
				if(Run(arr)==1)
					result=1;
				else
					result=0;
			}

		}
		return result;
	}
//	
//	
//	static boolean isBabygin(int [] arr) {
//		//순서 섞지말고, 현재 상태 그대로 앞 세장, 뒤 세장을 검사
//		int[] front = Arrays.copyOfRange(arr, 0, 3);
//		int[] back = Arrays.copyOfRange(arr, 3, 6);
//		
//		//front가 triplet or run인지,
//		//back이 triplet or run인지.
//		//위 두개가 다 맞는지의 결과를 return true or false겠지.
//		
//		return (isTriplet(front) || isRun(front) && (isTriplet(back) || isRun(back)));
//	}//end isBabygin method
//	
//	static boolean isTriplet(int[] arr) {
//		//세칸짜리 배열을 받아서 해당 배열이 트리플릿인지 검사
//		if(arr[0] == arr[1] && arr[1] == arr[2])
//			return true;
//		else
//			return false;
//	}//end isTriplet method
//	
//	static boolean isRun(int[] arr) {
//		//세칸짜리 배열을 받아서 해당 배열이 런인지 검사
//		
//		if(arr[0]+1 == arr[1] && arr[0]+2 == arr[2])
//			return true;
//		else
//			return false;
//	}//end isRun method
//	
//	
//	
//	
	
	
	
	
	
	
	
}//end class
