#include <stdio.h>

int main(void) {

    int n, cnt=0, num;

    scanf("%d", &n);
    if(n>10) n %= 10;

    for(int i=0; i<5; i++){
        scanf("%d", &num);
        if(n==num) cnt++;
    }

    printf("%d",cnt);
    
    return 0;
}