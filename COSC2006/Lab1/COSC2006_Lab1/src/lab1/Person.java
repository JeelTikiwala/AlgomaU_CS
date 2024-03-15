/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC2006_lab1*/
package lab1;

public class Person {
	
    //two private data variables
    private int id;
    private String name;
    
    //Constructor
    public Person(int newId, String newName) {
        id = newId;
        name = newName;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	//display the values
	public void displayDetails() {
		System.out.println("I isd: " + id + ", Name: " + name);
	}
    
    
}
