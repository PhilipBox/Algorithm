#include <stdio.h>
#include <string.h>
#include <queue>

using namespace std;

/*
10845_ť


������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.

�Է� : ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����.
�־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

��� : ����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.

*/


void push(int input);
int pop();
int size();
int empty();
int front();
int back();

queue <int> q;

int main()
{
	int num;
	scanf("%d", &num);

	for (int i = 0; i < num; i++)
	{
		char menu[10];
		scanf("%s", menu);

		if (strcmp(menu, "push") == 0)
		{
			int input;
			scanf("%d", &input);
			push(input);
		}
		else if (strcmp(menu, "pop") == 0)
		{
			printf("%d\n", pop());
		}
		else if (strcmp(menu, "size") == 0)
		{
			printf("%d\n", size());
		}
		else if (strcmp(menu, "empty") == 0)
		{
			printf("%d\n", empty());
		}
		else if (strcmp(menu, "front") == 0)
		{
			printf("%d\n", front());
		}
		else if (strcmp(menu, "back") == 0)
		{
			printf("%d\n", back());
		}

	}//end for loop


	return 0;
}


void push(int num)
{
	q.push(num);
}

int pop()
{
	if (q.empty() == 1)
		return -1;
	else{
		int popped = q.front();
		q.pop();
		return popped;
	}
}

int size()
{
	return q.size();
}

int empty()
{
	if (q.empty() == 1)
		return 1;
	else
		return 0;
}


int front()
{
	if (q.empty() == 1)
		return -1;
	else
		return q.front();
}

int back()
{
	if (q.empty() == 1)
		return -1;
	else
		return q.back();

}
