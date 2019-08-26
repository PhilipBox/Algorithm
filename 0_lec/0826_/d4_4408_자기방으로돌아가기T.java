package _solving;

import java.util.Scanner;

// 통로를 한칸한칸 연결된 배열로 생각해보자면,
// 가장 많이 밟혀지는 통로의 칸...의 밟혀지는 수가 답.

// 각 홀짝이 마주보고 있으니까 , 홀수를 늘리던가or짝수를줄이던가 했을 때.
// 그 번호가 해당 방들의 통로 번호.

// 1 3 5 
// 2 4 6

// 홀수를 하나 늘려서 
// 1>2 , 3>4 , 5>6

// 1번에서 6번가면 밟아야 되는 통로는 2,4,6
// 1번에서 4번가면 밟아야 되는 통로는 2,4
// 3번에서 4버가면 밟아야되는 통로는 4

// 위 세개가 조건이라면 답은 4가 3개니까 3.

public class d4_4408_자기방으로돌아가기T {
	static int[] map = new int[401];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < map.length; i++)
				map[i] = 0;
			
			int N = sc.nextInt();
			for(int n=0; n<N; n++) {
				
				int from = sc.nextInt();
				int to = sc.nextInt();
				if(from%2 == 1)
					from++;
				if(to%2 ==1)
					to++;
				
				// 반대방향으로 가는 친구
				if(from > to) {
					int tmp = from;
					from = to;
					to = tmp;
				}
				
				for(int i=from; i<=to; i+=2) {
					map[i]++;
				}
			}

			int max=0;
			for(int i= 2; i<=400; i+=2) {
				max = Math.max(max, map[i]);
			}
			System.out.println("#"+tc+" "+max);
		} // end test cases

	}
}
