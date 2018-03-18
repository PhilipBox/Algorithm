#include <stdio.h>

//Greedy Algorithm

/*
11047_동전0
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력 : 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최소값을 출력한다.

*/
void main()
{
	int num, price;			// 동전의 개수, 최대 가치
	int coin[10];			// 최대 10개의 동전
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
