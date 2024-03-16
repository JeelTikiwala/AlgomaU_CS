/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 8*/
import java.util.ArrayList;

class BTreeNode {
    ArrayList<Integer> keys = new ArrayList<>();
    ArrayList<BTreeNode> children = new ArrayList<>();
    boolean isLeaf;

    BTreeNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}

class BTree {
    private BTreeNode root;
    private int t; // Minimum degree (defines the range for number of keys)

    BTree(int t) {
        this.root = null;
        this.t = t;
    }

    // Display the tree
    public void print() {
        print(root, "", true);
    }

    private void print(BTreeNode node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+- " + node.keys);
            indent += last ? "   " : "|  ";

            for (int i = 0; i < node.children.size(); i++) {
                print(node.children.get(i), indent, i == node.children.size() - 1);
            }
        }
    }
    
    //split the child
    private void splitChild(BTreeNode parent, int i) {
        BTreeNode node = parent.children.get(i);
        BTreeNode newNode = new BTreeNode(node.isLeaf);
        for (int j = 0; j < t - 1; j++) {
            newNode.keys.add(node.keys.remove(t));
        }
        if (!node.isLeaf) {
            for (int j = 0; j < t; j++) {
                newNode.children.add(node.children.remove(t));
            }
        }
        parent.children.add(i + 1, newNode);
        parent.keys.add(i, node.keys.remove(t - 1));
    }

    // Insert a key
    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(true);
            root.keys.add(key);
        } else {
            BTreeNode r = root;
            if (r.keys.size() == 2 * t - 1) {
                BTreeNode s = new BTreeNode(false);
                root = s;
                s.children.add(r);
                splitChild(s, 0);
                insertNonFull(s, key);
            } else {
                insertNonFull(r, key);
            }
        }
    }
    
 // Helper function to insert in a non-full node
    private void insertNonFull(BTreeNode node, int key) {
        int i = node.keys.size() - 1;
        if (node.isLeaf) {
            while (i >= 0 && key < node.keys.get(i)) {
                i--;
            }
            node.keys.add(i + 1, key);
        } else {
            while (i >= 0 && key < node.keys.get(i)) {
                i--;
            }
            i++;
            BTreeNode tmp = node.children.get(i);
            if (tmp.keys.size() == 2 * t - 1) {
                splitChild(node, i);
                if (key > node.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(node.children.get(i), key);
        }
    }


    public int findMinimum() {
        return findMinimum(root);
    }

    private int findMinimum(BTreeNode node) {
        while (!node.isLeaf) {
            node = node.children.get(0);
        }
        return node.keys.get(0);
    }
    
 // Display the integers in ascending order
    public void printInAscendingOrder() {
        printInAscendingOrder(root);
    }

    private void printInAscendingOrder(BTreeNode node) {
        int i;
        for (i = 0; i < node.keys.size(); i++) {
            // If this is not a leaf, then before printing key[i],
            // traverse the subtree rooted with child node.children[i].
            if (!node.isLeaf) {
                printInAscendingOrder(node.children.get(i));
            }
            System.out.print(node.keys.get(i) + " ");
        }

        // Print the subtree rooted with last child
        if (!node.isLeaf) {
            printInAscendingOrder(node.children.get(i));
        }
    }
    
    //delete a node
    public void delete(int key) {
        if (root != null) {
            delete(root, key);

            if (root.keys.isEmpty()) {
                if (!root.isLeaf) {
                    root = root.children.get(0);
                } else {
                    root = null; // Tree is empty now
                }
            }
        }
    }

    private void delete(BTreeNode node, int key) {
        int idx = findKey(node, key);

        if (idx < node.keys.size() && node.keys.get(idx) == key) {
            if (node.isLeaf) {
                node.keys.remove(idx); // Case 1: Key is in leaf node
            } else {
                deleteFromInternalNode(node, idx); // Case 2: Key is in internal node
            }
        } else {
            if (node.isLeaf) {
                System.out.println("The key " + key + " is not present in the tree.");
                return;
            }

            boolean flag = (idx == node.keys.size());

            if (node.children.get(idx).keys.size() < t) {
                fill(node, idx);
            }

            if (flag && idx > node.keys.size()) {
                delete(node.children.get(idx - 1), key);
            } else {
                delete(node.children.get(idx), key);
            }
        }
    }
    
 // Find a key in the B-Tree
    public boolean search(int key) {
        return search(root, key);
    }


    private boolean search(BTreeNode node, int key) {
        int i = 0;

        while (i < node.keys.size() && key > node.keys.get(i)) {
            i++;
        }

        if (i < node.keys.size() && key == node.keys.get(i)) {
            return true;
        }


        if (node.isLeaf) {
            return false;
        }

        // Go to the appropriate child
        return search(node.children.get(i), key);
    }

    // A utility function to find the index of the first key greater than or equal to key
    private int findKey(BTreeNode node, int key) {
        int idx = 0;
        while (idx < node.keys.size() && node.keys.get(idx) < key) {
            ++idx;
        }
        return idx;
    }

    // A function to delete the key present in idx-th position in this node which is an internal node
    private void deleteFromInternalNode(BTreeNode node, int idx) {
        int key = node.keys.get(idx);

        if (node.children.get(idx).keys.size() >= t) {
            BTreeNode pred = node.children.get(idx);
            while (!pred.isLeaf) {
                pred = pred.children.get(pred.keys.size()); // Keep moving to the rightmost node until we find a leaf
            }
            int predKey = pred.keys.get(pred.keys.size() - 1);
            node.keys.set(idx, predKey);
            delete(pred, predKey);
        } else if (node.children.get(idx + 1).keys.size() >= t) {
            BTreeNode succ = node.children.get(idx + 1);
            while (!succ.isLeaf) {
                succ = succ.children.get(0); // Keep moving the leftmost node until we find a leaf
            }
            int succKey = succ.keys.get(0);
            node.keys.set(idx, succKey);
            delete(succ, succKey);
        } else {
            merge(node, idx);
            delete(node.children.get(idx), key);
        }
    }

    // A function to fill child node present in idx-th position in the children[] array if that child has less than t-1 keys
    private void fill(BTreeNode node, int idx) {
        // If the previous child(node.children.get(idx-1)) has more than t-1 keys, borrow a key from that child
        if (idx != 0 && node.children.get(idx - 1).keys.size() >= t) {
            borrowFromPrev(node, idx);
        }
        // If the next child(node.children.get(idx+1)) has more than t-1 keys, borrow a key from that child
        else if (idx != node.keys.size() && node.children.get(idx + 1).keys.size() >= t) {
            borrowFromNext(node, idx);
        }
        // Merge idx-th child of the node with its sibling
        // If idx is the last child, merge it with its previous sibling
        // Otherwise merge it with its next sibling
        else {
            if (idx != node.keys.size()) {
                merge(node, idx);
            } else {
                merge(node, idx - 1);
            }
        }
    }

    // A function to borrow a key from node.children.get(idx-1) and insert it into node.children.get(idx)
    private void borrowFromPrev(BTreeNode node, int idx) {
        BTreeNode child = node.children.get(idx);
        BTreeNode sibling = node.children.get(idx - 1);

        // The last key from sibling goes up to the parent and key[idx-1] from parent is inserted as the first key in child
        child.keys.add(0, node.keys.get(idx - 1));
        if (!child.isLeaf) {
            child.children.add(0, sibling.children.remove(sibling.keys.size()));
        }
        node.keys.set(idx - 1, sibling.keys.remove(sibling.keys.size() - 1));
    }

    // A function to borrow a key from the node.children.get(idx+1) and place it in node.children.get(idx)
    private void borrowFromNext(BTreeNode node, int idx) {
        BTreeNode child = node.children.get(idx);
        BTreeNode sibling = node.children.get(idx + 1);

        // keys[idx] is inserted as the last key in child
        child.keys.add(node.keys.get(idx));
        if (!child.isLeaf) {
            child.children.add(sibling.children.remove(0));
        }
        node.keys.set(idx, sibling.keys.remove(0));
    }

    // A function to merge idx-th child of the node with (idx+1) child of the node
    private void merge(BTreeNode node, int idx) {
        BTreeNode child = node.children.get(idx);
        BTreeNode sibling = node.children.get(idx + 1);

        // Pulling a key from the current node and inserting it into (t-1)th position of node.children.get(idx)
        child.keys.add(node.keys.remove(idx));

        // Copying the keys from node.children.get(idx+1) to node.children.get(idx) at the end
        for (int i = 0; i < sibling.keys.size(); ++i) {
            child.keys.add(sibling.keys.get(i));
        }
        // Copying the child pointers from node.children.get(idx+1) to node.children.get(idx)
        if (!child.isLeaf) {
            for (int i = 0; i <= sibling.children.size(); ++i) {
                child.children.add(sibling.children.get(i));
            }
        }

        // Deleting the child
        node.children.remove(idx + 1);
    }



}

public class BTreeApplication {
    public static void main(String[] args) {
        BTree btree = new BTree(3); // Example with minimum degree 3
        // Insertions
        int[] keysToInsert = {5, 3, 21, 9, 1, 13, 2, 7, 10, 12, 4, 8};
        for (int key : keysToInsert) {
            btree.insert(key);
        }
        

        // Display the BTree structure
        System.out.println("BTree Structure:");
        btree.print();
        
        System.out.println("BTree structure before deletion:");
        btree.print();
        
        System.out.println("\nBTree in ascending order before deletion:");
        btree.printInAscendingOrder();
        
        // Deletions
        int[] keysToDelete = {2, 21, 10, 3};
        for (int key : keysToDelete) {
            System.out.println("\nDeleting key: " + key);
            btree.delete(key);
            System.out.println("BTree structure after deleting " + key + ":");
            btree.print();
        }
        
        // Display the final tree structure
        System.out.println("\nFinal BTree structure after deletions:");
        btree.print();
        // Display in ascending order to verify the deletions
        System.out.println("\nBTree in ascending order after deletions:");
        btree.printInAscendingOrder();

        int[] keysToSearch = {21, 3, 15, 8};
        System.out.println("\nSearching for keys:");
        for (int key : keysToSearch) {
            if (btree.search(key)) {
                System.out.println("Key " + key + " found in the B-Tree.");
            } else {
                System.out.println("Key " + key + " not found in the B-Tree.");
            }
        }
        
        System.out.println();
        
        // Finding minimum
        System.out.println("\nMinimum Value: " + btree.findMinimum());


    }
}
