package TableItem.Temp;
//Array-Based Implementation
/**
Name: Jeel Tikiwala
Student ID: 239659420
Assignment 3
Any and all work in this file is my own.*/
public class ArrayBasedTable {
    private TableItem[] items;
    private int size;

    public ArrayBasedTable(int capacity) {
        items = new TableItem[capacity];
        size = 0;
    }

    public void insert(TableItem item) {
        if (size >= items.length) {
            System.out.println("The Table is full, unable to insert in the table.");
            return;
        }
        items[size++] = item;
    }

    public void delete(String key) {
        for (int i = 0; i < size; i++) {
            if (items[i].getKey().equals(key)) {
                items[i] = items[size - 1]; // Move the last item to the deleted spot
                size--;
                return;
            }
        }
        System.out.println("Item not found in the table.");
    }

    public TableItem retrieve(String key) {
        for (int i = 0; i < size; i++) {
            if (items[i].getKey().equals(key)) {
                return items[i];
            }
        }
        return null;
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        ArrayBasedTable table = new ArrayBasedTable(10);
        table.insert(new TableItem("1", "Item1"));
        table.insert(new TableItem("2", "Item2"));

        System.out.println("Retrieving Item1: " + table.retrieve("1"));
        table.delete("1");
        System.out.println("Retrieving Item1 after deletion: " + table.retrieve("1"));
    }
}
