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
		scanf("%s", ps);		// 괄호 문자열 입력받음
		for (int j = 0; j < strlen(ps); j++)
		{

			if (ps[j] == ')')		// 닫는괄호일때
				count--;
			else if(ps[j] == '(')
				count++;		//  여는 괄호일때,
			else
			{
				printf("괄호가 아닙니다.\n");
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
			
		}// 앞글자 한글자씩마다 돌아.
		count = 0;
		
	}
	
}