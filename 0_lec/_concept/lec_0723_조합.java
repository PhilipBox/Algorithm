package day04_0723;

import java.util.Arrays;

public class 조합 {
	public static void main(String[] args) {
		// n개의 원소 중에서 r개를 선택하는 것. nCr
		int[] arr = {1,2,3,4,5};
		int[] sel = new int[2];
		
		comb(arr, sel, 0, 0);
	}
	
	static void comb(int[] arr, int[] sel, int n, int r) {
		//n이 끝까지 가면 더 이상 갈데가 없어서 끝.
		// -> 안버려주면  array outof index가 되니까 버려줘야함.
		if(r == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		//r이 끝까지 가면 다 골라서 끝. 
		//->우리가  찾으려는 것
		if( n == arr.length) 
			return;
			
		//sel의 r위치에 arr의 n번째 요소를 담고,
		sel[r] = arr[n];
		//n과 r이 둘다 증가
		comb(arr,sel, n+1, r+1);
		//n만 증가
		comb(arr, sel, n+1, r);
		
		}
}
