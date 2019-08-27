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

	for (int i = 0; i < n; i++) // ��ȣ �ѱ��� �ѱ��� ������� Ȯ��
	{
		if (ps[i] == '(')
			s.push(i);		// �ش� ��ȣ�� ���� ��ȣ�̸�, �� �ε����� ���ÿ� ����.
		else // �ݴ°�ȣ�Ͻ�, 
		{
			if (s.top() + 1 == i) // ���� �ٱ��ʿ� �ִ� ������ '�ε��� +1 '�� i �϶�,  
			{ 
				s.pop();				// ���ÿ� �ִ� ���� ������
				ans += s.size();	// ������ �� ��, ������ ��ü �����ŭ ans�� ���Ѵ�.
			}
			else
			{
				s.pop();			// ���ÿ� �ִ� ���� ������
				ans += 1;		// ans�� 1�� �����ش�.
			}
		}

	}//end for loop

	printf("%d", ans);

	return 0;
}