package algorithm;

import java.util.Arrays;

public class ejik_2w_비밀지도 {


	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46, 33, 33, 22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
		
	}

	static String[] solution(int n, int[] arr1, int[] arr2) {
		String answer[] = new String[n];

		for (int i = 0; i < n; i++) {
			String biToStr1 = "";
			String biToStr2 = "";
			String tmp2 = "";
			String tmp1 = "";

			biToStr1 = Integer.toBinaryString(arr1[i]).toString();
			tmp1 = getZero(n, biToStr1) + biToStr1;				

			biToStr2 = Integer.toBinaryString(arr2[i]).toString();
			tmp2 = getZero(n, biToStr2) + biToStr2;
			
			answer[i] = chkCode(n, tmp1, tmp2);
		}
		return answer;
	}

	
	// 앞에 0을 붙여주는 과정 
	// ex) 11은 1001인데 변의 길이에 맞춰서 01001로 만들어주기 위해서 앞에 0의 개수를 추출
	static String getZero(int N, String str) {
		String zeros = "";
		for (int i = 0; i < N - str.length(); i++) {
			zeros += "0";
		}
		return zeros;
	}

	// 벽을 찾는당
	static String chkCode(int N, String str1, String str2) {
		String ans = "";
		for (int i = 0; i < N; i++) {
			if(str1.charAt(i) == '1' || str2.charAt(i) == '1'){
				ans += "#";
			}
			else {
				ans += " ";
			}
		}
		return ans;
	}

}
