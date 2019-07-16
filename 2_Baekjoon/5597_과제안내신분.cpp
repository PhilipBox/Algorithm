#include <stdio.h>

int main(void){

    int student[30] ={0,};

    for(int i=0; i<28; i++){
        int n;
        scanf("%d", &n);
        student[n-1] = 1;
    }

    int cnt=0;
    for(int i=0; i<30; i++){
        if(student[i]==0){
            printf("%d\n", i+1);
            cnt++;
        }
        if(cnt==2)
            break;
    }


    return 0;

}