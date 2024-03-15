package Ass4;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass4: Delimiter Main
 * Any and All work in this file is my.
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class DelimiterMain {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("The path of the file is not defined.");
            return;
        }

        Stack<DelimiterData> delimiterStack = new Stack<>();
        int lineno = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/apple/Documents/AlgomaU_CS/SEM2/COSC2006/ASS4/test_file_ass4.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < line.length(); col++) {
                    char ch = line.charAt(col);
                    if (ch == '(' || ch == '{' || ch == '[') {
                    	delimiterStack.push(new DelimiterData(ch, lineno, col + 1));
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        if (delimiterStack.empty()) {
                            System.out.println("Unmatched delimiter " + ch + " at line " + lineno + " column " + (col + 1));
                            continue;
                        }
                        char t = delimiterStack.pop().getCharacter();
                        if ((ch == '}' && t != '{') || (ch == ']' && t != '[') || (ch == ')' && t != '(')) {
                            System.out.println("Mismatched delimiters " + t + " and " + ch + " at line " + lineno + " columns " +
                                    (col - delimiterStack.size()) + " and " + (col + 1));
                        }
                    }
                }
                lineno++;
            }

            while (!delimiterStack.empty()) {
                DelimiterData last = delimiterStack.pop();
                System.out.println("Unmatched delimiter " + last.getCharacter() + " at line " + last.getLine() + " column " + last.getColumn());
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
