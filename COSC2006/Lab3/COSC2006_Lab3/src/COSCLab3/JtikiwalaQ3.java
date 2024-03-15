/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 3 Q1:The Fibonacci Sequence.
 * Any and All work in this file is my.
 **/

package COSCLab3;

public class JtikiwalaQ3 {
    public static void main(String[] args) {
        both(5);
    }

    public static void both(int n) {
        if (n == 0 || n < 0)
            return;
        int p = 0;
        while (p < n) {
            both(n - 1);
            for (int i = 0; i < n; i++) {
                System.out.print("* ");
                p++;
            }
            System.out.println();


        }
//        System.out.println("loop end");

//        int j=n;
//        if (j > 0) {
//            for (int i = 0; i < n; i++) {
//                System.out.print("* ");
//
//            }
//            System.out.println();
//            both(n-1);
//            j--;
//
//
//        }

    }
}