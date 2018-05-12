//#include <stdio.h>
//#include <math.h>
///*
//Baekjoon
//[Problem : 1002 ; 터렛 ]
//이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다.
//조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
//
//조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고,
//조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때,
//류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
//
//#입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성되어있다.
//첫째 줄에 x1, y1, r1, x2, y2, r2가 주어진다. x1, y1, x2, y2는 -10,000보다 크거나 같고,
//10,000보다 작거나 같은 정수이고, r1, r2는 10,000보다 작거나 같은 자연수이다.
//
//#출력
//각 테스트 케이스마다 류재명이 있을 수 있는 위치의 수를 출력한다.
//만약 류재명이 있을 수 있는 위치의 개수가 무한대일 경우에는 -1을 출력한다.
//
//*/
//
//int read_input();
//int estimation_distance();
//
//int a_x, a_y, a_r, b_x, b_y, b_r;
//
//int main()
//{
//	int test_num;
//	int result;
//	scanf("%d", &test_num);
//
//	for (int i = 1; i <= test_num; i++)
//	{
//		read_input();
//		result = estimation_distance();
//		printf("%d\n", result);
//	}
//	return 0;
//}//end main function
//
// /*
// 두 원의 교점을 묻는 문제.
// 마린의 좌표를 묻는 것이 아닌, 위치관계를 묻는 것.
//
// */
//int estimation_distance()
//{
//	//좌표의 위치가 정수더라도, 두 점 사이의 거리는 정수가 아닐 수 있음.
//	double dst = sqrt(double((a_x - b_x) * (a_x - b_x) + (a_y - b_y)*(a_y - b_y)));
//	int sum = a_r + b_r;
//	int min = abs(a_r - b_r); // 큰값 - 작은값 이므로 절대값 해줘야함
//
//							  //원점이 같은 경우 
//	if (a_x == b_x && a_y == b_y)
//	{
//		//두 원이 일치하면
//		if (a_r == b_r)
//			return -1;
//		else
//			return 0;
//	}
//
//	//원점이 다른 경우
//	else
//	{
//		//서로 다른 두 점에서 만나는 경우
//		if (min < dst && dst < sum)
//		{
//			return 2;
//		}
//		// 내접하거나 외접할경우
//		else if (dst == min || dst == sum)
//		{
//			return 1;
//		}
//		else if (dst == 0 || dst > sum || dst < min)
//		{
//			return 0;
//		}
//
//	}//end else 
//
//	return 0;
//}//end estimation_distance function
//
//int read_input()
//{
//	scanf("%d %d %d %d %d %d", &a_x, &a_y, &a_r, &b_x, &b_y, &b_r);
//	return 0;
//}//end read_input function
