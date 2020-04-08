package programmers;

import java.util.Arrays;

public class K번째수 {
	public static void main(String[] args) {

		int[] arr = { 1,5,2,6,3,7,4};
		int[][] cmd = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }};
		int[] answer = new int[3];
		answer = solution(arr, cmd);
		
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int ans_idx = 0;
		for(int i=0; i<commands.length; i++) {
			int[] tmp = new int[commands[i][1]-commands[i][0]+1];
			int idx =0;
			for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
				tmp[idx++] = array[j];
			}
			Arrays.sort(tmp);
			answer[ans_idx++] = tmp[commands[i][2]-1];
		}
		return answer;
	}
}
