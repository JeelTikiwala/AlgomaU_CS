package TableItem.Temp;

public class LinkedListBasedTable {
    private Node head;

    private class Node {
        TableItem item;
        Node next;

        Node(TableItem item) {
            this.item = item;
        }
    }

    public void insert(TableItem item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void delete(String key) {
        if (head == null) return;
        if (head.item.getKey().equals(key)) {
            head = head.next;
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.item.getKey().equals(key)) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public TableItem retrieve(String key) {
        Node temp = head;
        while (temp != null) {
            if (temp.item.getKey().equals(key)) {
                return temp.item;
            }
            temp = temp.next;
        }
        return null;
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        LinkedListBasedTable table = new LinkedListBasedTable();
        table.insert(new TableItem("1", "Item1"));
        table.insert(new TableItem("2", "Item2"));

        System.out.println("Retrieving Item1: " + table.retrieve("1"));
        table.delete("1");
        System.out.println("Retrieving Item1 after deletion: " + table.retrieve("1"));
    }
}
