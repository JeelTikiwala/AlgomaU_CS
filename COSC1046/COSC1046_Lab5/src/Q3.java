import java.util.*;
public class Q3 {

	public static void main(String[] args) {
		
				Scanner sc = new Scanner(System.in);

				System.out.print("Enter the number of lines to make pyramid: ");
				int numberOfLines = sc.nextInt();

				for (int rows = 1; rows <= numberOfLines; rows++) {
					for (int s = numberOfLines - rows; s >= 1; s--) {
						System.out.print("  ");
					}

					for (int l = rows; l >= 2; l--) {
						System.out.print(l + " ");
					}

					for (int r = 1; r <= rows; r++) {
						System.out.print(r + " ");
					}

					System.out.println();
				}

	}

}
