/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 4 Q2: BitBank class
 * Any and All work in this file is my.
 **/
package Lab4;

public class JtikiwalaQ2 {

    public static void main(String[] args) {

        try {
        	//valid user input
            System.out.println("Valid User Input");
            JtikiwalaQ1 myBank = new JtikiwalaQ1("GB821234", 1110.73);
            myBank.withdraw(1100.0);
            myBank.deposit(4000.0);
            System.out.println(myBank);

            
            System.out.println("");
            System.out.println("Invalid User Input");
            //throw Invalid Account number exception
            JtikiwalaQ1 myBank1 = new JtikiwalaQ1("CA123456 ", 525.73);


        } catch (BankException ex) {
            System.err.println(ex.getMessage());
            System.err.flush();
        }
    }
}
