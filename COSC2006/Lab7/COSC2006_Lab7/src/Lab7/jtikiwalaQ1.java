/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 7 Q1: Single node class
 * Any and All work in this file is my.
 **/
package Lab7;

//same as Lab6 Q1
public class jtikiwalaQ1 {
    protected String item;
    protected jtikiwalaQ1 nextNode;

    //constructor 1
    public jtikiwalaQ1(String item) {
        this.item = item;
        this.nextNode = null;
    }

    //constructor 2
    public jtikiwalaQ1(String item, jtikiwalaQ1 nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }
}