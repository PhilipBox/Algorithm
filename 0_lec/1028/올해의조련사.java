import java.util.Arrays;
import java.util.Scanner;

public class 올해의조련사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				arr[i] = s.charAt(0);
			}
			char[] newline = new char[N];

			int front = 0;
			int tail = arr.length - 1;

			int left = 0;
			int right = arr.length - 1;

			int cnt=0;
			while(true) {
				if(arr[front] < arr[tail]) {
					newline[cnt++] = arr[front++];
					left=front;
				}
				else if(arr[front] > arr[tail]) {
					newline[cnt++] = arr[tail--];
					right=tail;
				}
				// 같으면
				else if(arr[front]==arr[tail]){
					while(true) {
						left++;
						right--;
						//서로 교차되어 넘어감
						if(left>=right || right<=left) break;
						//알파벳이 서로 같지 않을 때.
						if(arr[left] != arr[front])break;
					}
					if(arr[left] < arr[right]) {
						newline[cnt++] = arr[front++];
						left=front;
					}
					else if(arr[left] > arr[right]) {
						newline[cnt++] = arr[tail--];
						right=tail;
					}
					
				}
				
				if(front > tail || tail < front) break;
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<arr.length; i++) {
				System.out.print(newline[i]);
			}System.out.println();
		} // end test cases
	}// end main
}
