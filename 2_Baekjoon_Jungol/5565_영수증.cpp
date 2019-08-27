#include <stdio.h>

int main(void) {

    int price[10];
    int total=0;

    for(int i=0; i<10; i++){
        scanf("%d", &price[i]);
        if(i!=0) total += price[i];
    }

    printf("%d", price[0]-total);

    return 0;
}