#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
#include <string.h>


using namespace std;

// CIRQULAR QUEUE

#define MAX_Q 6
int Que[MAX_Q];
int front, rear;

void Cir_queue_init(){
    front = 0;
    rear = 0;

} // end queue_init

int isEmpty(){
    if(front == rear) {
        return 1; // empty
    }
    else {
        return 0; // not empty
    }
} // end isEmpty

int isFull(){
    if((rear+1) % MAX_Q == front) {
        return 1; // full
    }
    else {
        return 0; // not full
    }
} // end isFull

int Cir_enqueue(int add){
    Que[rear] = add;
    rear = (rear + 1) % MAX_Q;
    return add;

} // end enqueue

int Cir_dequeue(){
    int deleted = Que[front];
    front = (front + 1) % MAX_Q;
    return deleted;
} // end dequeue

int queue_print(){

    if(isEmpty()){
        printf("----- Circular Queue is empty !\n\n");
    }
    else {
            int current = front;
            int end = rear;

            while (current != end) {
                printf("%d ", Que[current]);
                current = (current + 1) % MAX_Q;
            }
        }
} // end queue_print


int main(void) {

    int arr[10] = {7,3,5,-1,4,1,55,23,65,4};
    int stack[50] = {1,2,3,4};

    int choice;

    Cir_queue_init();

    while(choice != 4) {

        printf("Select Option\n  1. Add\n  2. Delete\n  3. Print\n  4. EXIT\n");
        scanf("%d", &choice);

        switch (choice){

            case 1 : {
                if(isFull()){
                    printf("----- Circular Queue is Full !\n\n", rear);
                }
                else {
                    int added;
                    printf("Enter the data : ");
                    scanf("%d", &added);
                    printf("%d is added ///rear %d\n\n", Cir_enqueue(added), rear);
                }
                break;
            }

            case 2 : {
                if(isEmpty()){
                    printf("----- Circular Queue is empty !\n\n");
                }
                else {
                    printf("%d is deleted. \n\n", Cir_dequeue());
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

