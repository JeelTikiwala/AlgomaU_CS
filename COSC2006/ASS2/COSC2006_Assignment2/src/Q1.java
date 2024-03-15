/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass2: Recursion - Q1
 * Any and All work in this file is my.
 **/

public class Q1 {

    public static void main(String[] args) {
    	// Print the result where n=4
        System.out.println(numStrings(4));
    }

    public static int numStrings(int N) {
    	//base case; n=0
        if (N == 0) {
            return 1;
        }
        //base case; n=1
        if (N == 1) {
            return 2;
        }
        //base case; n=2
        if (N == 2) {
            return 3;
        }
     // sum the no of str for N-1 and N-2
        return numStrings(N - 1) + numStrings(N - 2);
    }
}
