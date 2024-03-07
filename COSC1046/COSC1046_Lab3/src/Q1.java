import java.util.*; //import explicit function


public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //import scanner class
		System.out.println("Enter the month"); //enter month
		int month = sc.nextInt();
		
		System.out.println("Enter the Year"); //enter year
		int year = sc.nextInt();
		
		boolean leapyearalgo = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); //to check the February month as 28 or 29 days
		
		
		switch(month) {
		
		case 1:
			System.out.println("The number of days in January " + year + " is 31.");
			break;
		case 2:
			System.out.println("The number of days in February " + year + ((leapyearalgo)? " is 29" : " is 28")); //use of conditional (ternary) operator
			break;
		case 3:
			System.out.println("The number of days in March " + year + " is 31.");
			break;
		case 4:
			System.out.println("The number of days in April " + year + " is 30.");
			break;
		case 5:
			System.out.println("The number of days in May  " + year + " is 31.");
			break;
		case 6:
			System.out.println("The number of days in June " + year + " is 30.");
			break;
		case 7:
			System.out.println("The number of days in July " + year + " is 31.");
			break;
		case 8:
			System.out.println("The number of days in August " + year + " is 31.");
			break;			
		case 9:
			System.out.println("The number of days in September " + year + " is 30.");
			break;
		case 10:
			System.out.println("The number of days in October " + year + " is 31.");
			break;
		case 11:
			System.out.println("The number of days in November " + year + " is 30.");
			break;
		case 12:
			System.out.println("The number of days in December " + year + " is 31.");
			break;
		default:
			System.out.println("The month is invalid, write between 1-12");
		
		}
	}

}
