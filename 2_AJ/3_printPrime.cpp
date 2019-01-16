#include <cstdio>
using namespace std;


 // n과 m사이의 모든 소수 출력하기

int main (void) {

int n,m;
scanf("%d %d", &n, &m);

for(int i=n; i<=m; i++){
if(i==1){
continue;
}
for(int j=2; j<=i; j++){
if(j==i){
printf("%d ", i);
break;
}

if(i%j == 0){
break;
}
}//end  for loop
}//end for loop
return 0;
}

