#include <stdio.h>
#include <vector>
#include <string.h>

using namespace std;

int main()
{
	int t;
	int count = 0;
	scanf("%d", &t);
	for (int i = 0; i < t; i++)
	{
		char ps[50];
		scanf("%s", ps);		// ��ȣ ���ڿ� �Է¹���
		for (int j = 0; j < strlen(ps); j++)
		{

			if (ps[j] == ')')		// �ݴ°�ȣ�϶�
				count--;
			else if(ps[j] == '(')
				count++;		//  ���� ��ȣ�϶�,
			else
			{
				printf("��ȣ�� �ƴմϴ�.\n");
				break;
			}

			if (count < 0)
			{
				printf("NO\n");
				break;
			}
			else if (j == strlen(ps)-1 && count == 0){
				printf("YES\n");
			}
			else if (j == strlen(ps)-1 && count != 0){
				printf("NO\n");
			}
			
		}// �ձ��� �ѱ��ھ����� ����.
		count = 0;
		
	}
	
}