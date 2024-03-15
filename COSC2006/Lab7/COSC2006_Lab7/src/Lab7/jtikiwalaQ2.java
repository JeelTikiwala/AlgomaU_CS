
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 7 Q2: Single Linked list class
 * Any and All work in this file is my.
 **/

package Lab7;

public class jtikiwalaQ2 {
	
	
	//head node set to null
    protected jtikiwalaQ1 head = null;

    
    //public boolean isEmpty(); - check if the list is empty or not.
    public boolean isEmpty() {
        return head == null;
    }
    
    
    // public int size(); - check size
    public int size() {
        int count = 0;
        jtikiwalaQ1 current = head;
        while (current != null) {
            count++;
            current = current.nextNode;
        }
        return count;
    }
    
    

    // public void insert(String item); - insert item into list 
    public void insert(String item) {
        
        if (head == null) {
            head = new jtikiwalaQ1(item);
        }
        
        else if (head.item.compareTo(item) > 0) {
            head = new jtikiwalaQ1(item, head);
        }
        
        else {
        	jtikiwalaQ1 current = head;
            while (current.nextNode != null && item.compareTo(current.nextNode.item) >0) {
                current = current.nextNode;
            }
            
            current.nextNode = new jtikiwalaQ1(item, current.nextNode);
        }
    }

    // public void removeAll(); - Remove all item from the list
    public void removeAll() {
        head = null;
    }

    // public String remove(int i); - remove item at certain index
    public String remove(int i) throws CustomException {
        String remItem;
        
        if (isEmpty()) {
            throw new CustomException("Error: Empty List");
        }
        
        if (i < 0 || i >= size()) {
            throw new CustomException("Error: Invalid Index: IndexOutOfBound Exception");
        }
        
        if (i == 0) {
        	remItem = head.item;
            head = head.nextNode;
        }
        
        else {
        	jtikiwalaQ1 curp = head;
            for (int j = 0; j < i - 1; j++) {
                curp = curp.nextNode;

            }
            remItem = curp.nextNode.item;
            curp.nextNode = curp.nextNode.nextNode;
        }
        return remItem;
    }


    //public String get(int i); -  get item at given index
    public String get(int i) throws CustomException {
        if (isEmpty()) {
            throw new CustomException("Error: Empty List");
        }
        if (i < 0 || i >= size()) {
            throw new CustomException("Error: Invalid Index: IndexOutOfBound Exception");
        } else {
        	jtikiwalaQ1 curp = head;
            for (int j = 0; j < i - 1; j++) {
                curp = curp.nextNode;

            }
            return curp.item;
        }
    }

    //public int find(String item) - find item at given index
    public int find(String item) {
        int curIndex= 0;

        jtikiwalaQ1 curp = head;

        while (curp != null) {
            if (curp.item.equals(item)) {
                return curIndex;
            }
            curIndex++;
            curp = curp.nextNode;

        }
        return -1;
    }

    
    //toString Method
    @Override
    public String toString() {
        StringBuilder bd = new StringBuilder();
        jtikiwalaQ1 curp = head;
        while (curp != null) {
        	bd.append(curp.item);
            if (curp.nextNode != null) {
            	bd.append(" -> ");
            }
            curp = curp.nextNode;
        }
        bd.append(" -> null");
        return bd.toString();
    }
}

// Custom Exception Class
class CustomException extends Exception {
    private static final long serialVersionUID = 1L;

    public CustomException(String message) {
        super(message);
    }
}