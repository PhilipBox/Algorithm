package day00_study;

import java.util.Scanner;

public class d3_1216_회문2 {
	public static void main(String[] args) {
		int SIZE = 8;
		
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=1; tc++) {
			
			int tt = sc.nextInt();
			char[][] map = new char[SIZE][SIZE];
			
			//map 입력받기
			for(int i=0; i<SIZE; i++) {
				String line = sc.next();
				for(int j=0; j<SIZE; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			int result =1;
			
            for (int num = 100; num > 1; num--) {
                if (result > 1) {
                    break;
                }
                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 100 - num + 1; j++) {
                        int temp = 0;
                        for (int k = 0; k < num / 2; k++) {
                            if (map[i][j + k] != map[i][j + num - k - 1]) {
                                temp = -1;
                            }
                        }
                        if (temp == 0) {
                            result = num;
                        }
                    }
                }
                
                
                // 세로
                for (int i = 0; i < 100 - num + 1; i++) {
                    for (int j = 0; j < 100; j++) {
                        int temp = 0;
                        for (int k = 0; k < num / 2; k++) {
                            if (map[i + k][j] != map[i + num - k - 1][j]) {
                                temp = -1;
                            }
                        }
                        if (temp == 0) {
                            result = num;
                        }

                    }
                }
            }
			
			
			System.out.print("#"+tc+" "+result);
			
			
		}//end test cases
	}//end main
	
}
