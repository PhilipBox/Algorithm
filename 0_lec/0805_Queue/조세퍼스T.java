package day07_0805;

import java.util.LinkedList;
import java.util.Queue;

public class 조세퍼스T {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<arr.length; i++)
			queue.add(arr[i]);
		
		StringBuilder sb= new StringBuilder();
		int cnt =0;
		
		while(!queue.isEmpty()) {
			//큐에서 하나 꺼낸다.
			int num = queue.poll();
			//쿵쿵따 중 쿵 일때는 다시 큐에 넣고
			if(cnt!=3-1) {
				queue.add(num);
				cnt++;
			}
			//쿵쿵따 중 따 일때는 sb출력에 내보낸다.
			else {
				sb.append(num);
				cnt=0;
			}
		}
		System.out.println(sb.toString());
		
	}//end main
}
