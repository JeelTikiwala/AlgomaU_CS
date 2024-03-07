import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) {
        String filename = "/Users/apple/eclipse-workspace/COSC1047_Lab6/src/Lab6.txt"; //txt file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineCount = 0;
            
            // Read the file line by line until the 3rd line
            while ((line = reader.readLine()) != null && lineCount < 3) {
                System.out.println(line);
                lineCount++;
            }
        } catch (IOException e) {
        	// Handle any IO exception that might occur during file reading
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}