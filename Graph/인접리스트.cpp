#include <cstdio>
#include <vector>

using namespace std;
int main()
{
	int n, m;
	scanf("%d %d", &n, &m);
	vector<vector<int>> a(n + 1);
	for (int i = 0; i < m; i++)
	{
		int u, v;
		scanf("%d %d", &u, &v);
		a[u].push_back(v); a[v].push_back(u);
	}
}