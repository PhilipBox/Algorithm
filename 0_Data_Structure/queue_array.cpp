#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
#include <string.h>

#define MAX_SIZE 1001


using namespace std;

// QUEUE

#define MAX_Q 5
int Que[MAX_Q];
int front, rear;

void queue_init(){
    front = -1;
    rear = -1;

} // end queue_init

int enqueue(int add){
        rear++;
        Que[rear] = add;
        return Que[rear];

} // end enqueue

int dequeue(){
        front++;
        int deleted = Que[front];
        return deleted;
} // end dequeue

int queue_print(){

    if(front == rear ){
        printf("----- Queue is empty !\n\n");
        return -1;
    }
    else{
        for(int i=0; i<=rear; i++){
            printf("%d ", Que[i]);
        }
        return 0;
    }
} // end queue_print


int main(void) {

    int arr[10] = {7,3,5,-1,4,1,55,23,65,4};
    int stack[50] = {1,2,3,4};

    int choice;

    queue_init();

    while(choice != 4) {

        printf("Select Option\n  1. Add\n  2. Delete\n  3. Print\n  4. EXIT\n");
        scanf("%d", &choice);

        switch (choice){

            case 1 : {
                int added;
                printf("Enter the data : ");
                scanf("%d", &added);

                if(rear >= MAX_Q-1) {
                    printf("----- Queue is Full !\n\n");

                }
                else {
                    printf("%d is added.\n\n", enqueue(added));
                }
                break;
            }

            case 2 : {
                if(front == rear){
                    printf("----- Queue is empty !\n\n");
                }
                else {
                    printf("%d is deleted. \n\n", dequeue());
                }
                break;
            }

            case 3 : {
                queue_print();
                break;
            }

            case 4 :
                printf("EXIT PROGRAM !\n");
                break;
        }
    }
    return 0;
}

