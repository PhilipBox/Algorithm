#include <cstdio>
#include <algorithm>

using namespace std;

int main(void)
{

    int n;
    scanf("%d", &n);

    int ten,one, var,temp, cnt=1;

    if(n<10){
        n= n*10;
    } //  10보다 작을 경우, 두자리 수로.
    temp = n;

    while(1){
        ten = temp/10;
        one = temp%10;

        var = ten+one;
        if(var>9) {
            var = var%10;
        }
        temp = (one*10)+var;
        //printf("temp값 변화 : %d\n", temp);
        if(temp==n){
            break;
        }
        cnt++;
    }

    printf("%d", cnt);

    return 0;
}