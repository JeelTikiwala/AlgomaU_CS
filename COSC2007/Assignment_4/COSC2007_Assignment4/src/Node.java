class Node {
    int[] keys = new int[2];
    Node[] children = new Node[3];
    int numKeys = 0;

    // Node constructor
    Node(int key) {
        keys[0] = key;
        numKeys = 1;
    }

    // Checks if node is leaf
    boolean isLeaf() {
        return children[0] == null;
    }

    // Insert key into this node
    void insertInNode(int key) {
        if (key < keys[0]) {
            keys[1] = keys[0];
            keys[0] = key;
        } else {
            keys[1] = key;
        }
        numKeys++;
    }
}
