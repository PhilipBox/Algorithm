package heap;

public class MaxHeapTest {
	public static void main(String[] args) {
		
		MaxHeap heap = new MaxHeap();
		
		heap.insert(10);
		heap.insert(15);
		heap.insert(13);
		
		heap.insert(19);
		heap.insert(17);
		heap.insert(25);
		
		heap.delete(2);
		heap.delete(1);
		
		heap.insert(25);
		heap.insert(26);
		heap.insert(27);
		heap.insert(28);
		heap.insert(28);
		heap.insert(28);		
		heap.insert(28);
		heap.insert(28);
		
		heap.delete(1);		
		heap.delete(1);		
		heap.delete(1);		
		System.out.println(heap.toString());
		
		
		
		
		
		
		
		
		
	}//end main
}
