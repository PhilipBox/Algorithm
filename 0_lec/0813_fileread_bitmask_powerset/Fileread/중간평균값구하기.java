package Fileread;

// file read 방식

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class 중간평균값구하기 {
		public static void main(String[] args) throws FileNotFoundException {
			
			System.setIn(new FileInputStream("input.txt"));
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for(int tc=1; tc<=T; tc++) {
				int[] arr = new int[10];
				for(int i=0; i<10; i++) {
					arr[i] = sc.nextInt();
				}
				System.out.println(Arrays.toString(arr));
			}
		}
}
