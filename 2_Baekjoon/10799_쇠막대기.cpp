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
						//   ' ) ' �� ������ �� ���������� ��������� �˷��ֱ� ����.
			if (s.top() + 1 == i)	// ����������, ������� �������� Ȯ�� 
			{		//�������� ���, ������ ���� �ֱٿ� ���� �ε����� ���� �ݺ����� �����ִ� �ε����� ���ƾ���.
				s.pop();
				ans += s.size();
			}
			else
			{		//������� ������ ���
				s.pop();
				ans++;
			}
		}

	}//end for loop

	printf("%d", ans);

	return 0;
}