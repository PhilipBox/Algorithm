#include <stdio.h>

int main(void) {

    int ans, n, cnt=0;

    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &ans);
        if(ans) cnt++;
    }
    if(cnt<=n/2)
        printf("Junhee is not cute!");
    else
        printf("Junhee is cute!");


    return 0;
}