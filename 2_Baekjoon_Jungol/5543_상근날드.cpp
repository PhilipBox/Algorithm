#include <stdio.h>

int main(void) {

    int burger[3];
    int bev[2];
    int min=0, set=0;


    for(int i=0; i<3; i++) {
        scanf("%d", &burger[i]);

        if(i==0) min = burger[0];
        else if(min>burger[i]){
            min = burger[i];
        }
    }
    set = min;

    for(int i=0; i<2; i++){
        scanf("%d", &bev[i]);
        if(i==0) min=bev[i];
        else if(min>bev[i]){
            min=bev[i];
        }
    }
    set = set + min - 50;
    printf("%d", set);

    return 0;
}