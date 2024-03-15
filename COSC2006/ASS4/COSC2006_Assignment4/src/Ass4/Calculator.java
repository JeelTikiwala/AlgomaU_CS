package Ass4;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass4: Infix Calculator
 * Any and All work in this file is my.
 **/
import java.util.Stack;


public class Calculator {
    private final String infixExpression;
    private String postfixExpression;

    
    public Calculator(String exp) {
        this.infixExpression = exp;
    }

    public String toString() {
        return infixExpression;
    }

    private int precedence(char operator) {
        // returns an int value
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private Boolean convertPostFix() {
        Stack<Character> operandStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infixExpression.length(); i++) {
            char currChar = infixExpression.charAt(i);

          
            if (Character.isDigit(currChar)) {
                postfix.append(currChar).append(" ");
            }
            
            else if (currChar == '(') {
                operandStack.push(currChar);
            }
           
            else if (currChar == ')') {
                while (!operandStack.isEmpty() && operandStack.peek() != '(') {
                    postfix.append(operandStack.pop()).append(" ");
                }
                
                if (!operandStack.isEmpty() && operandStack.peek() != '(') {
                    return false;
                } else {
                    
                    operandStack.pop();
                }
            }
           
            else {
                while (!operandStack.isEmpty() && precedence(currChar) <= precedence(operandStack.peek())) {
                    postfix.append(operandStack.pop()).append(" ");
                }
                operandStack.push(currChar);
            }
        }
       
        while (!operandStack.isEmpty() ) {
            postfix.append(operandStack.pop()).append(" ");
        }

        postfixExpression = postfix.toString();
        return true;
    }


    public String getPostFix() throws IllegalStateException {
        if (postfixExpression == null) {
            if (!convertPostFix()) {
                throw new IllegalStateException("The infix expression is invalid");
            }
        }

        return postfixExpression;
    }

    public int evaluate() throws IllegalStateException {
        if (postfixExpression == null) {
            throw new IllegalStateException("The postfix expression is not available");
        }

        Stack<Integer> stack = new Stack<>();
        String[] elements = postfixExpression.split(" ");

        for (String element : elements) {
            if (element.matches("\\d+")) {
                stack.push(Integer.parseInt(element));
            } else if (element.equals("+")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 + operand2);
            } else if (element.equals("-")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 - operand2);
            } else if (element.equals("*")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 * operand2);
            } else if (element.equals("/")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                stack.push(operand1 / operand2);
            } else if (element.equals("%")) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                stack.push(operand1 % operand2);
            } else {
                throw new IllegalStateException("The postfix expression is invalid.");
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("The postfix expression is invalid.");
        }

        return stack.pop();
    }
}