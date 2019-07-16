/*
별찍기
   *
  ***
 *****

 #include <stdio.h>

int main(void)
{
    int n, state, space;
    scanf("%d", &n);
    space = n-1;
    state=1;

    for(int i=0; i<n; i++) {
        for (int j = 0; j < space; j++) {
            printf(" ");
        }
        for (int j = 0; j < state * 2 - 1; j++) {
            printf("*");
        }
        printf("\n");
        space--;
        state++;
    }
    return 0 ;
}



 * */

