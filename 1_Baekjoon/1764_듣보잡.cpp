#include <stdio.h>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void){

    int n,m;
    scanf("%d %d", &n, &m);

    vector<string> v;
    vector<string> v_result;


    v.resize(n);
    for(int i=0; i<n; i++){
        cin >> v[i];
    }

    // 오름차순 정렬
    sort(v.begin(), v.end());

    string str;
    for(int i=0; i<m; i++){
        cin >> str;

        if(binary_search(v.begin(), v.end(), str)){
            v_result.push_back(str);
        }
    }

    sort(v_result.begin(), v_result.end());

    printf("%d\n", v_result.size());
    for(int i=0; i<v_result.size(); i++){
        printf("%s\n", v_result[i].c_str());
    }

    return 0;

}