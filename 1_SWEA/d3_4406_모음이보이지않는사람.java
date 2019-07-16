package studyClass;

import java.util.Scanner;

public class d3_4406_모음이보이지않는사람 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ts = sc.nextInt();
		String collection = "aeiou";
		
		for(int i=1; i<=ts; i++) {
			String arr = sc.next();
			for(int j=0; j<5; j++) {
				arr = arr.replace(String.valueOf(collection.charAt(j)), "");
			}// delete all collection
			System.out.println("#"+i+" "+arr);
		}
	
	}
}
