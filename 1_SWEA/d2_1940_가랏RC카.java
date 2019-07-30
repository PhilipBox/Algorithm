package studyClass;

import java.util.Scanner;

public class d2_1940_가랏RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int distance=0;
			int current_speed=0;
			
			int cmd=0;
			int speed=0;
			for(int i=0; i<N; i++) {
				cmd = sc.nextInt();
				
				if(cmd!=0) {
				speed = sc.nextInt();
				}
				
				if(cmd==1) {
					current_speed += speed;
				}
				else if(cmd==2) {
					if(current_speed<speed) {
						current_speed = 0;
					}
					else
						current_speed = current_speed - speed;
					
				}
				else if(cmd==0) {
					
				}
				distance += current_speed;
			}
		
			System.out.println("#"+tc+" "+distance);
			
			
		}//end main
	}//end main
	
	
}
