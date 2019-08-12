package studyClass;

import java.util.Scanner;

public class d4_1233_사칙연산유효성검사 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++){
			int N = sc.nextInt();
			sc.nextLine();
			char[] tree = new char[N];
			
			for(int i=0; i<N; i++) {
				String str = sc.nextLine();
				String[] arr = str.split(" ");
				//나머지 무시 
				tree[i] = arr[1].charAt(0);
			}
			
			System.out.print("#" + tc + " ");
			for(int j = 0; j< N; j++) {
				// 리프노드는 반드시 숫자여야 함.
				// 여기부터 리프노트 
				if(N/2-1 < j) { 
					// 리프노드에 수식이면 빠끄 
					if(tree[j] == '+' || tree[j] == '-' || tree[j] == '*' || tree[j] =='/')
					{
						System.out.print("0"); break;
					}
					else {
						System.out.print("1"); break;
					}
				}
				// 리프노드가 아니면 
				else if(N/2-1 >= j) {
					//수식어야함ㅇㅇ
					if(tree[j] == '+' || tree[j] == '-' || tree[j] == '*' || tree[j] == '/')
					{}
					//근데 수식 아니면 빠끄 
					else {
						System.out.print("0"); break;
					}
				}
			}
			System.out.println();
		}
	}//end main
}
