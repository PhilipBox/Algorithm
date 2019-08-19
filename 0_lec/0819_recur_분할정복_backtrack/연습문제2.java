public class 연습문제2 {
	//베이비진 판별
	
	
	public static void main(String[] args) {
		
	}//end main
	
	static void perm(int[] arr, int[] result, boolean[] visited, int k) {
		
		if(k==result.length) {
			//다 고른 것.
			//다 골랐으면 baby-gin 검사를 해야지.
			
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				result[k] = arr[i];
				visited[i] = true;
				perm(arr, result, visited, k+1);
				visited[i] = false;
			}
		}
		
		
	}//end perm
	
}//end class
