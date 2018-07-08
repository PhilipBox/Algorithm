#include <stdio.h>
#include <vector>
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

	for (int i = 0; i < n; i++) // 괄호 한글자 한글자 순서대로 확인
	{
		if (ps[i] == '(')
			s.push(i);		// 해당 괄호가 여는 괄호이면, 그 인덱스를 스택에 저장.
		else // 닫는괄호일시, 
		{
			if (s.top() + 1 == i) // 가장 바깥쪽에 있는 스택의 '인덱스 +1 '이 i 일때,  
			{ 
				s.pop();				// 스택에 있는 것을 꺼내고
				ans += s.size();	// 꺼내고 난 뒤, 스택의 전체 사이즈만큼 ans에 더한다.
			}
			else
			{
				s.pop();			// 스택에 있는 것을 꺼내고
				ans += 1;		// ans에 1을 더해준다.
			}
		}

	}//end for loop

	printf("%d", ans);

	return 0;
}