package selfStudy;

import java.util.Scanner;

public class d3_1206_view {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=1; tc++) {
			
			int N = sc.nextInt();
			int[] apt = new int[N];
			//건물높이 입력받기 
			for(int i=0; i<N; i++) {
				apt[i] = sc.nextInt();
			}
			int total = 0;
			
			//idx 0, 1 
			//idx N-1, N-2;
			int max = -1;
			if(max<apt[1])
				max=apt[1];
			if(max<apt[2])
				max=apt[2];
			if(apt[0]>max)
				total+= (apt[0]-max);
			
			
			max=-1;
			if(max<apt[0])
				max=apt[0];
			if(max<apt[2])
				max=apt[2];
			if(max<apt[3])
				max=apt[3];
			if(apt[1]>max)
				total += (apt[1]-max);
			
			max = -1;
			if(max<apt[N-2])
				max=apt[N-2];
			if(max<apt[N-3])
				max=apt[N-3];
			if(apt[N-1]>max)
				total+= (apt[N-1]-max);
			
			max=-1;
			if(max<apt[N-1])
				max=apt[N-1];
			if(max<apt[N-3])
				max=apt[N-3];
			if(max<apt[N-4])
				max=apt[N-4];
			if(apt[N-2]>max)
				total += (apt[N-2]-max);
			
			
			for(int i=2; i<N-2; i++) {
				int MAX = findMax(apt, i);
				if(apt[i]>MAX)
					total +=apt[i]-MAX;
			}
			
			System.out.println("#"+tc+" "+total);
		}//end test cases
	}//end main
	
	static int findMax(int[] arr, int idx) {
		
		int MAX=-1;
		if(MAX<arr[idx-2])
			MAX=arr[idx-2];
		if(MAX<arr[idx-1])
			MAX=arr[idx-1];
		if(MAX<arr[idx+1])
			MAX=arr[idx+1];
		if(MAX<arr[idx+2])
			MAX=arr[idx+2];
		
		return  MAX;
	}
}
