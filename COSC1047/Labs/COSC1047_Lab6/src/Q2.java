import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        String filename = "/Users/apple/eclipse-workspace/COSC1047_Lab6/src/Lab6.txt"; //file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        	// Create maps to store the total GPA sum and count for each course
            Map<String, Double> courseGPASum = new HashMap<>();
            Map<String, Integer> courseCount = new HashMap<>();

            String line;
            int lineNumber = 0;
            
         // Read the first three lines of the file
            while ((line = reader.readLine()) != null && lineNumber < 3) {
                System.out.println(line);
                lineNumber++;
            }
            
         // Read the remaining lines of the file
            while ((line = reader.readLine()) != null) {
                try {
                	 // Split the line by commas to extract student data
                    String[] data = line.split(",");
                    if (data.length == 3) {
                        String studentName = data[0];
                        String courseName = data[1];
                        double gpa = Double.parseDouble(data[2]);
                        
                     // Update the total GPA sum and count for each course
                        courseGPASum.put(courseName, courseGPASum.getOrDefault(courseName, 0.0) + gpa);
                        courseCount.put(courseName, courseCount.getOrDefault(courseName, 0) + 1);
                    }
                } catch (NumberFormatException e) {
                	 // Handle the exception when parsing the GPA value as a double
                    System.out.println("Error parsing GPA value on line: " + line);
                }
            }
            
            // Calculate and display the average GPA for each course
            System.out.println("\nAverage GPA for each course:");
            for (Map.Entry<String, Double> entry : courseGPASum.entrySet()) {
                String courseName = entry.getKey();
                double totalGPA = entry.getValue();
                int count = courseCount.get(courseName);
                double averageGPA = totalGPA / count;
                System.out.println(courseName + ": " + averageGPA);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
