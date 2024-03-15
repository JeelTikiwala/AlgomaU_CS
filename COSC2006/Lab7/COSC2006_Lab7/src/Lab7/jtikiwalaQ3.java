/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 7 Q3: Main class
 * Any and All work in this file is my.
 **/
package Lab7;

public class jtikiwalaQ3 {

    public static void main(String[] args) {

        jtikiwalaQ2 list = new jtikiwalaQ2();

        //Q-1: Insert item to the list
        System.out.println("Adding the names:");
        
        //
        list.insert("Jeel");
        System.out.println("List after 1st insertion: " + list);

        list.insert("Rishit");
        System.out.println("List after 1st insertion: " + list);

        list.insert("Sangini");
        System.out.println("List after 1st insertion: " + list);
        
        list.insert("Jenish");
        System.out.println("List after 1st insertion: " + list);
        
        list.insert("Bhavesh");
        System.out.println("List after 1st insertion: " + list);
        
        list.insert("Mary");
        System.out.println("List after 1st insertion: " + list);
        
        list.insert("Drashti");
        System.out.println("List after 1st insertion: " + list);
        
        list.insert("Kiyaan");
        System.out.println("List after 1st insertion: " + list);
        
        list.insert("Yashank");
        System.out.println("List after 1st insertion: " + list);

        try {

           //remove 3 names from the list
        	System.out.println("\nRemoving three names from the list:");
        	
        	//name 1
            System.out.println("The " + list.remove(list.find("Jeel")) + " has been removed from the list.");
            System.out.println(list);

            //name 2
            System.out.println("The " + list.remove(list.find("Rishit")) + " has been removed from the list.");
            System.out.println(list);
            
            //name 3
            System.out.println("The " + list.remove(list.find("Yashank")) + " has been removed from the list.");
            System.out.println(list);
            

        } 
        //Q-3: Catch Exception
        catch (CustomException e) {
            System.err.println("Error caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
