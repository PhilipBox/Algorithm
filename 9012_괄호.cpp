#include <stdio.h>
#include <vector>
#include <string.h>

using namespace std;

int check_PS(vector<char> v);

int main()
{
	vector<char> v;

	int num;		// bracket : °ýÈ£
	char bk[50],c;


	scanf("%d", &num);	// read the number of line
	for(int i =0 ; i < num; i++)
	{
		scanf("%s", bk);						// read the PS
		for (int i = 0; i<strlen(bk); i++) {
			v.push_back(bk[i]);
		}										// PS is stored in vector v
		if (v.at(0) == ')')
			printf("NO\n");
		else if (check_PS(v) == 0)
			printf("NO\n");
		else if (check_PS(v) == 1)
			printf("YES\n");
	
		v.clear();
	}
	return 0;
}

int check_PS(vector<char> v)
{
	int brk = 0;

	for (int i = 0; i < v.size(); i++)
	{
		if (brk < 0)		// °ýÈ£°¡ ¿­¸®Áö ¾Ê°í ´ÝÈû.
			return 0;

		if (v.at(i) == ')')
			brk--;
		else
			brk++;
	}//ÇÏ³ªÀÇ ps¸¸Å­ µ¹¾Æ°¨

	if (brk > 0 || brk <0)
		return 0;
	else
		return 1;
}