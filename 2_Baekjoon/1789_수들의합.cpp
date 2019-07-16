#include <stdio.h>

int main(void){

    long long int sum;
    long long int num[100000];
    int result;

    scanf("%lld", &sum);


    for(long long  int i=1; i<100000; i++){
        num[i]= i*(i+1)/2;
        if(num[i]>sum){
            result = i-1;
            break;
        }
    }

    printf("%d", result);


    return 0;

}