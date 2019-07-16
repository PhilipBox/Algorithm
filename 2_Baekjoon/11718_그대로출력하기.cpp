#include <cstdio>
using namespace std;


/*

입력값에 띄어쓰기가 포함되면 scanf로 받는것이 아니라
getchar나 getline을 이용해서 입력값을 받는다

문제에서 입력값 중에 빈칸이 포함되어 있기 때문에
getchar를 통해 입력을 받고

문장의 끝이 오게되면 (EOF = End of File)
break 를 통해 빠져 반복문을 빠져나가고

EOF가 오기전에는
getchar를 통해 한글자씩 입력 받은값을
putchar를 통해 한글자씩 출력 해준다.

 * */
int main(void)
{

    int a;

    while(1) {

        a = getchar();

        if(a==EOF)
            break;

        putchar(a);
    }

    return 0;
}