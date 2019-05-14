#include <stdio.h>

int main(void) {

    int max = 0, state=0;
    int in[4], out[4];

    for(int i=0; i<=3; i++){
        scanf("%d", &out[i]);
        scanf("%d", &in[i]);

        state -= out[i];
        state += in[i];

        if(max < state){
            max= state;
        }
    }
    printf("%d", max);
    return 0;
}