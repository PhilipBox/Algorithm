
#include <stdio.h>
#define MAX 2000

int main(void){

    int num[MAX];
    int cnt = 0 ,n, k, rst;

    scanf("%d %d", &n, &k);

    for(int i=2; i<=n; i++) {
        if(num[i] != 1){
            cnt++;
            num[i]=1;
            if(cnt == k){
                rst = i;
                break;
            }
        }
        for(int j=i+i; j<=n; j+=i){
            if(num[j] != 1) {
                cnt++;
                num[j]=1;
                if(cnt == k){
                    rst = j;
                    break;
                }
            }
        }
        if(cnt == k){
            break;
        }
    }

    printf("%d", rst);
}