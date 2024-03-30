package TableItem;
//Binary Search Tree-Based Implementation
/**
Name: Jeel Tikiwala
Student ID: 239659420
Assignment 3
Any and all work in this file is my own.*/
public class CityTableBST {
    private CityNodeBST root;

    public CityTableBST() {
        this.root = null;
    }

    public void insert(City city) {
        root = insertRec(root, city);
    }

    private CityNodeBST insertRec(CityNodeBST root, City city) {
        if (root == null) {
            root = new CityNodeBST(city);
            return root;
        }
        if (city.getName().compareTo(root.city.getName()) < 0) {
            root.left = insertRec(root.left, city);
        } else if (city.getName().compareTo(root.city.getName()) > 0) {
            root.right = insertRec(root.right, city);
        }
        return root;
    }

    public void delete(String name) {
        root = deleteRec(root, name);
    }

    private CityNodeBST deleteRec(CityNodeBST root, String name) {
        if (root == null) return root;
        if (name.compareTo(root.city.getName()) < 0)
            root.left = deleteRec(root.left, name);
        else if (name.compareTo(root.city.getName()) > 0)
            root.right = deleteRec(root.right, name);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.city = minValue(root.right);
            root.right = deleteRec(root.right, root.city.getName());
        }
        return root;
    }

    private City minValue(CityNodeBST root) {
        City minv = root.city;
        while (root.left != null) {
            minv = root.left.city;
            root = root.left;
        }
        return minv;
    }

    public City retrieve(String name) {
        CityNodeBST res = retrieveRec(root, name);
        return res != null ? res.city : null;
    }

    private CityNodeBST retrieveRec(CityNodeBST root, String name) {
        if (root == null || root.city.getName().equals(name))
            return root;
        if (root.city.getName().compareTo(name) > 0)
            return retrieveRec(root.left, name);
        return retrieveRec(root.right, name);
    }

    // Utility method to print the BST in-order (sorted)
    public void printInOrder() {
        printInOrderRec(root);
    }

    private void printInOrderRec(CityNodeBST node) {
        if (node != null) {
            printInOrderRec(node.left);
            System.out.println(node.city);
            printInOrderRec(node.right);
        }
    }
}
