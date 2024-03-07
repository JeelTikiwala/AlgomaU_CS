import java.util.*;
public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your social security number: "); //DDD-DD-DDDD
		
		String ssn = sc.nextLine();

		//d in regex in java is known for digits(range: 0-9)
		boolean isSSNValid = ssn.matches("(^\\d{3}-?\\d{2}-?\\d{4}$|^XXX-XX-XXXX$)"); //pattern(java regular expresionms) for starting string starts with 3 digits followed by dash followed by two digits 
	
		
		if (isSSNValid) {
	        System.out.println(ssn + " is a valid Social Security Number.");
	    } else {
	        System.out.println(ssn + " is an invalid Social Security Number.");
	    }
	}

}
