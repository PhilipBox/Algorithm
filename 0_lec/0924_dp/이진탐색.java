import java.util.Arrays;

public class 이진탐색 {
	public static void main(String[] args) {
		int[] arr = { 1,3,4,6,7,9};
		int left =0;
		int right = arr.length -1;
		int target = 9;
	
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] > target)
				right = mid - 1;
			else
				left = mid +1;
		}
		System.out.println(right);
		
	}

	//[s,e)사이에서 v[i]>k가 처음되는 i값 리턴
	static int bs(int[] arr , int s, int e,int k){
	  int m;	
	  while(s<e){             //[m,e)
	    m = (s+e)/2;
	    if(k >= arr[m]) s=m+1;  //[m+1,e)
	    else e=m;	          //[s,m)	
	  }	
	  return e;
	}

}
