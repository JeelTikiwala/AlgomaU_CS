/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 7*/
class AVL_tree {
	
	//created a node
    public class Node {
        Node left;
        Node right;
        int key;
        int height;
        
        
        //constructor
        Node(int item){
        	key = item;
        	height = 1;
        }
    }
    
    Node root;

    // to get height of the Node = time complexity - O(1)
    int getHeight(Node key) {
        if (key == null) {
            return 0;
        } else {
            return key.height;
        }
    }

    //method to getbalance of tree
    int getBalance(Node key) {
        if (key == null) {
            return 0;
        } else {
            return (getHeight(key.right) - getHeight(key.left));
        }
    }

    //method to update height of the tree
    void updateHeight(Node key) {
        int leftSubtreeHeight = getHeight(key.left);
        int rightSubtreeHeight = getHeight(key.right);

        key.height = Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }

    //rotate left
    Node rotateLeft(Node oldRoot) {
        Node newRoot = oldRoot.right;
        Node temp = newRoot.left;

        newRoot.left = oldRoot;
        oldRoot.right = temp;

        updateHeight(oldRoot);
        updateHeight(newRoot);

        return newRoot;
    }

    //rotate right
    Node rotateRight(Node oldRoot) {
        Node newRoot = oldRoot.left;
        Node temp = newRoot.right;

        newRoot.right = oldRoot;
        oldRoot.left = temp;

        updateHeight(oldRoot);
        updateHeight(newRoot);

        return newRoot;
    }

    
    Node balanceTree(Node root) {
        updateHeight(root);

        int balance = getBalance(root);

        if (balance == 2) {
            if (getBalance(root.right) < 0)
                root.right = rotateRight(root.right);

            return rotateLeft(root);
        }

        if (balance == -2) {
            if (getBalance(root.left) > 0)
                root.left = rotateLeft(root.left);

            return rotateRight(root);
        }

        return root;
    }

    // to insert a node
    Node insertNode(Node root, int key) {
        if (root == null) {
            // Create a new node with the given key
            return new Node(key);
        }

        if (key < root.key) {
            // insert into the left subtree
            root.left = insertNode(root.left, key);
        } else if (key > root.key) {
            // insert into the right subtree
            root.right = insertNode(root.right, key);
        }

        // Return the modified root node
        return balanceTree(root);
    }

    Node findSuccessor(Node root) {
        if (root.left != null) {
            return findSuccessor(root.left);
        } else {
            return root;
        }
    }

    // delete key from AVL
    Node deleteNode(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteNode(root.left, key);
            } 
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } 
        else 
        {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children
            // get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.key);
        }

        return balanceTree(root);
    }

    // node search
    Node search(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
        	//search in left subtree
            return search(root.left, key);
        } else if (key > root.key) {
        	//search in right subtree
            return search(root.right, key);
        } else {
            return root;
        }
    }
    
    // find minimum vaue in tree
    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void preOrder(Node root) {
    	if(root == null) {
    		return;
    	}
    	else {
    		System.out.println(root.key+"");
    		preOrder(root.left);
    		preOrder(root.right);
    	}
    }
    
    //find ascending order
    void inOrder(Node root) {
    	if(root == null) {
    		return;
    	}
    	else {
    		
    		inOrder(root.left);
    		System.out.println(root.key+"");
    		inOrder(root.right);
    	}
    }

public static void main(String[] args) {

    // Create an instance of AVL_tree
    AVL_tree avlTree = new AVL_tree();

    //Q-1 Insert nodes into the tree
    avlTree.root = avlTree.insertNode(avlTree.root, 10);
    avlTree.root = avlTree.insertNode(avlTree.root, 25);
    avlTree.root = avlTree.insertNode(avlTree.root, 34);
    avlTree.root = avlTree.insertNode(avlTree.root, 3);
    avlTree.root = avlTree.insertNode(avlTree.root, 90);
    
    //Q-2: delte node in a tree
    avlTree.root = avlTree.deleteNode(avlTree.root, 25);
    
    //Q-3: find a given interger in tree
    Node searchedNode = avlTree.search(avlTree.root, 25);
    if (searchedNode != null) {
        System.out.println("The Node has been found: " + searchedNode.key);
    } else {
        System.out.println("The Node is not found.");
    }
    
    System.out.println();
    
    //Q-4: 
    int minValue = avlTree.minValue(avlTree.root);
    System.out.println("The Minimum value in the AVL tree is: " + minValue);
    
    System.out.println();

    //q-5: 
    System.out.println("The ascending order of the tree is:");
    avlTree.inOrder(avlTree.root);
    

}
}