package studyClass;

import java.util.LinkedList;
import java.util.Scanner;

public class d3_1230_암호문3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		
		for(int ts=1; ts<=10; ts++) {
			
			LinkedList<String> list = new LinkedList<String>();
			
			//암호문의 길이 입력 
			int text_len = sc.nextInt();
			
			//원본 암호문 입력 
			for(int i=0; i<text_len; i++) {
				String input = sc.next();
				list.add(input);
			}
			
			//명령어의 개수 입력 
			int cmd_nums = sc.nextInt();
			String cmd;
			for(int i=0; i<cmd_nums; i++) {
				cmd = sc.next();
				if(cmd.charAt(0) == 'I') {
					int pos = sc.nextInt();
					int num = sc.nextInt();
					String[] insert_list = new String[num];
					for(int j=0; j<num; j++) {
						insert_list[j] = sc.next();
						list.add(pos+j, insert_list[j]);
					}				
				}
				else if(cmd.charAt(0) == 'D') {
					int pos = sc.nextInt();
					int num = sc.nextInt();
					for(int j=0; j<num; j++) {
						list.remove(pos);
					}
				}
				else if(cmd.charAt(0) == 'A'){
					int num = sc.nextInt();
					for(int j=0; j<num; j++) {
						String input = new String();
						input = sc.next();
						list.add(input);
					}
				}
			}//end cmd
			System.out.print("#"+ts);
			for(int x=0; x<10; x++) {
				System.out.print(" " + list.get(x));
			}
			System.out.println();
		}//end 10 test cases

		
		
		
	}//end main
}
