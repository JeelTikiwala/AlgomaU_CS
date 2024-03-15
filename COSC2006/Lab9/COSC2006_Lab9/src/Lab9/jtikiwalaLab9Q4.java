package Lab9;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 9 Q4: Main Class
 * Any and All work in this file is my.
 */
import Lab9.jtikiwalaLab9Q3.QueueException;

public class jtikiwalaLab9Q4 {

    public static void main(String[] args) {
    	jtikiwalaLab9Q3 queue = new jtikiwalaLab9Q3();

        // (a) add 10 names to the queue, print the queue after every insertion.
        queue.enqueue("Jeel");
        System.out.println("Queue after adding 1st name: " + queue);
        queue.enqueue("Rishit");
        System.out.println("Queue after adding 2nd name: " + queue);
        queue.enqueue("Jenish");
        System.out.println("Queue after adding 3rd name: " + queue);
        queue.enqueue("Sangini");
        System.out.println("Queue after adding 4th name: " + queue);
        queue.enqueue("Drashti");
        System.out.println("Queue after adding 5th name: " + queue);
        queue.enqueue("Bhavesh");
        System.out.println("Queue after adding 6th name: " + queue);
        queue.enqueue("Mary");
        System.out.println("Queue after adding 7th name: " + queue);
        queue.enqueue("Viraj");
        System.out.println("Queue after adding 8th name: " + queue);
        queue.enqueue("Kush");
        System.out.println("Queue after adding 9th name: " + queue);
        queue.enqueue("Ayush");
        System.out.println("Queue after adding 10th name: " + queue);

        // (b) remove names from the queue, print the queue.
        System.out.println();
        queue.dequeue();
        System.out.println("Queue after dequeue 'Jeel': " + queue);
        queue.dequeue();
        System.out.println("Queue after dequeue 'Rishit': " + queue);


        // (c) catch exceptions
        try {
        	
            queue.dequeue();
            
        } catch (QueueException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            e.printStackTrace();

    }
}

}