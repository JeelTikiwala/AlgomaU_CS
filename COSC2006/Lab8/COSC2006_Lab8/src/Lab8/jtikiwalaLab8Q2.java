package Lab8;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 8 Q2: reversed string class
 * Any and All work in this file is my.
 */
import java.util.*;

public class jtikiwalaLab8Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string to reverse it:");
        String input = sc.nextLine();


        try {
        	jtikiwalaLab8Q1 stack = new jtikiwalaLab8Q1(input.length());

            for (int i = 0; i < input.length(); i++) {
            	stack.push(input.charAt(i));
            }

            System.out.println("The Reversed string of the String " + input + " is: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        } catch (StackException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            e.printStackTrace();
        }
    }
}
