package day03_0722;

public class 이차원배열_탐색방법 {
	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		
		int cnt=0;
		for(int i=0; i<arr.length;i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] = cnt;
				cnt++;
			}
		}
		
		//행 우선 순회
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		//열 우선 순회
		for(int i=0;i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[j][i] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		
		// 지그재그 순회
		int m = arr.length;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j+(m-1-2*j)*(i%2)] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}//end main
}
