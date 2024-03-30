public class Main {
    public static void main(String[] args) {
        TwoThreeTree tree = new TwoThreeTree();

        // Example: Insert keys
        for (int i = 10; i <= 100; i += 10) {
            tree.insert(i);
        }

        // Example: Search for a key
        System.out.println("Is 30 in the tree? " + tree.search(30));

        // Deleting a key and more operations can be added here
    }
}
