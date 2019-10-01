import java.util.Scanner;

public class d4_4796_의석이의우뚝선산 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			int up = 0;
			int down =0;
			int result = 0;
			for(int i=0; i<N-1; i++) {
				if(arr[i]<arr[i+1]) {
					if(down==0)
						up++;
					else {
						result += up*down;
						up=0;
						down=0;
					}
				}
				if(arr[i]>arr[i+1]) down++;
			}
			System.out.println(result);
			
		}//end test cases
	}
}

/*
	두번째꺼부터 끝까지 가면서
	
	전에꼐 지금꺼보다작다면 up++
	아니라면 down++;
	
	2 1 4 에서 up이 0이면서 down이 0보다 크면 down을 0으로
	
** up이 없는 down은 무의미.
	
	
	res += up*down하고 나서 
	up 0 down 0 초기화 
	
*/