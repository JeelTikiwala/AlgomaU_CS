package TableItem.Temp;

public class BSTBasedTable {
    private Node root;

    private class Node {
        TableItem item;
        Node left, right;

        Node(TableItem item) {
            this.item = item;
        }
    }

    public void insert(TableItem item) {
        root = insert(root, item);
    }

    private Node insert(Node node, TableItem item) {
        if (node == null) return new Node(item);
        int cmp = item.getKey().compareTo(node.item.getKey());
        if (cmp < 0) node.left = insert(node.left, item);
        else if (cmp > 0) node.right = insert(node.right, item);
        return node;
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    private Node delete(Node node, String key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.item.getKey());
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public TableItem retrieve(String key) {
        return retrieve(root, key);
    }

    private TableItem retrieve(Node node, String key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.item.getKey());
        if (cmp < 0) return retrieve(node.left, key);
        else if (cmp > 0) return retrieve(node.right, key);
        else return node.item;
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        BSTBasedTable table = new BSTBasedTable();
        table.insert(new TableItem("1", "Item1"));
        table.insert(new TableItem("2", "Item2"));

        System.out.println("Retrieving Item1: " + table.retrieve("1"));
        table.delete("1");
        System.out.println("Retrieving Item1 after deletion: " + table.retrieve("1"));
    }
}
