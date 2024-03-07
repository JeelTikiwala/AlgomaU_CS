import java.util.*; //Implicit import
public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the investment amount: ");
		double invamt = sc.nextDouble(); //Investment amount
		
		System.out.println("Enter annual intrest rate: ");
		double annualintrate = sc.nextDouble(); //annual investment rate
		double monthlyintrate = annualintrate / 1200; //Converted annually to monthly
		
		System.out.println("Enter the no of years for investment:");
		int nyears = sc.nextInt();
		
		
		double a = (1+monthlyintrate); //
		double b = nyears * 12;
		double fn = Math.pow(a, b);
		
		double futureinvamt;
		futureinvamt = invamt * fn;
		System.out.println("The total accumulated amnount for the investment is: " + futureinvamt);
				

	}

}
