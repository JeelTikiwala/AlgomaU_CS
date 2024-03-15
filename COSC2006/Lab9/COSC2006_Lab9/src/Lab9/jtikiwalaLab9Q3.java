package Lab9;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 9 Q3: Queue Class
 * Any and All work in this file is my.
 */
public class jtikiwalaLab9Q3 {
    private jtikiwalaLab9Q2 list;

    public jtikiwalaLab9Q3() {
        this.list = new jtikiwalaLab9Q2();
    }

    //check if queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //add element in the queue
    public void enqueue(String data) {
        list.addToEnd(data);
    }

    //remove element from the queue
    public String dequeue() {
        if (isEmpty()) {
            throw new QueueException("The queue is empty so cannot dequeue.");
        }

        return list.removeFromFront();
    }

    //get element 
    public String peek() {
        if (isEmpty()) {
            throw new QueueException("The queue is empty so cannot peek.");
        }

        return list.getHead().data;
    }

    //remove all
    public void dequeueAll() {
        list.clear();
    }

    //get queue size
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
    
    // Add QueueException class here
    class QueueException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public QueueException(String s) {
            super(s);
        }
    }
}
