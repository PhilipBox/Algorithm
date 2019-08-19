package selfStudy;


//에라토스테네스의 체 
public class d3_3131_100만이하의모든소수 {
	final static int N = 1_000_000;
	static boolean[] prime = new boolean[N+1];
	public static void main(String[] args) {
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			//소수면. 
			if(prime[i]==false) {
				int t=2;
				while(true) {
					prime[i*t]=true;
					t++;
					if(i*t>N)
						break;
				}
			}//end if
		}
		for(int i=2; i<=N; i++) {
			if(prime[i]==false)
				System.out.print(i+" ");
		}
	}//end main
}
