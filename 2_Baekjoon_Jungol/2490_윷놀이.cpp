#include <stdio.h>

int main(void) {

    for(int i=0; i<3; i++){
        int zero=0, bar=0;

        for(int j=0; j<4; j++){
            scanf("%d", &bar);
            if(bar==0){
                zero++;
            }
        }

        if(zero==0) printf("E\n");
        else if(zero==1) printf("A\n");
        else if(zero==2) printf("B\n");
        else if(zero==3) printf("C\n");
        else printf("D\n");
    }

    return 0;
}