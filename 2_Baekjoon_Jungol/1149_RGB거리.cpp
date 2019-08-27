#include <stdio.h>
#define MIN(a,b) (a<b?a:b)

/*
1149_RGB거리

RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 
집 i의 이웃은 집 i-1과 집 i+1이다. 처음 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때, 
모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력 : 첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다.
둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.



출력 : 첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

*/

int main() {

	int cost[1000][3];
	int dp[1000][3];

	int n, min = 0;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%d %d %d", &cost[i][0], &cost[i][1], &cost[i][2]);
	}//end for loop
	dp[0][0] = cost[0][0];
	dp[0][1] = cost[0][1];
	dp[0][2] = cost[0][2];

	for (int i = 1; i < n; i++)
	{
		dp[i][0] = MIN(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
		dp[i][1] = MIN(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
		dp[i][2] = MIN(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
	}

	min = dp[n - 1][0];
	if (dp[n - 1][1] < min)
		min = dp[n - 1][1];
	if (dp[n - 1][2] < min)
		min = dp[n - 1][2];

	printf("%d", min);

	return 1;
}//end main function