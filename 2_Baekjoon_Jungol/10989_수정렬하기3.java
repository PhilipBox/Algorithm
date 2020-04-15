package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수 정렬하기3
public class bj_10989 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[100001];
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			num[tmp]++;
		}
		
		for(int i=0; i< num.length; i++) {
			if(num[i]==0)
				continue;
			for(int j=0; j<num[i]; j++) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
