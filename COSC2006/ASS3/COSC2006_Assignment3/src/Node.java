/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass3: Linked Lists
 * Any and All work in this file is my.
 **/

public class Node {

    protected int Stu_no; //student number
    protected double Stu_mark; //student mark
    protected Node next; //node refernce

    //constructor 1
    public Node(int Stu_no, double Stu_mark) {
        this.Stu_no = Stu_no;
        this.Stu_mark = Stu_mark;
        this.next=null;
    }

    //constructor 2
    public Node(int Stu_no, double Stu_mark, Node next) {
        this.Stu_no = Stu_no;
        this.Stu_mark = Stu_mark;
        this.next = next;
    }

    //getter method - student no
    public int getStuno() {
    	return Stu_no;
    }
    
    //getter method - get mark 
	public double getMark() {
		return Stu_mark;
	}

	//getter method - get next node
	public Node getnext() {
		return next;
	}

	//setter method - set node
	public void setNextNode(Node node) {	
		
	}

	
}

