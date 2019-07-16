#include <cstdio>
using namespace std;

int main(void)
{

    int month_day[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int month, date, day;
    int total=0;

    scanf("%d %d", &month, &date);

    for(int i=0; i<month-1; i++){
        total += month_day[i];

    }
    total += date;
    day = total%7;


    switch(day){

        case 0 : printf("SUN");
        break;

        case 1 : printf("MON");
        break;

        case 2 : printf("TUE");
        break;

        case 3 : printf("WED");
        break;

        case 4 : printf("THU");
        break;

        case 5 : printf("FRI");
        break;

        case 6 : printf("SAT");
        break;
    }

    return 0;
}