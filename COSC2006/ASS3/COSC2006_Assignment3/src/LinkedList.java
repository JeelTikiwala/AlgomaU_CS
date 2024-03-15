/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass3: Linked List
 * Any and All work in this file is my.
 **/
public class LinkedList {
	protected Node head=null;
    
    //get node count
    public int getNodeCount(Node node) {
        if(node == null) {
            return 0;
        }
        return 1 + getNodeCount(node.next);
    }
    


    public void add(int Stu_no, double Stu_mark) {
    	//base case
        if (head == null) {
            head = new Node(Stu_no, Stu_mark);
        }
        else if (Stu_mark > head.getMark()) {
            head = new Node(Stu_no, Stu_mark, head);
        }
        else {
            Node current = head;
            while (current.getnext() != null && current.getnext().getMark() > Stu_mark) {
                current = current.getnext();
            }
            current.setNextNode(new Node(Stu_no, Stu_mark, current.getnext()));
        }
    }


    //find the median of the data
    public String findMedian() {
        int l = getNodeCount(head);
        StringBuilder result= new StringBuilder();
        if(l % 2 == 0) {
        	result.append("The median mark of Dataset is ").append(getMiddleNode(head, l / 2).Stu_mark).append(", ");
        	result.append("and student number is ").append(getMiddleNode(head, l / 2).Stu_no).append(".");
            return result.toString();
        } else {
        	result.append("The median mark of Dataset is ").append(getMiddleNode(head, l / 2 + 1).Stu_mark).append(", ");
        	result.append("and student number is " ).append(getMiddleNode(head, l / 2 + 1).Stu_no).append("." + '\n');
            return result.toString();
        }
    }
    
    public void printList() {
    	System.out.println(" --------------------------");
        System.out.println("|Student No    |  Marks    |" + '\n' + " --------------------------");
        
        Node current = head;
        while (current != null) {
            System.out.printf("| %-12d |  %6.2f   |\n", current.Stu_no, current.Stu_mark);
            current = current.next;
        }
        System.out.println(" --------------------------");
    }

    public Node getMiddleNode(Node node, int n) {
        if(n == 1) {
            return node;
        }
        return getMiddleNode(node.next, n - 1);
    }
}
