package _solving;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal_T {
	static String src = "7 11\n"
			+"0 1 31\n"
			+"0 2 31\n"
			+"0 6 31\n"
			+"0 5 60\n"
			+"1 2 21\n"
			+"2 4 46\n"
			+"2 6 25\n"
			+"3 4 34\n"
			+"4 6 51\n"
			+"5 3 18\n"
			+"5 4 40\n";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] edges = new int[E][3];
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			edges[i][0] = a;
			edges[i][1] = b;
			edges[i][2] = c;
		}
		// edges배열을 2번칸의 크기순으로 오름차순 정렬 
		
		
		
	}
	
}
