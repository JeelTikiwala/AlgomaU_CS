import java.util.*;
/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 5*/
public class BST_239659420 {
	
	//node class
	static class Node{
		String data;
		Node left; //left child
		Node right; //right child
		
		Node(String data){
			this.data = data;
			this.left = null;
			this.right = null;

		}
	}
	
	//Expression tree using stack
	public class ExpTree{
		//exp = postfix expression, 
		public static Node construct(String exp) {
			Stack<Node> stack = new Stack<>();
			
			for(int i=0;i< exp.length();i++) {
				char c = exp.charAt(i);
				
				if (isOperand(c)) {
				    stack.push(new Node(String.valueOf(c)));
				} else if (isOperator(c)) { // Change this line to check for operators
				    Node rightNode = stack.pop();
				    Node leftNode = stack.pop();
				    Node newNode = new Node(String.valueOf(c));
				    newNode.left = leftNode;
				    newNode.right = rightNode;
				    stack.push(newNode);
				}

			}
			//
			return stack.pop();
		}

		private static boolean isOperand(char c) {
			// check if chracter is a number or variable
			return Character.isLetterOrDigit(c);
		}
		
	    private static boolean isOperator(char c) {
	        // Check if the character is an operator
	        return c == '+' || c == '-' || c == '*' || c == '/';
	    }
	    
	    
	    //preorder Traversal = root, left, right
	    public static void preorder(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }
	    
	    //Inorder Traversal = left, root, right
	    public static void inorder(Node node) {
            if (node != null) {
                preorder(node.left);
                System.out.print(node.data + " ");
                preorder(node.right);
            }
        }
	    
	    //postorder traversal = left, right, root
	    public static void postorder(Node node) {
            if (node != null) {
                preorder(node.left);
                preorder(node.right);
                System.out.print(node.data + " ");
            }
        }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the postfix expression: ");
        String exp = sc.nextLine();
        
        //the construct is static, so it's not accesible directly
        Node root = ExpTree.construct(exp);
        System.out.println("The postfix expression you entered is: " + exp);
        
        //preorder traversal
        System.out.println("The Preorder traversal of "+ exp + " is: ");
        ExpTree.preorder(root);
        System.out.println("\n");
        
        //inorder traversal
        System.out.println("The Inorder traversal of " + exp + " is: ");
        ExpTree.inorder(root);
        System.out.println("\n");
        
        //postorder traversal
        System.out.println("The Postorder traversalof of " + exp + " is: ");
        ExpTree.postorder(root);
        System.out.println("\n");
        
        sc.close();

	}

}
