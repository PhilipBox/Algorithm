#include <stdio.h>
#include <string.h>
#include <stack>

using namespace std;

int main()
{
	char ps[100000];

	scanf("%s", ps);
	int n = strlen(ps);
	int ans = 0;

	stack <int> s;

	for (int i = 0; i < n; i++)
	{
		if (ps[i] == '(')
		{
			s.push(i);
		}
		else {
						//   ' ) ' 이 나왔을 때 레이저인지 막대기인지 알려주기 위함.
			if (s.top() + 1 == i)	// 레이저인지, 막대기의 종점인지 확인 
			{		//레이져일 경우, 스택의 가장 최근에 들어온 인덱스와 현재 반복문을 돌고있는 인덱스와 같아야함.
				s.pop();
				ans += s.size();
			}
			else
			{		//막대기의 종점일 경우
				s.pop();
				ans++;
			}
		}

	}//end for loop

	printf("%d", ans);

	return 0;
}