#include <iostream>
#include <string.h>
#include <string>
#include <algorithm>

using namespace std;

int main(void){

    string player[150];
    string alpha[26];

    int n, cnt=0, flag=0,num=0;

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> player[i];
    }

    for(int i=0; i<n; i++){
        if(player[i].at(0)=='1')
            continue;
        cnt=1;
        for(int j=i+1; j<n; j++){
            if( player[i][0]== player[j][0]){
                    if(cnt+1==5){
                        alpha[num]=player[j].at(0);
                    }
                    player[j][0]='1';
                    cnt++;
                }
        }
        if(cnt>=5){
            flag=1;
            num++;
        }
    }

    if(flag==0)
        cout << "PREDAJA";
    else{
        sort(alpha, alpha+26);
        for(int i=0; i< 26; i++){
            cout << alpha[i];
        }
    }
    return 0;
}