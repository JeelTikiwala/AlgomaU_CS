
/*Name: Jeel Tikiwala
Student ID: 239659420
Assignment 4
Any and all work in this file is my own.*/
public class TwoThreeTree {
    private Node root;

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node splitNode = insert(root, key);
            if (splitNode != null) {
                Node newRoot = new Node(splitNode.keys[0]);
                newRoot.children[0] = root;
                newRoot.children[1] = splitNode;
                root = newRoot;
            }
        }
    }

    private Node insert(Node node, int key) {
        // Insert logic with node splitting
        // Placeholder for simplicity
        return null;
    }

    public boolean search(int key) {
        Node node = root;
        while (node != null) {
            // Simplified search logic
            return true; // Placeholder
        }
        return false;
    }

    public void delete(int key) {
        delete(root, key);
        // Placeholder for deletion logic
    }

    private void delete(Node node, int key) {
        // Simplified delete logic for a leaf node
        // Placeholder
    }

    // Main method for demonstration
    public static void main(String[] args) {
        TwoThreeTree tree = new TwoThreeTree();
        // Demonstrate insertions
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }

        // Demonstrate search
        boolean found = tree.search(5);
        System.out.println("Search for 5: " + found);

        // Demonstrate deletion
        tree.delete(5);
        found = tree.search(5);
        System.out.println("Search for 5 after deletion: " + found);
    }
}
