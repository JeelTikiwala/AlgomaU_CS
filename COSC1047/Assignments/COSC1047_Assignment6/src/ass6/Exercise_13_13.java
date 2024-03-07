package ass6;

/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment6*/
public class Exercise_13_13 {
	public static void main(String[] args) 
			throws CloneNotSupportedException {
		// Create a course object
		Course course1 = new Course("COSC1047");

		// Add students to course1
		course1.addStudent("Jeel Tikiwala");
		course1.addStudent("Rishit Tikiwala");
		course1.addStudent("Om Patel");

		// Clone course1
		Course course2 = course1.clone();

		// Add students to course2
		course2.addStudent("Shaan Fruitwala");
		course2.addStudent("Jeel Tikiwala");

		// Display students in course1
		System.out.println("\nThe Number of students in course1: "
			+ course1.getNumberOfStudents());
		String[] students = course1.getStudents();
		for (int i = 0; i < course1.getNumberOfStudents(); i++)
			System.out.print(students[i] + ", ");
		System.out.println();

		// Display students in course2
		System.out.println("\nNumber of students in course2: "
			+ course2.getNumberOfStudents());
		String[] students2 = course2.getStudents();
		for (int i = 0; i < course2.getNumberOfStudents(); i++)
			System.out.print(students2[i] + ", ");
		System.out.println();
	}
}