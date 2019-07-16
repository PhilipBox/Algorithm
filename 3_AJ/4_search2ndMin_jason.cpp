#include <cstdio>
#include <algorithm>
using namespace std;

int main(void)
{
    int a[9], b[9];
    int minIndex;

    for(int i = 0;i<9;i++) {
        scanf("%d", &a[i]);
        b[i] = a[i];
    }

    sort(a, a+9);
    for(int i = 0;i<9;i++){
        if(b[i] == a[1])
            minIndex = i+1;
    }

    printf("%d\n%d", a[1], minIndex);

    return 0;
}