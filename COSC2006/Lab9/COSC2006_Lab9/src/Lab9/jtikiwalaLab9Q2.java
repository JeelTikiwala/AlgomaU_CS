package Lab9;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 9 Q2: Single Linked list Class
 * Any and All work in this file is my.
 */
public class jtikiwalaLab9Q2 {
    private jtikiwalaLab9Q1 head;

    public jtikiwalaLab9Q2() {
        this.head = null;
    }

    //check if it's empty
    public boolean isEmpty() {
        return head == null;
    }

    
    public void addToEnd(String data) {
    	jtikiwalaLab9Q1 newNode = new jtikiwalaLab9Q1(data);
        if (isEmpty()) {
            head = newNode; //link is empty, new node becomes the head
        } else {
        	jtikiwalaLab9Q1 curr = head;
            while (curr.next != null) {
            	curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public String removeFromFront() {
        if (isEmpty()) {
            throw new QueueException("The linked list is empty so cannot remove from front.");
        }

        String front = head.data;
        //move the head to the next node
        head = head.next;
        return front;
    }

    public jtikiwalaLab9Q1 getHead() {
        return head;
    }

    public void clear() {
        head = null;
    }

    public int size() {
        int count = 0;
        jtikiwalaLab9Q1 curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        jtikiwalaLab9Q1 curr = head;
        while (curr != null) {
            result.append(curr.data);
            if (curr.next != null) {
                result.append(", ");
            }
            curr = curr.next;
        }
        return result.toString();
    }
    
    // custom exception
    class QueueException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public QueueException(String s) {
            super(s);
        }
    }
}
