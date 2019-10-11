import java.util.Scanner;

public class 백준RBY팡 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt(); // 10000
		int[] ball = new int[N];
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			ball[i] = n;
		}
		int max = 0;
		
		//모든 구슬을 탐색하면서.
		for(int i = 0; i < N; i++) {
			//원래 구슬의 색깔을 기억해놨다가
			int origin = ball[i];
			//각 1-3번색으로 바꿔보자.
			for(int j = 1; j < 4; j++) {
				//현재 구슬을 j번 색으로 바꾼 후
				ball[i] = j;
				
				//현재위치부터 왼.오 로 가면서 색이 계속 같은지 보자.
				int result = -1;
				int left = i;
				int right = i;
				while(left >= 0 && right < N && ball[left] == ball[right] ) {
					//현재 공의 색을 기억하고 왼쪽으로 오른쪽으로 가며 같은 색공을 셉니다.
					int color = ball[left];
					int cnt = 0;
					while(left >= 0 && ball[left] == color) {
						cnt++;
						left--;
					}
					while(right < N && ball[right] == color) {
						cnt++;
						right++;
					}
					//4개가 넘었다는건.. 공이 터지는 겁니다.
					if((result >0 &&cnt >= 4) || (result==-1	&& cnt>4) ) {
						result += cnt;
					}
				}
				max = Math.max(max, result);
			}
			ball[i] = origin;
		}
		System.out.println(N-max);
		
	}
}







