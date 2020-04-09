package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수 {

	public static void main(String[] args) {

		int[] num = { 3, 30, 34, 5, 9 };
		System.out.println(solution(num));
	}

	public static String solution(int[] numbers) {
		String ans = "";

		String[] arr = new String[numbers.length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (String.valueOf(numbers[i]));
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);
			}
		});
		
		// 0000처럼 0으로만 이루어져 있다면 0만 return
		// 첫 번째 자리가 0인거므로 전체가 0임.
		if(arr[0].equals("0")) return "0";
		
		// 그렇지 않다면 순차적으로 모두 연결이 가능함.
		for(int i=0; i<arr.length; i++) {
			ans += arr[i];
		}
		return ans;
	}

}
