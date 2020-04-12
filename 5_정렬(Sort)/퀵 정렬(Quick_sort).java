package 정렬;

import java.util.Arrays;

public class Quick_sort {

	public static void main(String[] args) {
		int[] arr = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };

		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int start, int end) {
		if (start >= end) { // 원소가 1개인 경우
			return;
		}

		int key = start; // key : 첫번째 원소
		int i = start + 1; // 왼쪽 출발지점
		int j = end; // 오른쪽 출발지점
		int temp = 0; // 위치를 바꾸기 위한 임시 변수

		while (i <= j) { // 엇갈릴 때까지 반복
			while (i <= end && arr[i] <= arr[key]) { // key값보다 큰 값을 만날 때까지 오른쪽으로 이동.
				i++;
			}

			while (j > start && arr[j] >= arr[key] ) { // key값보다 작은 값을 만날 때까지 왼쪽으로 이동.
				j--;
			}

			if (i > j) { // 현재 엇갈린 상태면 키 값과 교체
				temp = arr[j];
				arr[j] = arr[key];
				arr[key] = temp;
			} else { // 엇갈리지 않았다면 큰값과 작은값을 바꿔준다.
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		// 정렬이 끝난지점 기준으로 좌/우로 재귀 실행. - 분할
		quickSort(arr, start, j - 1);
		quickSort(arr, j + 1, end);
	}

}
