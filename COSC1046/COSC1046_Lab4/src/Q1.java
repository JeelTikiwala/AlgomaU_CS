import java.util.*;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //Input class
		
		System.out.println("Enter any letter: ");
		char lt = sc.next().charAt(0); //Use char to get input
		
		if(lt=='a' || lt=='e' || lt=='i' || lt=='o' || lt=='u' || lt=='A' || lt=='E' || lt=='I' || lt=='O' || lt=='U') { //check if the character is vovel
			System.out.println("The charcater is Vowel.");
		}
		
		else if((lt>='a' && lt<='z') || (lt>='A' && lt<='Z')){ //if not Vowel then Consonent
			System.out.println("The character is consonent");
		}
		
		else {
			System.out.println("Invalid Input"); //if not both then invalid input
		}
	}

}


