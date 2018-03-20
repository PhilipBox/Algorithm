#include <stdio.h>
#define MAX 50

/*
1026_����

���� ������ ������ �׻� ū ��ĩ�Ÿ����� ���� �־���. �� ������ ���� �������� ������ ���� ������ ���� ū ����� �ɾ���.

���̰� N�� ���� �迭 A�� B�� �ִ�. ������ ���� �Լ� S�� ��������.

S = A[0]*B[0] + ... + A[N-1]*B[N-1]

S�� ���� ���� �۰� ����� ���� A�� ���� ��迭����. ��, B�� �ִ� ���� ��迭�ϸ� �ȵȴ�.

S�� �ּڰ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.


�Է� : ù° �ٿ� N�� �־�����. ��° �ٿ��� A�� �ִ� N���� ���� ������� �־�����, ��° �ٿ��� B�� �ִ� ���� ������� �־�����.
N�� 50���� �۰ų� ���� �ڿ����̰�, A�� B�� �� ���Ҵ� 100���� �۰ų� ���� ���� �ƴ� �����̴�.

��� : ù° �ٿ� S�� �ּڰ��� ����Ѵ�.

*/
int main() {

	int i, j, testcase, temp, S = 0;

	int arr_A[MAX];
	int arr_B[MAX];

	scanf("%d", &testcase);


	//A-�Է� �ޱ�
	for (i = 0; i<testcase; i++) {
		scanf("%d", &arr_A[i]);
	}

	//B-�Է� �ޱ�
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
