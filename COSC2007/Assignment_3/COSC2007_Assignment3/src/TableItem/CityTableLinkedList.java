package TableItem;
//Reference-Based Implementation (Linked List)
/**
Name: Jeel Tikiwala
Student ID: 239659420
Assignment 3
Any and all work in this file is my own.*/
public class CityTableLinkedList {
    private CityNode head;

    public void insert(City city) {
        CityNode newNode = new CityNode(city);
        if (head == null) {
            head = newNode;
        } else {
            CityNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(String name) {
        if (head == null) return;
        if (head.city.getName().equals(name)) {
            head = head.next;
            return;
        }
        CityNode current = head;
        while (current.next != null) {
            if (current.next.city.getName().equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public City retrieve(String name) {
        CityNode current = head;
        while (current != null) {
            if (current.city.getName().equals(name)) {
                return current.city;
            }
            current = current.next;
        }
        return null;
    }

    // Utility method to print all cities
    public void printCities() {
        CityNode current = head;
        while (current != null) {
            System.out.println(current.city);
            current = current.next;
        }
    }
}
