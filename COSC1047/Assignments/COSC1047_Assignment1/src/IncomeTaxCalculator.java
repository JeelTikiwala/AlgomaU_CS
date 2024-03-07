/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment1*/

public class IncomeTaxCalculator { 
	double income;
    double taxRate;
    
    public IncomeTaxCalculator(double income, double taxRate) {
        this.income = income;
        this.taxRate = taxRate;
    }

    public double calculateTax() {
        return income * taxRate;
    }

    // Getters and Setters method
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    
    
	public static void main(String[] args) {
        IncomeTaxCalculator calculator = new IncomeTaxCalculator(10000.0, 0.20); // Create an instance of IncomeTaxCalculator

        double taxAmount = calculator.calculateTax(); // Calculate the tax amount

        System.out.println("Tax amount: " + taxAmount);

        // Modify the income and tax rate using setters
        calculator.setIncome(60000.0);
        calculator.setTaxRate(0.2);

        // Recalculate the tax amount
        taxAmount = calculator.calculateTax();

        System.out.println("Updated tax amount: " + taxAmount);

	}

}
