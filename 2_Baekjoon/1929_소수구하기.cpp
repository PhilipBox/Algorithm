#include <stdio.h>

int main(void) {

    int num[2000000];
    int m,n;

    num[0] = num[1] = 1;
    for(int i=2; i<=1000000; i++){
        if(num[i]!=1){
           for(int j=i+i; j<=1000000; j+=i){
                num[j]=1;
           }
        }
    }

    scanf("%d %d", &m, &n);

    for(int i=m; i<=n; i++){
        if(num[i] !=1) {
            printf("%d\n", i);
        }
    }

    return 0;
}