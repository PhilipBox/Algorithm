package Programmers;

import java.util.ArrayList;

public class 모의고사 {

	public static void main(String[] args) {

	}

	public static int[] solution(int[] answers) {
		int[] cnt = new int[3];
		int[] first_arr = { 1, 2, 3, 4, 5 };
		int[] second_arr = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] third_arr = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		
		for (int i = 0; i < answers.length; i++) {
			if(first_arr[i%5]==answers[i])
				cnt[0]++;
			if(second_arr[i%8]==answers[i])
				cnt[1]++;
			if(third_arr[i%10]==answers[i])
				cnt[2]++;
		}
		
		int max = cnt[0];
		for(int i=1; i<3; i++) {
			max = Math.max(max, cnt[i]);
		}

		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<3; i++) {
			if(max==cnt[i])
				arr.add(i);
		}
		
		int[] answer = new int[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			answer[i] = arr.get(i)+1;
		}
		
		return answer;
	}
}
