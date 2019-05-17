#include <stdio.h>

int main(void) {

    int num[2000];

    num[0] = num[1] = 1;
    for(int i=1; i<=1000; i++){
        if(!num[i]){
            for(int j=i+i; j<=1000; j+=i){
                if(!num[j])
                    num[j] = 1;
            }
        }
    }

    int n, input, cnt=0;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &input);
        if(num[input]!=1){
            cnt++;
        }
    }

    printf("%d", cnt);

    return 0;
}