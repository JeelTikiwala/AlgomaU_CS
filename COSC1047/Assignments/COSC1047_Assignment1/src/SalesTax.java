/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment1*/


import java.util.Scanner; //import scanner class

public class SalesTax { //main class
    private double purchaseamount;
    private double salesrate;
    final double TAX_PERCENT= 0.06;

    public SalesTax(double salesamount, double salesrate) {
        this.purchaseamount = salesamount;
        this.salesrate = salesrate;
    }
    
    public double getPurAmount() {
        return purchaseamount;
    }
    
    public double getSalesTax(){ //to find the tax amount
    	double salesTax = purchaseamount*TAX_PERCENT;
        return salesTax;
    }

    public void setAmount(double amount) { 
        this.purchaseamount = purchaseamount;
    }

    public double getRate() {
        return salesrate;
    }

    public void setRate(double rate) {
        this.salesrate = rate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = sc.nextDouble();
        SalesTax salesTax = new SalesTax(purchaseAmount,.06);

        System.out.println("Sales tax is "+salesTax.getSalesTax());
    }
}