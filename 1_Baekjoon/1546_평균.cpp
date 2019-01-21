#include <cstdio>
#include <algorithm>

using namespace std;

int main(void)
{

    int n, MAX;
    float mean=0;
    float score[1000];
    scanf("%d", &n);

    for(int i=0; i<n; i++) {
        scanf("%f", &score[i]);
    }

    MAX = *max_element(score, score+n);

    for(int i=0; i<n; i++){
        score[i] = score[i]/MAX*100;
        mean += score[i];
    }

    printf("%f", mean/n);

    return 0;
}