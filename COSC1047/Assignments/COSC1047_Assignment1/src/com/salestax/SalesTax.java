/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment1*/
package com.salestax; //package for salestax

public class SalesTax { 
	double pAmount; // variable to store the purchase amount
	final double TAX_PERCENTAGE = 0.06; // constant for the tax percentage
	
	public SalesTax (double purchaseAmount) {
	this.pAmount = purchaseAmount;
	}
	
	public double getPurchaseAmount() { //getter method
	return pAmount;
	}
	
	public void setPurchaseAmount(double purchaseAmount) { //setter method
	this.pAmount = pAmount;
	}
	
	public double setSalesTax() { //get sales tax method
		return TAX_PERCENTAGE;
	}
	
	public double getSalesTax() { //Method to calculate the tax amount
	double salesTax = pAmount * TAX_PERCENTAGE; // Calculate the sales tax amount using the purchase amount and tax percentage
	return salesTax;
	}
	
}
