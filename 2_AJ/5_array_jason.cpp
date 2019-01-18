#include <cstdio>
using namespace std;

int arr[101][101];
int main(void)
{
    int n;
    scanf("%d", &n);
    int index = 1;
    int pyramid = 0;
    int count[101] = {0, };

    for(int i = 0;i<n;i++) {
        for(int j = 0;j<n;j++) {
            for(int k=0;k<n;k++) {
                if (j + k == i) {
                    arr[j][k] = index++;
                    if (k == 0)
                        pyramid++;
                }
            }
        }
    }

    for(int i = 0;i<n;i++) {
        for(int j = 0;j<n;j++)
            printf(arr[i][j] != 0?"%d ":"", arr[i][j]);
        puts("");
    }

    return 0;

}