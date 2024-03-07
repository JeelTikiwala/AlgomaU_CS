import java.util.*; //import explicit function

public class Q2 {

	public static void main(String[] args) {
		Random ran = new Random(); // Generates a random integer between 1 to 13
		int cardrank = ran.nextInt(14) + 1;
		
		int cardsuit = (int)(Math.random() * 4); //Random int between 1 to 4
		
		System.out.print("The card is: ");
		
		switch(cardrank){
		
		case 1: System.out.println("Ace");
			break;
		case 2: System.out.println(cardrank);
			break;
		case 3: System.out.println(cardrank);
			break;
		case 4: System.out.println(cardrank);
			break;
		case 5: System.out.println(cardrank);
			break;
		case 6: System.out.println(cardrank);
			break;
		case 7: System.out.println(cardrank);
			break;
		case 8: System.out.println(cardrank);
			break;
		case 9: System.out.println(cardrank);
			break;
		case 10: System.out.println(cardrank);
			break;
		case 11: System.out.println("Jack");
			break;
		case 12: System.out.println("Queen");
			break;
		case 13: System.out.println("King");
			
		}
		
		System.out.print("of ");
		
		switch(cardsuit) {
		
		case 0: System.out.println("Clubs"); 
			break;
		case 1: System.out.println("Diamonds");
			break;
		case 2: System.out.println("Hearts"); 
			break;
		case 3: System.out.println("Spades"); 
		}
	}

}
