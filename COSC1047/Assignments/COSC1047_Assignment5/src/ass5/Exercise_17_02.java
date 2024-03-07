package ass5;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment5*/
import java.io.*;

public class Exercise_17_02 {
  public static void main(String[] args) {

    try (
      DataOutputStream dos = new DataOutputStream(new FileOutputStream("Exercise17_02.txt", true)); // Create a DataOutputStream object to write data to a file
    ) {
    	
    // Generate and write 100 random integers to the file
      for (int i = 0; i < 100; i++) {
        dos.writeInt((int)(Math.random() * 10000));
      }
    } 
    catch (IOException ioe) {
      ioe.printStackTrace();
    } 
  }
}
