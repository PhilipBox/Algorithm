import java.util.Scanner;

public class swea_4014_활주로건설 {

	static int N;
	static int X;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt();
			map = new int[N][N];
			for(int i=0; i<N; i++) for(int j=0; j<N; j++) map[i][j] = sc.nextInt();
			
			//확인
			int ans=0;
			for(int i=0; i<N; i++) {
				int dup=1;
				boolean isOK = true;
				boolean down = false;
				for(int j=0; j<N; j++) {
					//마지막 컬럼일 경우
					if(j==N-1) {
						if(down) {
							if(dup<X) break;
						}
						System.out.println(i);
						ans++;
						break;
					}
					//같으면 dup++
					if(map[i][j]==map[i][j+1]) {
						dup++;
						if(dup>= X) isOK = true;
					}
					//다음거가 더 클때
					else if(map[i][j] < map[i][j+1]) {
//						// 위로 올라가는데, 2 이상 차이나면 조건 불만족 
						if(map[i][j+1] - map[i][j] >= 2) break;
						else {
							// 활주로 건설 조건 불만족
							if(dup < X) break;
							
							//만족
							dup=1;
							down = false;
							isOK = true;
						}
					}
					//다음거가 더 작을때
					else {
						// 아래로 내려가는데, 2 이상 차이나면 조건 불만족
						if(map[i][j]-map[i][j+1] >= 2) break;
						else {
							if(isOK) {
								dup = 1;
								down=true;
								isOK = false;	
							}
							else break;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}//end test cases
	}// end main

	static void print() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N;j++) {
				System.out.print(map[i][j] +" ");
			}System.out.println();
		}
	}


}
