import java.util.Scanner;

public class HeapDataStructure {

	public static void main(String args[]) {
		
		Heap<Integer> heap = new Heap<Integer>();
		
		Scanner sc = new Scanner(System.in);
		
	    System.out.print("Number of entries: ");
	    int count = sc.nextInt();
	        
        for(int i = 0; i<count; i++) {
        	int number = sc.nextInt();
        	heap.insert(number);
        	heap.printHeap();
        }
        
        heap.delete();
        heap.printHeap();
        
        sc.close();
	}
	
	public void sort(Heap heap) {
		
	}
}