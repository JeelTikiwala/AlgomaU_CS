/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 6 Q3: Test Class
 * Any and All work in this file is my.
 **/
package lab6;

public class jtikiwalaLab6Q3 {

    public static void main(String[] args) {

    	jtikiwalaLab6Q2 list = new jtikiwalaLab6Q2();
        try {
        	
            //Q-1: Insert item to the list
        	System.out.println("Printing the lists:");
        	
            list.add("Milk", 0);
            System.out.println("List after 1st insertion: " + list);
            
            list.add("Eggs", 1);
            System.out.println("List after 2nd insertion: " + list);
            
            list.add("Celery", 2);
            System.out.println("List after 3rd insertion: " + list);

            list.add("Bananas", 3);
            System.out.println("List after 4rd insertion: " + list);

            list.add("Apples", 4);
            System.out.println("List after 5th insertion: " + list);

            list.add("Oranges", 5);
            System.out.println("List after 6th insertion: " + list);

            list.add("Cookies", 6);
            System.out.println("List after 7th insertion: " + list);

            list.add("Steak", 7);
            System.out.println("List after 8th insertion: " + list);
            
            
            
            //Q-2: remove celery and oranges 
            System.out.println("");

            System.out.println("The " + list.remove(list.find("Celery")) + " has been removed from the list.");
            System.out.println(list);

            System.out.println("The " + list.remove(list.find("Oranges")) + " has been removed from the list.");
            System.out.println(list);
            
            

        } 
        
        //Q-3: catch exception
        catch (ListException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            e.printStackTrace();
        }
    }
}
