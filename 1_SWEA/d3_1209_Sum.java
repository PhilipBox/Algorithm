package studyClass;

import java.util.Scanner;

public class d3_1209_Sum {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int SIZE = 100;
		
		for(int tc=1;  tc<=10; tc++) {
			int T = sc.nextInt();
			int[][] arr = new int[SIZE][SIZE];
			
			for(int i=0; i<SIZE; i++) {
				for(int j=0; j<SIZE; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int sum3=0;
			int sum4=0;
			for(int i=0; i<SIZE; i++){
				int temp3=0;
				int temp4=0;
				for(int j=0; j<SIZE; j++) {
					temp3 += arr[i][j];
					temp4 += arr[j][i];
				}
				if(sum3<temp3)
					sum3=temp3;
				if(sum4<temp4)
					sum4=temp4;
			}
			
			
			
			int temp_result1=0;
			if(sum3>=sum4)
				temp_result1=sum3;
			else
				temp_result1=sum4;
			
			
			
			int sum1 = 0;
			for(int i=0; i<SIZE; i++) {
				sum1+=arr[i][i];
			}
			
			int sum2 = 0;
			int row=0;
			int col=SIZE-1;
			for(int i=0; i<SIZE;i++) {
				sum2 += arr[row][col];
				row++;
				col--;
			}
			
			int temp_result2=0;
			if(sum1>=sum2)
				temp_result2=sum1;
			else
				temp_result2=sum2;
			
			
			if(temp_result1>=temp_result2)
				System.out.println("#"+tc+" "+temp_result1);
			else
				System.out.println("#"+tc+" "+temp_result2);
		}//end test cases
	}//end main
}
