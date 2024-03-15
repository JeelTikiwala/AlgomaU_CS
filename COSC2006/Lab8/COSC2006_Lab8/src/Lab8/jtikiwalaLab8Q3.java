package Lab8;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 8 Q3: Parenthesis Checking
 * Any and All work in this file is my.
 */
import java.util.*;

public class jtikiwalaLab8Q3 {
    public static void main(String[] args) throws StackException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a string to check parenthesis in it: ");
        String input = sc.nextLine();

        jtikiwalaLab8Q1 stack = new jtikiwalaLab8Q1(input.length());

        for (int a = 0; a < input.length(); a++) {
            char c = input.charAt(a);

            if (c == '(') {
            	stack.push(c);

            } else if (c == ')') {
                try {
                	stack.pop();
                } catch (StackException e) {

                    throw new StackException("Error: Too many closing brackets!");
                }
            }
        }


        if (!stack.isEmpty()) {
            throw new StackException("Error: Too many opening brackets.");
        }


        System.out.printf("The string \"%s\" has matched parentheses.%n", input);
    }
}


