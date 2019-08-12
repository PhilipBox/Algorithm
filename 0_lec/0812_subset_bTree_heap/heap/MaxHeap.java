package heap;

public class MaxHeap {

	Node[] arr = new Node[100];
	int idx =0;
	
	public void insert(int data) {
		Node node = new Node(data);
		arr[++idx] = node;
		
		if(idx>1) {
			checkParent(idx);
		}
		
	}
	
	public void checkParent(int idx) {
		if(idx==1 || (arr[idx].data<arr[idx/2].data))
			return;
		
		//부모의 idx는 현재 idx의 절반
		if(arr[idx].data > arr[idx/2].data) {
			int tmp = arr[idx].data;
			arr[idx].data = arr[idx/2].data;
			arr[idx/2].data = tmp;
			
			checkParent(idx/2);
		}
	}//end 
	
	public void delete(int d_idx) {
		// 꼬다리를 지워진놈에 넣고, null하고 idx--;
		
		if(d_idx>idx) {
			System.err.println("범위 초과야");
			return;
		}
		arr[d_idx].data = arr[idx].data;
		arr[idx] = null;
		idx--;
		
		
		
		// 위로가자!
		if(d_idx!=1 && arr[d_idx].data>arr[d_idx/2].data) {
			checkParent(d_idx);
		}
		// 아래랑 비교하자
		else {
			if(idx == d_idx) {
				arr[idx]=null;
				return;
			}
			checkChild(d_idx);
		}
	}//end delete
	
	public void checkChild(int idx) {
		// 새로운 꼬다리가 들어온 idx
		
		//오른쪽에 노드가 있다는 거니까 좌우 모두 비교
		if(this.idx < idx*2) return;
		if(arr[idx*2+1]!=null) {
			if(arr[idx*2].data > arr[idx*2+1].data) {
				if(arr[idx*2].data > arr[idx].data) {
					int tmp = arr[idx*2].data;
					arr[idx*2].data = arr[idx].data;
					arr[idx].data = tmp;
						checkChild(idx*2);
				}
				else {
					return;
				}
			}
			else {
				if(arr[idx*2+1].data > arr[idx].data) {
					int tmp = arr[idx*2+1].data;
					arr[idx*2+1].data = arr[idx].data;
					arr[idx].data = tmp;
						checkChild(idx*2);
				}
				else {
					return;
				}
			}
		}
		//좌측에만 노드가 있다는 거니까 좌측만 비교
		else {
			if(this.idx < idx*2) return;
			
			if(arr[idx*2].data > arr[idx].data) {
				int tmp = arr[idx*2].data;
				arr[idx*2].data = arr[idx].data;
				arr[idx].data = tmp;
			}
				checkChild(idx*2);
		}
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=idx; i++) {
			sb.append(arr[i].data).append(" ");
		}
		return sb.toString();
	}
	
	
}
