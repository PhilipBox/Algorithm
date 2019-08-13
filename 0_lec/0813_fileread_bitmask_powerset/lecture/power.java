package lecture;

public class power {

	
	public static void main(String[] args) {
		
		
	}
	
	
	static int power_of_2(int k) {
		if( k == 0)
			return 1;
		else {
			return 2 * power_of_2(k-1);
		}
	}
}
