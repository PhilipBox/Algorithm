
public class 분할정복_거듭제곱 {
	
	public static void main(String[] args) {
		System.out.println(pow(2,11));
		System.out.println(pow2(2,11));
		System.out.println(cnt1);
		System.out.println(cnt2);
	}
	
	
	static int cnt1=0;
	static int cnt2=0;
	//분할정복 적용하지 않은 코드
	static int pow(int a, int b) {
		cnt1++;
		if(b==1)
			return a;
		if(b==0)
			return 1;
		else
			return a * pow(a,b-1);
	}
	
	static int pow2(int a, int b) {
		cnt2++;
		if(b==1)
			return a;
		if(b==0)
			return 1;
		
		int tmp = pow2(a, b/2);
		if(b%2==0) {
			return tmp * tmp;
		}
		else {
			return tmp*tmp*a;
		}
			
	}
	
}
