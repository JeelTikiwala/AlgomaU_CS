/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment4*/
public class Q2 {


    public static void main(String[] args) {

        System.out.println(bin2Dec("10101"));
        
        // System.out.println(bin2Dec("jeeltiki")); //throws an error
    }

    public static int bin2Dec(String binary) throws BinaryFormatException {

        if (!isBinary(binary)) { //checks if the string is valid or not
            throw new BinaryFormatException(binary + " is not a binary number.");
        }
        int power = 0;
        int decimal = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {

            if (binary.charAt(i) == '1') { // checks if the current binary digit is 1
                decimal += Math.pow(2, power);
            }
            power++; //increments the power
        }
        return decimal; //returns the decimal
    }

    public static boolean isBinary(String binary) {

        for (char ch : binary.toCharArray()) {
            if (ch != '1' && ch != '0') return false;
        }
        return true; //returns true if all the statements are true
    }

}

class BinaryFormatException extends IllegalArgumentException {

    BinaryFormatException(String s) {
        super(s);
    }
}