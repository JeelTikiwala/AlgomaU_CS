/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 9
Any and all work in this file is my own.*/
import java.util.*;

public class PriorityQueueExample {
	//a priority queue
    private PriorityQueue<Integer> priorityQueue;

    //constructor
    public PriorityQueueExample() {
        // Using a custom comparator to ensure the smallest number has the highest priority
        this.priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    }

    //insert elements in the priority queue
    public void insertElements(int[] elements) {
        for (int element : elements) {
            priorityQueue.add(element);
            System.out.println("After inserting " + element + ": ");
            displayHeap();
        }
    }

    //method to delete the priority queue
    public void deleteRootAndHeapSort() {
        while (!priorityQueue.isEmpty()) {
            int removed = priorityQueue.poll();
            System.out.println("After removing root (" + removed + "): ");
            displayHeap();
        }
    }

    //display the heap
    private void displayHeap() {
        System.out.println(priorityQueue);
    }

    
    //main method
    public static void main(String[] args) {
        PriorityQueueExample pq = new PriorityQueueExample();
        int[] elements = {35, 26, 12, 24, 43, 38, 37, 41, 22, 11, 15};
        pq.insertElements(elements);
        System.out.println("Starting heap sort by deleting the root...");
        pq.deleteRootAndHeapSort();
    }
}
