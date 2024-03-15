/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC2006_lab1*/
package lab1;

public class Course {
    private static final int MAX_ENROLLED_STUDENTS = 5;
    private Student[] students;
    private int enrollment;
    private Instructor instructor;
    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.students = new Student[MAX_ENROLLED_STUDENTS];
        this.enrollment = 0;
    }

    public void enroll(Student student) {
        if (enrollment < MAX_ENROLLED_STUDENTS) {
            students[enrollment++] = student;
        } else {
            System.out.println("Course is already full. Cannot enroll more students to this course.");
        }
    }

    public void unenroll(Student student) {
        if (enrollment > 0) {
            boolean found = false;
            for (int i = 0; i < enrollment; i++) {
                if (students[i] == student) {
                    //shifting all elements to the left
                    for (int j = i; j < enrollment - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    students[enrollment - 1] = null; // Clear the last element
                    enrollment--;
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student is not enrolled in this course.");
            }
        } else {
            System.out.println("No students are enrolled in this course.");
        }
    }

    public void assignGrade(Student student, double grade) {
        // Find the student in the course
        for (int i = 0; i < enrollment; i++) {
            if (students[i] == student) {
                // Update the student's average
                student.setAverage((student.getAverage() + grade) / 2.0);
                break;
            }
        }
    }
    
    //auto-generated setter and getter
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getEnrollment() {
        return enrollment;
    }

    @Override
    public String toString() {
        return String.format("Course[code=%s, name=%s, instructor=%s, enrolled=%d]",
                courseCode, courseName, instructor, enrollment);
    }
}
