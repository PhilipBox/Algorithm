#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>



using namespace std;




void bubble(int arr[], int size) {

    int temp;
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size - (i + 1); j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
}// end bubble sort
