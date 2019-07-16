#include <cstdio>
#include <string.h>

#define MAX_SIZE 1001


using namespace std;

// STACK

#define MAX 10
int stack[MAX];
int top;


void stack_init(){
    // stack을 초기화하는 함수
    // stack에 아무 데이터도 없을 때 초기화 해줘야 함.

    top = -1;
} // end stack_init


int stack_push(int pushed_data) {


    if(top >= (MAX-1)){
        printf("\n----- 데이터를 더 이상 추가할 수 없습니다.\n\n");
        return -1;
    }

    top++;
    stack[top] = pushed_data;

    return pushed_data;
} // end stack_push


int stack_pop(){

    int popped_data;

    if(top < 0){
        printf("\n----- 삭제할 데이터가 없습니다.\n\n");
        return -1;
    }

    popped_data = stack[top];
    top--;
    return popped_data;
} // end stack_pop

void stack_print(){

    if(top<0){
        printf("\n----- Stack is empty !\n\n");
    }
    else{
        for(int i=0; i<=top; i++){
            printf("%d ", stack[i]);
        }
        printf("\n\n");
    }

} // end stack_print




int main(void) {
    int choice;

    stack_init();
    while(choice != 4) {

        printf("Select Option\n  1. Push\n  2. Pop\n  3. Print\n  4. EXIT\n");
        scanf("%d", &choice);

        switch (choice){

            case 1 : {
                int data;
                printf("\nEnter the data : ");
                scanf("%d", &data);
                if(stack_push(data) != -1) {
                    printf("----- %d is added.\n\n", data);
                }
                break;
            }

            case 2 : {
                int popped = stack_pop();
                if(popped == -1){
                    break;
                }
                printf("\n----- %d is deleted.\n\n", popped);
                break;
            }

            case 3 : {
                stack_print();
                break;
            }

            case 4 :
                printf("EXIT PROGRAM !\n");
                break;
        }
    }
    return 0;
}

