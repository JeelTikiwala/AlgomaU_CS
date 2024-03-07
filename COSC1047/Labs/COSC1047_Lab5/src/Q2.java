/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab5*/
import java.util.*;
public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		String in = sc.nextLine();
		
		try {
			int number = Integer.parseInt(in);
            System.out.println("Successfully parsed the string. The Integer value is: " + number);
		}
		catch(NumberFormatException e) {
			 System.out.println("Cannot parse the string into an integer.");
		

	}

}
}
