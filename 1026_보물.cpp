#include <stdio.h>
#define MAX 50

/*
1026_보물

옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.

S = A[0]*B[0] + ... + A[N-1]*B[N-1]

S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.


입력 : 첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다.
N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

출력 : 첫째 줄에 S의 최솟값을 출력한다.

*/
int main() {

	int i, j, testcase, temp, S = 0;

	int arr_A[MAX];
	int arr_B[MAX];

	scanf("%d", &testcase);


	//A-입력 받기
	for (i = 0; i<testcase; i++) {
		scanf("%d", &arr_A[i]);
	}

	//B-입력 받기
	for (i = 0; i<testcase; i++) {
		scanf("%d", &arr_B[i]);
	}

	// bublle sort - arr_A
	for (i = 0; i<testcase; i++) {
		for (j = 0; j<i; j++) {
			if (arr_A[j] < arr_A[i]) {
				temp = arr_A[i];
				arr_A[i] = arr_A[j];
				arr_A[j] = temp;
			}
		}//end 1st for loop using 'j'
	}//end for loop

	 // bubble sort - arr_B
	for (i = 0; i<testcase; i++) {
		for (j = 0; j<i; j++) {
			if (arr_B[j] > arr_B[i]) {
				temp = arr_B[i];
				arr_B[i] = arr_B[j];
				arr_B[j] = temp;
			}
		}//end 1st for loop using 'j'
	}//end for loop


	for (i = 0; i<testcase; i++)
		S += arr_A[i] * arr_B[i];

	printf("%d\n", S);
	return 0;
}
