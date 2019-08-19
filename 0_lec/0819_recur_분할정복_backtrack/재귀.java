import java.util.Arrays;

public class 재귀 {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
//		powerset(arr, 0, new boolean[arr.length]);
//		combination(arr, new int[2], 0, 0);
//		repPerm(arr, new int[2], 0, 0);
		permutation(arr, new int[2], new boolean[arr.length], 0);
	}
	
	
	// 4. 순열
	// 지금까지 depth가 내려오면서 한번이라도 골랐던 친구는 배제! 
	static void permutation(int[] arr, int[] sel, boolean visited[], int k) {
		//종료 조건이 2가지
		if( k == sel.length) {
			//목적을 만족시킴. 다 고른것!
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=0; i< arr.length; i++) {
			//
			if(visited[i])
				continue;
			
			
			//가기전에 고르고 가고, 고르고 간걸 체크하고 간다.
			sel[k] = arr[i];
			visited[i] = true;
			permutation(arr, sel, visited, k+1);
			visited[i] = false;
		}
	}
	
	
	
	
	// 3. 중복순열
	// 	2.조합과 전반적인 구조는 같지만, 골랐다고 다시 안쳐다보면 안됨!
	static void repPerm(int[] arr, int[] sel, int idx, int k) {
		//종료 조건이 2가지
		if( k == sel.length) {
			//목적을 만족시킴. 다 고른것!
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 사실상 필요없음.
//		// 더이상 검사할게 없어서 종료, 이 기저조건의 위치도 중요. 아래있어야함.
//		if( idx == arr.length)
//			return;
		
		
		for(int i=0; i< arr.length; i++) {
			//각각에 3번 3번 3번을 끼워넣는다.
			sel[k] = arr[i];
			repPerm(arr, sel, idx+1, k+1);
		}
		
		
	}
	
	
	
	
	// 2. 조합
	// sel에는 원소를 고르면 고른 원소를 표시
	// arr에서 idx번째를 검사해서 담겼으면 sel에다가 담자. 라는게 기본 틀.
	// 한번 담아보고, 한번 안담아보고를 반복하면 됨.
	// arr에 idx번째를 sel의 k번째에 담고, 담은걸 유효화 하려면 k를 늘려주고
	// 담은걸 유효화하려면 k를 그대로 가져가면된다. 
	static void combination(int[] arr, int[] sel, int idx, int k) {
		//종료 조건이 2가지
		if( k == sel.length) {
			//목적을 만족시킴. 다 고른것!
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 더이상 검사할게 없어서 종료, 이 기저조건의 위치도 중요. 아래있어야함.
		if( idx == arr.length)
			return;

		sel[k] = arr[idx];
		combination(arr, sel, idx+1, k+1);
		combination(arr, sel, idx+1, k);
	}
	
	
	
	// 1. 부분집합
	static void powerset(int arr[], int idx, boolean[] sel) {
		if(idx==arr.length) {
			for(int i=0; i<arr.length; i++) {
				if(sel[i])
					System.out.print(arr[i] +" ");
			}System.out.println();
			return;
		}

		sel[idx]=true;
		powerset(arr, idx+1, sel);
		sel[idx]=false;
		powerset(arr, idx+1, sel);

			
	}//end powerset
	
	
	//재귀기초
	static void recur(int[] arr, int idx) {
		if(arr.length == idx) {
			return;
		}
		System.out.println(arr[idx]);
		recur(arr, idx+1);
	}
}//end class
