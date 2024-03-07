package ass6;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment6*/
public class Course implements Cloneable {
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public void addStudent(String student) {
		students[numberOfStudents] = student;
		numberOfStudents++;
	}

	public String[] getStudents() {
		return students;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public String getCourseName() {
		return courseName;
	}


	public Course clone() throws CloneNotSupportedException {
		// Perform a shallow copy
		Course courseClone =	(Course)super.clone();
		// Deep copy on students
		courseClone.students = students.clone();
		return courseClone;
	}

	public void dropStudent(String student) {
		// Left as an exercise in Programming Exercise 10.9
	}
}