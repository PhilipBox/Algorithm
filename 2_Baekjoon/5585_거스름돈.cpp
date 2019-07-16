#include <stdio.h>

int main(void){

    int total=0;
    int price;

    scanf("%d", &price);

    price = 1000 - price;

    total = price / 500;
    price -= (price/500)*500;

    total += price / 100;
    price -= (price/100)*100;

    total += price / 50;
    price -= (price/50)*50;

    total += price / 10;
    price -= (price/10) * 10;

    total += price / 5;
    price -= (price/5) *5;

    total += price / 1;

    printf("%d", total);



}