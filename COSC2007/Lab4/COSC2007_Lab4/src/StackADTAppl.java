/**
Name: Jeel Tikiwala
Student ID: 239659420
Lab 4
Any and all work in this file is my own.*/
import java.util.*;

public class StackADTAppl {

    // convertt infix to postfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // Stack to store operators temporarily
        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // If character is operand
                postfix.append(c);
            } else if (c == '(') { // If character is left parenthesis
                stack.push(c);
            } else if (c == ')') { // If character is right parenthesis
            	
                
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                
                if (stack.isEmpty() || stack.peek() != '(') {
                    throw new IllegalArgumentException("The parentheses are unbalanced.");
                }
                stack.pop(); 
            } else { 
                
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c); //push
            }
        }
        
        
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') { 
                throw new IllegalArgumentException("The parentheses are unbalanced");
            }
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    // To evaluate postfix
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) { 
                stack.push(c - '0'); 
            } else { 
                int operand2 = stack.pop(); 
                int operand1 = stack.pop(); 
                switch (c) { 
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stack.pop(); // Final Result
    }

    // Method to determine precedence of operators
    //MD > AS (we can also refer BODMAS method of maths)
    public static int precedence(char c) {
        if (c == '+' || c == '-') { 
            return 1;
        } else if (c == '*' || c == '/') { 
            return 2;
        } else { 
            return 0;
        }
    }
    
    public static void main(String[] args) {
    	//scanner class
        Scanner sc = new Scanner(System.in);
        
        // Q1) Read the infix expression
        System.out.print("Enter the infix expression: ");
        String infixExpression = sc.nextLine();

        try {
            //Q2) Convert infix expression to postfix
            String postfixExpression = infixToPostfix(infixExpression);
            System.out.println("The Postfix expression is: " + postfixExpression);

            //Q3) Evaluate the postfix expression
            int result = evaluatePostfix(postfixExpression);
            System.out.println("The Result of the expression is: " + result);
        } catch (Exception e) {
            System.out.println("The Error of the expression is: " + e.getMessage());
        }
        finally {
            sc.close();
        }
        
    }
    
}
