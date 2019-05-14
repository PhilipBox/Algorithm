#include <cstdio>

using namespace std;

// 소인수분해 구현
int main(void) {

    int n;
    scanf("%d", &n);


    for(int i=2; n>1;){

        if(n%i == 0){
            printf("%d ", i);
            n /= i;
        }
        else {
            i++;
        }
    }

    return 0;
}