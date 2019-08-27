#include <stdio.h>

int main(void){

    int n;
    int board[101][101];
    int result=0;

    scanf("%d", &n);

    while(n!=0){
        int x,y;
        scanf("%d %d", &x, &y);

        for(int i=x; i<x+10; i++){
            for(int j=y; j<y+10; j++){
                if(board[i][j]!=1){
                    board[i][j] = 1;
                    result++;
                }
            }
        }
        n--;
    }

    printf("%d", result);

    return 0;

}