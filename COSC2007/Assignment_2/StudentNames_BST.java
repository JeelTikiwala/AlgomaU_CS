/**
Name: Jeel Tikiwala
Student ID: 239659420
Assignment 2
Any and all work in this file is my own.*/
import java.util.*;

public class StudentNames_BST {
	
	//node class
	static class Node{
		String data;
		Node left;
		Node right;
		
		Node(String key){
			this.data = key;

		}
	}
	
	//insert method
	public static Node insert(Node root, String key) {
		if(root == null) {
			root = new Node(key);
			return root;
		}
		
		//if key is 
		if(key.compareTo(root.data) < 0) {
			root.left = insert(root.left, key);
		}
		
		else {
			root.right = insert(root.right, key);
		}
		
		return root;
	}
	
	//search method
	public static boolean search(Node root, String studentNames) {
	    if (root == null) {
	        return false;
	    }

	    int comparison = studentNames.compareTo(root.data);

	    if (comparison < 0) {
	        // Search in the left subtree
	        return search(root.left, studentNames);
	    } else if (comparison > 0) {
	        // Search in the right subtree
	        return search(root.right, studentNames);
	    } else {
	        // If root is equal to studentNames
	        return true;
	    }
	}

	
	//delete a node
	public static Node delete(Node root, String studentNames) {
		int comparison = studentNames.compareTo(root.data);
		
		if(comparison < 0) {
			root.left = delete(root.left,studentNames);
		} else if (comparison > 0) {
	        // Search in the right subtree
	        root.right = delete(root.right, studentNames);
	    } else {
	        // we searched and reached at the node 
	    	//Case 1: 1st NO child - leaf node :: delete node and replace with null
	    	if(root.left == null && root.right == null) {
	    		return null;
	    	}
	    	
	    	//Case 2: 2nd One child :: delete node and replace with child node
	    	if(root.left == null) {
	    		return root.right;
	    	}
	    	else if(root.right == null) {
	    		return root.left;
	    	}
	    	
	    	//Case 3: 3rd Two child:: replace value with inorder succesor, delete the node for inorder succesor
	    	Node IS = inorderSuccesssor(root.right);
	    	root.data = IS.data;
	    	root.right = delete(root.right, IS.data);
	    }
		
		return root;
	}
	
	//inorder succesor fucntion
	public static Node inorderSuccesssor(Node root) {
		while(root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	
	
	//inorder traversal = Left, root, right
	public static void inorder(Node root){
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data+ " ");
		inorder(root.right);
	}
	
	//Preorder traversal = root, left, right
	public static void preorder(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.println(root.data+ " ");
		preorder(root.left);
		preorder(root.right);

	}
	
	//postorder traversal = Left, Right, root
	public static void postorder(Node root) {
		if(root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data+ " ");

	}
	
	//main class
	public static void main(String[] args) {
		
		// Q1: Construct a binary search tree
		String studentNames[] = {"Jeel", "Rishit", "Bhakti", "Shubh", "Ashwin", "Shaan", "Diya"}; 
		Node root = null;
		
		//Multiple insert through for loop
		for(int i=0; i<studentNames.length; i++) {
			root = insert(root, studentNames[i]);
		}
		
		
		
		//Q2: Perform the search operation
		String searchName = "Harshil";
		if(search(root, searchName )) {
			System.out.println("The name " + searchName + " is found in the BST.");
		}
		else {
			System.out.println("Not Found in the BST.");
		}
		
		//Space between 2 method
		System.out.println();
		
		//Q3: Delete one leaf node
		root = delete(root,"Shubh");
		
		//Q4: Delete one child node
		root = delete(root,"Shaan");
		
		//Q5: Delete two child node
		root = delete(root,"Bhakti");
		
		//Q6: preorder traversal
		System.out.println("The Pre-order traversal of this BST is: ");
		preorder(root);
		System.out.println();
 
		//Q7: In-order traversal
		System.out.println("The In-order traversal of this BST is: ");
		inorder(root);
		System.out.println();
		
		//Q8: Postorder traversal
		System.out.println("The Post-order traversal of this BST is: ");
		postorder(root);
		System.out.println();
		
		
	}

}
