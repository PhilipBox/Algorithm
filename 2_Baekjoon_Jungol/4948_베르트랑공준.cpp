#include <stdio.h>
#define MAX 300000
int main(void) {
    int num[MAX];
    num[1]=num[0]=1;    //소수가 아닌 것 제외

    for(int i=2; i<MAX; i++){   // 에라토스테네스의 체
        if(!num[i]){
            for(int j=i+i; j<MAX; j+=i){
                num[j]=1;   // 배수들을 제외
            }
        }
    }


    while(1){
        int n, cnt=0;

        scanf("%d", &n);
        if(n==0) break;

        for(int i=n+1; i<=2*n; i++){
            if(!num[i])
                cnt++;
        }
        printf("%d\n", cnt);
    }

    return 0;
}