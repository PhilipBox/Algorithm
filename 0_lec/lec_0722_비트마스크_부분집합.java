package day03_0722;

public class 비트마스크_부분집합 {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		for(int i=0; i< (1<< arr.length); i++) {
//			System.out.print("###"+Integer.toBinaryString(i));
			// 마지막 3칸에 대해서 검사
			int sum=0;
			for(int j=0; j<arr.length; j++) {
//				마지막에서 j번째 비트가 0인지 검사하는 조건식
				
//				마지막에서 첫번째 비트는 1<<0이랑 i를 비트마스킹하면 뭐가자옴?
				// 마지막에서 두번째 비트 1<<1이랑 i를 비트마스킹하면?

				
				// 마지막에서 첫번째 비트 1 <<0 이랑 i를 비트마스킹하면 뭐가 나옴?
				// 마지막에서 두번째 비트 1<<1 이랑 i를 비트마스킹하면 뭐가 나옴?
//				System.out.print(arr[j] + " ");
				if( ((1<<j)& i) !=0){
					sum+=arr[j];
					System.out.println("i/j  " + i +"," +j);
					System.out.print( " 		   : " +arr[j] + " ");
					System.out.println();
				}
			}
//			System.out.println();
//			System.out.println("sum : " + sum);
		}
	}
}
