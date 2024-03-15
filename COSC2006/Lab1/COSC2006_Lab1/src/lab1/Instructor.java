/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC2006_lab1*/
package lab1;

public class Instructor extends Person {
    private String department;

    public Instructor(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Instructor[id=%s, name=%s, department=%s]", getId(), getName(), department);
    }
}
