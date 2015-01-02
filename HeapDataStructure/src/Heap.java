import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Heap<T extends Comparable<T>> {

	//accepts generic type.
	
	private List<T> arrayList;
	
	public Heap() {
		
		arrayList = new ArrayList<T>();
	}
	
	//swap method
	public void swap(int index1, int index2) {
		T temp = arrayList.get(index1);
		arrayList.set(index1, arrayList.get(index2));
		arrayList.set(index2, temp);
	}
	
	//insert
	public void insert(T item) {
		arrayList.add(item);
		upHeap();
	}
	
	public void upHeap() {
		int k = arrayList.size() - 1;
		
		//loop while k is not root
		while(k > 0) {
			
			int p = (k-1) / 2;
			T kValue = arrayList.get(k);
			T pValue = arrayList.get(p);
			
			if(kValue.compareTo(pValue) > 0) {
				swap(k, p);
				k = p;
			} else {
				break;
			}
			
		}
	}
	
	//delete
	public void delete() {
		if(arrayList.isEmpty()) {
			throw new NoSuchElementException("Heap is empty");
		} else {
			T newPriority = arrayList.get(arrayList.size()-1);
			arrayList.set(0, newPriority);
			arrayList.remove(arrayList.size()-1);
			downHeap();
		}
	}
	
    private void downHeap() {
        
    	int k = 0; //index of replaced node; starting index; focus index
        
        int leftChild = 2*k+1; //formula to grab the left child
        
        //while left child is still in the array
        while (leftChild < arrayList.size()) {
        	
            int max = leftChild; //preset max to left child
            int rightChild = leftChild + 1; //get index of rightChild
            
            if (rightChild < arrayList.size()) { // is there is a right child
            	
                //compare the right and left child to see which one is greater
            	if (arrayList.get(rightChild).compareTo(arrayList.get(leftChild)) > 0) {
                    max = rightChild; //if right child is greater then we will compare against that.
                }
            }
            
            //compare against the max of both children
            if (arrayList.get(k).compareTo(arrayList.get(max)) < 0) {
            		swap(k, max); //if k is less than the max child node then swap
            		k = max; //change the focus index to the max child node index
            		leftChild = 2*k+1; //find the new focus indexes left child node
            } else {
                break;
            }
        }
    }
    
    public void printHeap() {
    	System.out.print(arrayList);
    }
}
