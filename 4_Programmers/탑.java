package programmers;

import java.util.Arrays;

public class 탑 {

	public static void main(String[] args) {
		
		int[] height = {3,9,9,3,5,7,2};
		System.out.println(Arrays.toString(solution(height)));
		
	}
	
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i =0; i<heights.length; i++) {
        	int receptTop = getReceptTop(heights, i);
        	answer[i]= receptTop;
        }
        return answer;
    }

	private static int getReceptTop(int[] heights, int nowTop) {
		int top= 0;
		int nowTopHeight = heights[nowTop];
		for(int i =nowTop; i>=0; i--) {
			if(heights[i] > nowTopHeight)
				return i+1;
		}
		
		return top;
	}
}
