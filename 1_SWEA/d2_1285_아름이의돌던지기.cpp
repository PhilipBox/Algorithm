//
//  main.cpp
//  algorithm
//
//  Created by philip on 04/08/2019.
//  Copyright © 2019 philip. All rights reserved.
//

#include <iostream>
#include <stdio.h>
#define MAX 100001

int main(int argc, const char * argv[]) {
    
    int T;

    scanf("%d", &T);
    for(int tc=1; tc<=T; tc++){

        int pos[MAX]={0,};
        int N;
        int nearest=100001;
        scanf("%d", &N);
        for(int k=0; k<N; k++){
            int stone;
            //돌 위치
            scanf("%d", &stone);
            
            // 양수 음수 판별
            // 0,양수
            if(stone>=0){
                //제일 가까운 위치 확인
                if(nearest>stone){
                    nearest=stone;
                }
                
                //위치값 +1
                pos[stone]++;
            }
            //음수
            else{
                //양수로
                stone *= -1;
                
                //제일 가까운 위치 확인
                if(nearest>stone){
                    nearest=stone;
                }
                
                //위치값 +1
                pos[stone]++;
            }
        }
        printf("#%d %d %d\n", T, nearest, pos[nearest]);
    }//end tset cases
    
    
    return 0;
}
