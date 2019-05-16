#include <stdio.h>

int main(void) {

    int n;
    int rst=1;
    int alpha[10] = {0,};

    for(int i=0; i<3; i++){
        scanf("%d", &n);
        rst *= n;
    }
    while(1){

        alpha[rst%10]++;
        rst = rst/10;

        if(rst<10){
            alpha[rst]++;
            break;
        }
    }//end while loop

    for(int i=0; i<10; i++){
        printf("%d\n", alpha[i]);
    }

    return 0;
}