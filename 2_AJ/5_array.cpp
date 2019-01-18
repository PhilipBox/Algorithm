#include <cstdio>
#include <algorithm>
using namespace std;

/*

 입력 : 5
1 2 4 7 11
3 5 8 12
6 9 13
10 14
15

 */


int main(void)
{

    // 배열 범위 주의하기. 100으로 했을 때 실패함.
    // 입력범위의 최대값까지 입력해보는 습관.
    int num[10000];
    int n, total;

    scanf("%d", &n);
    total = (n*(n+1))/2;

    // 입력받은 n줄만큼 출력될 전체 숫자의 수 배열에 입력
    for(int i =0; i<total; i++){
        num[i] = i+1;
    }

    int a=0, b=1, c=0, j=0;
    for(int i=0; i<n; i++){ //4번의 개행
        c=a;
        for(j=i;j<n;j++) { // 한줄에 출력되는 숫자들
            printf("%d ", num[c+j]);
            c=c+j;
        }
        a = a+b;
        b++;
        printf("\n");

    }
    return 0;
}
