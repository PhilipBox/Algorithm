#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>

#define MAX_SIZE 1001


using namespace std;

int n;
vector<int> adj[MAX_SIZE];
bool visited[MAX_SIZE];

void DFS(int v){
    visited[v]=true;
    printf("%d ", v);

    for(int i=0; i<adj[v].size(); i++){
        int next = adj[v][i];

        if(visited[next]==false){
            DFS(next);
        }
    }
}//end DFS


void BFS(int source) {
    queue<int> que;

    visited[source]=true;
    que.push(source);
    //방문을 했다는 증거로 queue에 넣어줘야한다.

    while(!que.empty()){
        int a = que.front();    que.pop();
        printf("%d ", a);
        for(int i=0; i<adj[a].size(); i++){
            int next = adj[a][i];

            if(visited[next]== false){
                visited[next] = true;
                que.push(next);
            }
        }

    }

}//end BFS

int main(void) {
    int m, s;
    int a, b;

    scanf("%d %d %d", &n, &m, &s);

    for(int i=0; i<m; i++) {
        scanf("%d %d", &a, &b);
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for(int i=1; i<=n; i++){
        sort(adj[i].begin(), adj[i].end());
    }


    memset(visited, false, sizeof(visited)); // 시작, 값, 크기
    DFS(s);

    printf("\n");

    memset(visited, false, sizeof(visited)); // 시작, 값, 크기
    BFS(s);
    // adj.resize(n+1);
    return 0;
}