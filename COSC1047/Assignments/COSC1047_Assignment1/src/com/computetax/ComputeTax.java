/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment1*/
package com.computetax;

/**
 * @author jtikiwala
 *
 */
public class ComputeTax {
	double income = 0; //variable to store the income and intital it's 0
	double tax = 0; //variable to store the tax and intital it's 0
	
	public void setIncome(double income) { 
		this.income = income;
	}  
	
	public double getIncome() {
		return income; //return income
	}
	
	public double setTax(double tax) { //// Compute the tax based on the income
		this.tax = tax;
		
		//if else conditions to compute the taxes
		if(income<=200000) {
			tax  = income * 0.2; // Calculate tax as 20% of the income
			System.out.println("The tax is " + (int) (tax * 100) / 100.0);
		}
		
		else if(income>200000 && income < 500000){
			tax  = income * 0.4; // Calculate tax as 40% of the income
			System.out.println("The tax is " + (int) (tax * 100) / 100.0);
		}
		
		return tax; //return tax after computing
	}
	
	public double getTax() {
		return tax; //return tax
	}
}
