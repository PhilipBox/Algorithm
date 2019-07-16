package studyClass;

import java.util.Scanner;

public class swea_3431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt();
		int time[] = new int[3];
		
		for(int i=0; i<ts; i++) {
			
			for(int j=0; j<3; j++) {
				time[j] = sc.nextInt();
			}// read time
			
			if(time[2]>time[1])
				System.out.println("#"+(i+1)+" -1");
			else if(time[2]>=time[0] && time[2]<time[1])
				System.out.println("#"+(i+1)+" 0");
			else if(time[2]<time[1]) {
				System.out.println("#"+(i+1)+" "+(time[0]-time[2]));
			}
			
		}//end test case loop
		
	}//end main
}//end class
