#include <cstdio>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>



using namespace std;



void selection(int arr[], int size) {
    int min, index, temp;

    for (int i = 0; i < size; i++) {
        min = arr[i];
        for (int j = i; j < size; j++) {
            if (arr[j] <= min) {
                min = arr[j];
                index = j;
            }

        }
        temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }
}
// end selection sort
