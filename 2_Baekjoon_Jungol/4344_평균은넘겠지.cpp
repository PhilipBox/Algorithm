#include <cstdio>
#include <algorithm>

using namespace std;

int main(void)
{

    int total, n, cnt=0;
    float score[1000];
    float mean=0;

    scanf("%d", &total);
    for(int i=0; i<total; i++){
        scanf("%d", &n);
        for(int j=0; j<n; j++) {
            scanf("%f", &score[j]);
            mean += score[j];
            //printf("%f ", score[j]);
        }
        mean = mean/n;
        //printf("\n평균mean : %.3f\n", mean);

        for(int j=0; j<n; j++) {
            if(mean<score[j]){
                cnt++;
            }
        }

        //printf("\n분모%d 분자%d : %.3lf\n", n, cnt, (double)cnt/(double)n*100);
        printf("%.3lf%%\n", (double)cnt/(double)n*100);
        cnt=0, mean=0;
    }


    return 0;
}