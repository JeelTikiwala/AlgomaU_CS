package Lab8;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 8 Q1: Stack class
 * Any and All work in this file is my.
 */
public class jtikiwalaLab8Q1 {

    private char[] stack;
    private int top;


    public jtikiwalaLab8Q1(int a) throws StackException {

        if (a <= 0) {
            throw new StackException("The size of stack is invalid.");
        }

        stack = new char[a];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }


    public void push(char item) throws StackException {

        if (top == stack.length - 1) {
            throw new StackException("The stack is overflowing!");
        }

        stack[++top] = item;
    }


    public char pop() throws StackException {

        if (isEmpty()) {
            throw new StackException("The stack is underflowing!");
        }

        return stack[top--];
    }


    public void popAll() {
        top = -1;
    }


    public char peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        }
        return stack[top];
    }
}


class StackException extends Exception {
    private static final long serialVersionUID = 1L;

    public StackException(String s) {
        super(s);
    }
}

