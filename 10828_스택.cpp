#include <stdio.h>
#include <string.h>
#define SIZE 10000

/*
10828_����

������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� �ټ� �����̴�.

push X: ���� X�� ���ÿ� �ִ� �����̴�.
pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.


�Է� : ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. 
�־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

��� : ����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.
*/


int front = -1, rear = -1;
int stack[SIZE];

void push(int input);
int pop();
int size();
int empty();
int top();

int main()
{
	int num;
	scanf("%d", &num);


	for (int i = 0; i < num; i++)
	{
		char menu[10];
		int input;
		scanf("%s", menu);

		if (strcmp(menu, "push") == 0)
		{
			scanf("%d", &input);
			push(input);
		}
		else if (strcmp(menu, "pop") == 0)
			printf("%d\n", pop());
		else if (strcmp(menu, "size") == 0)
			printf("%d\n", size());
		else if (strcmp(menu, "empty") == 0)
			printf("%d\n", empty());
		else if (strcmp(menu, "top") == 0)
			printf("%d\n", top());
	}
	return 0;
}

void push(int num)
{
	if (front == -1)
		rear++;
	front++;
	stack[front] = num;
}

int pop()
{

	if (rear == -1)
		return -1;
	if (front == 0)
		rear--;
	front--;


	return stack[front+1];
}

int size()
{
	if (front == -1)
		return 0;
	else
		return front + 1;
}

int empty()
{
	if (rear == -1)
		return 1;
	else
		return 0;
}

int top()
{
	if (front != -1)
		return stack[front];
	else
		return -1;
}