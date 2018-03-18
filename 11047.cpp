#include <stdio.h>

//Greedy Algorithm

/*
11047_����0
ù° �ٿ� N�� K�� �־�����. (1 �� N �� 10, 1 �� K �� 100,000,000)

��° �ٺ��� N���� �ٿ� ������ ��ġ Ai�� ������������ �־�����. (1 �� Ai �� 1,000,000, A1 = 1, i �� 2�� ��쿡 Ai�� Ai-1�� ���)

��� : ù° �ٿ� K���� ����µ� �ʿ��� ���� ������ �ּҰ��� ����Ѵ�.

*/
void main()
{
	int num, price;			// ������ ����, �ִ� ��ġ
	int coin[10];			// �ִ� 10���� ����
	int total = 0;			

	scanf("%d %d", &num, &price); 
	

	for (int i = 0; i < num; i++)
	{
		scanf("%d", &coin[i]);
	} 

	for (int i = num - 1; i >= 0; i--)
	{
		total = total + price / coin[i];
		price %= coin[i];
	}

	printf("%d", total);

}
