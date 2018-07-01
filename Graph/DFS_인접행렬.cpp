void dfs(int x)
{
	check[x] = true;
	printf("%d", x);
	for (int i = 0; i <= n; i++)
	{
		if (a[x][i] = 1 && check[i] == false) {
			dfs(i);
		}
	}
}