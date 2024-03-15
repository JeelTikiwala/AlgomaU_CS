/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 6 Q1: Single node Class
 * Any and All work in this file is my.
 **/
package lab6;


public class jtikiwalaLab6Q1 {
    protected String item;
    protected jtikiwalaLab6Q1 nextNode;

    //constructor 1
    public jtikiwalaLab6Q1(String item) {
        this.item = item;
        this.nextNode = null;
    }

    //constructor 2
    public jtikiwalaLab6Q1(String item, jtikiwalaLab6Q1 nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }
}