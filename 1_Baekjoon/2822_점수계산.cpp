#include <iostream>
#include <algorithm>
#include <functional>

using namespace std;


int main(void){

    int score[8];
    int score2[8];
    int total=0;


    for(int i=0; i<8; i++){
        scanf("%d", &score[i]);
        score2[i] = score[i];
    }

    sort(score, score +8, greater<int>());
    for(int i=0; i<5; i++){
        total += score[i];
    }

    printf("%d\n", total);
    for(int i=0;i<8; i++){
        for(int j=0;j<5;j++){
            if(score2[i]==score[j]) {
                printf("%d ", i+1);
                break;
            }
        }
    }


    return 0;

}