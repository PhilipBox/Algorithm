#include <stdio.h>

int main(void) {

    int n, avg=0;
    int score[5];

    for(int i=0; i<5; i++){
        scanf("%d", &n);
        if(n<40){
            n=40;
        }
        score[i] = n;
        avg += n;
    }

    printf("%d", avg/5);

    return 0;
}