#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>



using namespace std;

void insertion(int arr[], int size){
    int key;

    for(int i=1; i<size; i++){
        key = arr[i];
        for(int j=i-1; j>=0; j--){

            if(key<arr[j]){
                arr[j+1] = arr[j];
                arr[j] = key;
            }
        }
    }
}// end insertion sort


void insertion_ex(int arr[], int size) {
    int i,j,temp;

    for(i=0; i<size; i++){
        j=i;
        while(j>0 && arr[j-1]>arr[j]){
            temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
    }
} // end insertion sort
