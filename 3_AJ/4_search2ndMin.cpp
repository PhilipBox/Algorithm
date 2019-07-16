#include <cstdio>
using namespace std;

int main (void) {

    /*

     9개의 서로 다른 수가 주어질 떄, 이 중 두번째 최소값을 찾고, 이 값이 몇번째에 위치해 있는지.

     */

    int num[9], origin[9];
    int pos=0, temp;

    for(int i=0; i<9; i++) {
        scanf("%d", &num[i]);
        origin[i] = num[i];
    }


    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9-(i+1); j++) {
            if (num[j] > num[j+1]) {
                temp = num[j+1];
                num[j+1] = num[j];
                num[j] = temp;
            }
        }
    } //bubble sort


    for(int i=0; i<9; i++){
        if(num[1]==origin[i])
            printf("%d\n%d", num[1], i+1);
    }

    return 0;
}