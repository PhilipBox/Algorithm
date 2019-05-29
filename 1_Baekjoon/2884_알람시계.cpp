#include <stdio.h>

int main(void){

    int h,m;
    int r;

    scanf("%d %d", &h, &m);

    r = m-45;

    if(r>=0){
        printf("%d %d", h,r);
    }
    else{
        h -= 1;
        m = 60 + r; // r is negative integer
        if(h<0){
            h=23;
        }
        printf("%d %d", h, m);
    }

    return 0;

}