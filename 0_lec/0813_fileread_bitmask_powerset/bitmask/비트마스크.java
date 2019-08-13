package bitmask;

public class 비트마스크 {
	public static void main(String[] args) {
		
		int[] arr = {1,3,5};
		//원소가 3개이므로, 경우의 수는 2^3가지.
		
		// shift연산은 왼쪽으로가면 2배곱, 오른쪽으로가면 2배나눔
		for(int i=0; i< (1<<arr.length); i++) {
//	1)
			// 저 숫자들의 맨 마지막자리가 0인지 검사.
//			if( (i & 1) != 0 ) {
//				System.out.println(i + " 의 마지막 비트는 0이 아닙니다.");
//			}
			
	
//	2)
			// 마지막이 아니라 마지막에서 두번째 비트가 0이었는지 아닌지 검사하고 싶으면 010이랑 &으로 비비면 되겠다.
			// 010은 0에서 왼쪽으로 한칸 민놈.
			// 1이 001이니까, 얘를 왼쪽으로 한칸밀면 010이 되겠지.\
//			if( (i & (1<<1)) != 0 ) {
//				System.out.println(i + " 의 두번째 비트는 0이 아닙니다.");
//			}
			
//	3)	
			// 마지막에서 세번째 비트가 0이 아닌지 검사하려면, 100이랑 비벼보면 되겠지?
			// 100은 001을 두칸 밀면 되겠지?
//			if( (i & (1<<2)) != 0 ) {
//				System.out.println(i + " 의 세번째 비트는 0이 아닙니다.");
//			}
			
			
// 	그러면 부분집합을 구할수있겠지. 
//			if( (i & (1<<0)) != 0 ) {
//				System.out.print(arr[0]);
//			}
//			
//			if( (i & (1<<1)) != 0 ) {
//				System.out.print(arr[1]);
//			}
//			
//			if( (i & (1<<2)) != 0 ) {
//				System.out.print(arr[2]);
//			}
//			System.out.println();
			
			
// 위에를 또 반복문으로 줄일수있겠지.
			for(int j=0; j<3; j++) {
				if( (i & (1<<j)) != 0 ) {
					System.out.print(arr[j]);
				}
			}
			System.out.println();
			
			
			
		}
	}
}
