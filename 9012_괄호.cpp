#include <stdio.h>
#include <vector>
#include <string.h>

using namespace std;

/*
9012_��ȣ


��ȣ ���ڿ�(Parenthesis String, PS)�� �� ���� ��ȣ ��ȣ�� ��(�� �� ��)�� ������ �����Ǿ� �ִ� ���ڿ��̴�.
�� �߿��� ��ȣ�� ����� �ٸ��� ������ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(Valid PS, VPS)�̶�� �θ���.
�� ���� ��ȣ ��ȣ�� �� ��( )�� ���ڿ��� �⺻ VPS �̶�� �θ���. ���� x �� VPS ��� �̰��� �ϳ��� ��ȣ�� ���� ���ο� ���ڿ� ��(x)���� VPS �� �ȴ�.
�׸��� �� VPS x �� y�� ����(concatenation)��Ų ���ο� ���ڿ� xy�� VPS �� �ȴ�.
���� ��� ��(())()���� ��((()))�� �� VPS ������ ��(()(��, ��(())()))�� , �׸��� ��(()�� �� ��� VPS �� �ƴ� ���ڿ��̴�.

�������� �Է����� �־��� ��ȣ ���ڿ��� VPS ���� �ƴ����� �Ǵ��ؼ� �� ����� YES �� NO �� ��Ÿ����� �Ѵ�.

�Է� : �Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �־�����.
�Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����.
�� �׽�Ʈ �������� ù° �ٿ��� ��ȣ ���ڿ��� �� �ٿ� �־�����. �ϳ��� ��ȣ ���ڿ��� ���̴� 2 �̻� 50 �����̴�.

��� : ����� ǥ�� ����� ����Ѵ�.
���� �Է� ��ȣ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(VPS)�̸� ��YES��, �ƴϸ� ��NO���� �� �ٿ� �ϳ��� ���ʴ�� ����ؾ� �Ѵ�.

*/

int check_PS(vector<char> v);

int main()
{
	vector<char> v;

	int num;
	char bk[50], c;


	scanf("%d", &num);	// read the number of line
	for (int i = 0; i < num; i++)
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
	int brk = 0;			// bracket : ��ȣ

	for (int i = 0; i < v.size(); i++)
	{
		if (brk < 0)		// when, brk is to be negative : Don't open and Closed brk.
			return 0;

		if (v.at(i) == ')')
			brk--;
		else
			brk++;
	}

	if (brk > 0 || brk <0)
		return 0;
	else
		return 1;
}