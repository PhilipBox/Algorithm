#include <stdio.h>
#include <stack>
#include <string.h>

using namespace std;

int main()
{
	char str[600000];
	int n;

	scanf("%s", str);
	scanf("%d", &n);

	stack <char> left;
	stack <char> right;

	int len = strlen(str);
	for (int j = 0; j<len; j++) {
		left.push(str[j]);
	}

	for (int i = 0; i < n; i++)	// n번만큼 명령을 수행
	{
		char cmd;
		scanf(" %c", &cmd);
		if (cmd == 'L')
		{
			if(!left.empty())
			{
			right.push(left.top());
			left.pop();
			}
		}// case 'L'

		else if (cmd == 'D')
		{
			if (!right.empty())		// RIGHT STACK이 비어있지 않다면
			{
				left.push(right.top());
				right.pop();
			}
		}// case 'D'


		else if (cmd == 'B')
		{
			if (!left.empty())		// LEFT STACK가 비어있지 않다면
			{
				left.pop();
			}
		}// case 'B'

		else if (cmd == 'P')
		{
			char added;
			scanf(" %c", &added);
			left.push(added);
		}

	}//end for loop

	while (!left.empty())
	{
		right.push(left.top());
		left.pop();
	}
	
	while (!right.empty())
	{
		printf("%c", right.top());
		right.pop();
	}

	//while (1);
	return 0;
}