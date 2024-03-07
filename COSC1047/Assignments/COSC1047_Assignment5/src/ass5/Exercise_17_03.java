package ass5;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment5*/
import java.io.*;

public class Exercise_17_03 {
  public static void main(String[] args) {
    int sum = 0;

    try(
      DataInputStream dis = new DataInputStream(new FileInputStream("Exercise17_02.txt"));
    ) {
      while (true) {
        sum += dis.readInt();
      }
    }
    catch (EOFException eof) { //reading the file
      System.out.println("File reading complete.");
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }

    System.out.println("The sum of the values in the file is: " + sum); //print out the sum
  }
}