/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC2006_lab1*/
package lab1;

public class Test{
    public static void main(String[] args) {
    	
        // (a) (a) Creates 7 students with different id numbers and names. One of these students must
    	// have your name on it - the rest can be random. Print each one to the console.
        Student student1 = new Student(1, "Jeel Tikiwala");
        Student student2 = new Student(2, "Om Patel");
        Student student3 = new Student(3, "Prof. Johnny Console");
        Student student4 = new Student(4, "Jay Sheth");
        Student student5 = new Student(5, "Jayraj");
        Student student6 = new Student(6, "Hem Joshi");
        Student student7 = new Student(7, "Nidhi Patel"); 

        // Print each student to the console
        System.out.println("List of Students:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);

        // (b) Set the student’s averages to any values you like (range from 0-100). Use a variety of
        //values and print the students to the console again. If you’d like to use random numbers,
        //you can use this code to get a random number between 0 and 100:
        student1.setAverage(Math.random() * 101);
        student2.setAverage(Math.random() * 101);
        student3.setAverage(Math.random() * 101);
        student4.setAverage(Math.random() * 101);
        student5.setAverage(Math.random() * 101);
        student6.setAverage(Math.random() * 101);
        student7.setAverage(Math.random() * 101);

        // Print students after setting averages
        System.out.println("\nStudents with Averages:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);

        // (c) Creates an instructor with a different id and name to the students. Print it to the
        //console.
        Instructor instructor = new Instructor(1001, "Prof. Johnny Console","Computer Science");

        // Print the instructor to the console
        System.out.println("\nThe Instructor is:");
        System.out.println(instructor);

        // (d)  Create two courses with any code and names you wish - be creative!
        Course course1 = new Course("COSC2006", "Data Structures I");
        Course course2 = new Course("COSC2007", "Data Structures II");

        // (e) Assign the instructor to both courses. Print the courses to the console.
        course1.setInstructor(instructor);
        course2.setInstructor(instructor);

        // Print the courses with instructors
        System.out.println("\nCourses with Instructors:");
        System.out.println(course1);
        System.out.println(course2);

        // (f) ssign 5 of the 7 students to the first course and the other 2 to the second. Print the
        // courses after you are done.
        
        //1st course - Data Structures - I
        course1.enroll(student1);
        course1.enroll(student2);
        course1.enroll(student3);
        course1.enroll(student4);
        course1.enroll(student5);
        
        
        //2nd Course - Data Structures - II
        course2.enroll(student6);
        course2.enroll(student7);

        // Print the courses after enrolling students
        System.out.println("\nThe Courses with Enrolled Students:");
        System.out.println(course1);
        System.out.println(course2);

        // (g) Assign all students grades
        course1.assignGrade(student1, 97.7);
        course1.assignGrade(student2, 67.0);
        course1.assignGrade(student3, 93.2);
        course1.assignGrade(student4, 88.3);
        course1.assignGrade(student5, 78.4);

        course2.assignGrade(student6, 89.0);
        course2.assignGrade(student7, 86.3);

        // Print all students after assigning grades
        System.out.println("\nStudents with Assigned Grades are:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);
        System.out.println(student5);
        System.out.println(student6);
        System.out.println(student7);

        // (h) Unenroll two students from the first course
        course1.unenroll(student2);
        course1.unenroll(student5);

        // Print the first course after unenrolling students
        System.out.println("\nFirst Course after Unenrolling Students:");
        System.out.println(course1);
    }
}
