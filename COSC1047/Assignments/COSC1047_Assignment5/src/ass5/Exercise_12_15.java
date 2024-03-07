package ass5;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment5*/
import java.util.*;
import java.io.*;

public class Exercise_12_15 {
	/** Main method */
	public static void main(String[] args) throws Exception {
		// Check if file exists
		File file = new File("Exercise12.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}

		try (
			// Create output file
			PrintWriter output = new PrintWriter(file);
		) {
			// Write 100 integers created radomly to file
			for (int i = 0; i < 100; i++) {
				output.print(((int)(Math.random() * 500) + 1));
				output.print(" ");
			}
		}

		// Crate and ArrayList
		ArrayList<Integer> list = new ArrayList<>();

		try(
			// Create input file
			Scanner sc = new Scanner(file);
		) {
			// Read the data back from the file
			while (sc.hasNext()) {
				list.add(sc.nextInt());
			}
		}

		// Sort array list
		Collections.sort(list);

		// Display data in increasing order
		System.out.print(list.toString());
		System.out.println();
	}
}