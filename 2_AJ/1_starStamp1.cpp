#include <stdio.h>

int main(void)
{

    int n, state;
    scanf("%d", &n);
    state = 1;

    for(int i=0; i<n; i++){
        for(int j=0; j<state; j++){
            printf("*");
        }
        printf("\n");
        state++;
    }

    return 0 ;
}
 
