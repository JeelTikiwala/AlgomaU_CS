/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab5*/
import java.util.*;
public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Minimum Value: ");
		int min = sc.nextInt();
		
		System.out.println("Enter Maximum Value: ");
		int max = sc.nextInt();
		
	       try {
	            if (min >= max) {
	                throw new InvalidRangeException("The range is invalid.");
	            }
	            
	            int count = countPrimes(min, max);
	            System.out.println("Number of prime numbers between " + min + " and " + max + "are " + count);
	        } catch (InvalidRangeException e) {
	            System.out.println(e.getMessage());
	        }
	        
	    }
	    
	    private static int countPrimes(int min, int max) {
	        int count = 0;
	        
	        for (int num = min; num <= max; num++) {
	            if (isPrime(num)) {
	                count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private static boolean isPrime(int number) {
	        if (number <= 1) {
	            return false;
	        }
	        
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	}

	class InvalidRangeException extends Exception {
	    public InvalidRangeException(String message) {
	        super(message);
	    }
	}