#include <iostream>

using namespace std;


int main(void){

    int A,B,C,D,P;

    cin >> A >> B >> C >> D >> P;

    A *= P;
    if(P>C){
        D = B + (P-C)*D;
    }
    else {
        D = B;
    }

    if(A>D){
        cout << D;
    }
    else{
        cout << A;
    }

    return 0;

}