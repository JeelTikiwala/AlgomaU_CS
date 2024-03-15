/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC2006_lab1*/
package lab1;

public class Student extends Person { //extends student class
	
	private double stuAverage;
	

    public Student(int id, String name) {
        super(id, name);
        this.stuAverage = 0.0; // Initialize average to zero
    }

    public double getAverage() {
        return stuAverage;
    }

    public void setAverage(double average) {
        this.stuAverage = average;
    }

    @Override
    public String toString() {
        // Format the average as a percentage with two decimal places
        String formattedAverage = String.format("%.2f%%", stuAverage);
        
        return String.format("Student[id=%s, name=%s, GPA=%s]", getId(), getName(), formattedAverage);
    }
}