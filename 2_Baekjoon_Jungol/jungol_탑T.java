package etc;

import java.util.Scanner;
import java.util.Stack;

public class KOI본선_탑T {

	static class Tower{
		int num;
		int height;
	}
	
	public static void main(String[] args) {
		//1. 숫자를 만나면 기억한다.
		//2. 기억시키기전에 검사를 할건데,
		//	최근 기억들부터 되짚어보면서
		//	현재숫자보다 작은 기억은 삭제.
		
		//3. 삭제해나가다보니 기억이 다 사라진다면,
		//	나한테 레이저쏘는애는 없는것.
		//	나보다 큰 놈을 찾는 순간 그 다음기억으로 내가 들어갈거고
		// 나한테 레이저를 쏘는애는 저놈임.
		
		// #숫자만남.
		// 기억을 되짚어봄.
		// 기억이 없어? 그럼 레이저 없어.
		// 기억이 있어?
		// 	최근 기억부터 따라가면서, 나보다 큰놈을 만날때까지 삭제.
		//	나보다 큰 그놈이 레이저쏜놈
		//	기억의 마지막에 날 추가.
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//서서히 결과를 더해가는거는 스트링빌더가 좋아
		StringBuilder sb = new StringBuilder();
		//지금껏 만났던 타워들에 대한 기억정보
		Stack<Tower> memory = new Stack<>();
		int idx=1;
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			
			//기억이 없는건 나한테 레이저 쏠놈이 없는거.
			if(memory.empty())
				sb.append(0).append(" ");
			else {
				//뒤에서부터 앞으로 나가며, 이번에 입력받은 타워보다 작으면 갖다 버려.
				// -> 이게 얼마나 반복될까?
				//		나보다 큰놈을 만나거나 or 스택이 비어지던지.
				
				while(true) {
					if(memory.empty()) {
						sb.append(0).append(" ");
						break;
					}
					else if(memory.peek().height < num) {
						memory.pop();
					}
					else {
						sb.append(memory.peek().num).append(" ");
						break;
					}
				}//end while
			}//end else
			Tower t= new Tower();
			t.num = idx++;
			t.height = num;
			memory.push(t);
		}
		System.out.println(sb.toString());
		//기억을 저장할 공간을 준비해야하는데,
		// 기억에 기록되어야하는 내용! 몇번째놈이고 크기가 몇인지?
		
		// 순서와 크기 두가지정보로 이루어진 자료형을 정의하던가,
	}//end main
}
