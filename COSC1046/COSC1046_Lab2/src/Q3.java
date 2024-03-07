import java.util.*; //Explicit import class
public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter any number you like: ");
		int lno = sc.nextInt();
		
		if(lno%2==0) {
			
			if(lno%5==0 && lno%7==0){
				System.out.println("The number is "+ lno + " ans it's divisble by both 5 and 7");
			}
			else if(lno%5==0) {
				System.out.println("The number is "+ lno + " and it's divisble by 5.");
			}
			else if(lno%7==0) {
				System.out.println("The nuymber is " + lno + " and it;s divisble by 7.");
			}
			
			else {
				System.out.println("The number is "+ lno + " and the number is even.");
			}
		}
		else {
			System.out.println("The number is " + lno + " and it's an odd number.");
		}
	}

}
