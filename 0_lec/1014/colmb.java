import java.util.Arrays;
import java.util.Scanner;

public class colmb {

	
	static int[] arr;
	static boolean[] visited;
	static int cnt =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = i+1;
		
		powerset(arr, 0, new boolean[N]);
		System.out.println(cnt);
	}
	
	static void powerset(int[] arr, int idx, boolean[] sel) {
		if(arr.length == idx) {
			if(cnt>=32) return;
			cnt ++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		sel[idx] = false;
		powerset(arr, idx+1, sel);
		sel[idx] = true;
		powerset(arr, idx+1, sel);
		
	}//end powerset method
	
}
