/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Lab 5 Q2: ADTList Class
 * Any and All work in this file is my.
 **/
package lab5;

public class jtikiwalaLab5Q2 {


    public static void main(String[] args) {

        try {
        	jtikiwalaLab5Q1 list = new jtikiwalaLab5Q1(8);
            System.out.println(list);

            //Q-2: (a)Create list and inserts into the list
            //(b) print list after insertion
            list.add("Milk", 0);
            System.out.println(list);
            list.add("Eggs", 1);
            System.out.println(list);

            list.add("Celery", 2);
            System.out.println(list);

            list.add("Bananas", 3);
            System.out.println(list);
            list.add("Apples", 4);
            System.out.println(list);

            list.add("Oranges", 5);
            System.out.println(list);

            list.add("Cookies", 6);
            System.out.println(list);

            list.add("Steak", 7);
            System.out.println(list);
            
            //extra line to differentiate output
            System.out.println();

            //Q-3
            System.out.println("The  "+list.remove(list.find("Celery"))+" has been removed.");
            System.out.println(list);

            System.out.println("The  "+list.remove(list.find("Oranges"))+" has been removed.");
            System.out.println(list);

          //extra line to differentiate output
            System.out.println();
            
            //Swaped 
            System.out.println("The swaped list(index 2 and index 4):");
            swap(list, 2, 4);
            System.out.println(list);

        } catch (ListException e) {
            System.err.println(e.getMessage());
            System.err.flush();
            e.printStackTrace();
        }

    }
    //Q-1: Swap method and Q-5: catch exception
    public static void swap(jtikiwalaLab5Q1 list, int i, int j) throws ListException {
        if (i < 0 || i >= list.size() || j < 0 || j >= list.size()) {
            throw new ListException("Invalid index provided");
        }
        String temp = list.get(i);
        list.remove(i);
        list.add(list.get(j-1),i );
        list.remove(j);
        list.add(temp,j);

    }
}