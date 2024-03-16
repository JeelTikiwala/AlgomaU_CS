import java.util.*;
/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 6*/
public class BST_int {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;

		}
	}
	
	//insertion method
	public static Node insert(Node root, int key) {
		//if root is null
		if(root == null) {
			root = new Node(key);
			return root;
		}
		
		//to insert left
		if(root.data > key) {
			//left subtree
			root.left = insert(root.left, key);
		}
		
		//to insert right
		else {
			root.right = insert(root.right, key);
		}
		
		return root;
	}
	
	//search method
	public static boolean search(Node root, int key) {
	    if (root == null) {
	        return false;
	    }
	    if(root.data > key) {
	    	// Search in the left subtree
	    	return search(root.left, key);
	    }
	    else if (root.data < key){
	    	// Search in the right subtree
	    	return search(root.right, key);
	    }
	    else {
	    	// If root is equal
	    	return true;
	    }
	    
	}
	
	//delete method
	public static Node delete(Node root, int key) {
		if(root.data > key) {
			root.left = delete(root.left, key);
		}
		else if(root.data < key) {
			root.right = delete(root.right, key);
		}
		else {
			//root.data == key
			// case 1: 
			if(root.left == null && root.right == null) {
				return null;
			}
			
			//case 2:
			if(root.left == null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			
			//case 3
			Node IS = inordersuccessor(root.right);
			root.data = IS.data;
			root.right = delete(root, IS.data);
		}
		
		return root;
	}
	
	public static Node inordersuccessor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		
		return root;

	}
	
    // Method to find minimum value in the BST
    public static int findMinValue(Node root) {

        // Loop down to find the leftmost leaf
        while (root.left != null) {
            root = root.left;
        }
        return (root.data);
    }


	
	//inorder traversal == ascending order
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data+"");
		inorder(root.right);
		
	}
	public static void main(String[] args) {
		int values[] = {20,56,76,89,99};
		Node root  = null;

		//1-insertion
		for(int i=0; i<values.length; i++) {
			root = insert(root, values[i]);
		}
		System.out.println("Q1: The BST is:");
		inorder(root);
		System.out.println();
		
		//2-deletion of elements
		System.out.println("Q2: The element that has been removed from the BST: ");
		delete(root,56);
		inorder(root);
		System.out.println();
		
		//3- searching 
		System.out.println("Q3: To search the element in ths BST: ");
		if(search(root,56)) {
			System.out.println("The element is found");
		}
		else{
			System.out.println("The element is not found");
		}
		
		//4-find minmun element in BST
		System.out.println();
		System.out.println("Q4: The minimum value in the BST is " + findMinValue(root));
		
		//5- asecing order
		System.out.println();
		System.out.println("Q5: The order of tree in ascending is:");
		inorder(root);
		
	}

}
