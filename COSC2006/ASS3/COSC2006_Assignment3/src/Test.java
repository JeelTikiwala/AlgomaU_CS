/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass3: Linked List
 * Any and All work in this file is my.
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        LinkedList List1 = new LinkedList();    
        LinkedList List2 = new LinkedList();    

        try {
        	
        	Scanner sc = new Scanner(new File("/Users/apple/Documents/AlgomaU_CS/SEM2/COSC2006/ASS3/Dataset1.txt")); 
            while (sc.hasNextLine()) {
                String[] studentDetails = sc.nextLine().split(" ");
                int Stu_no = Integer.parseInt(studentDetails[0]);
                double Stu_mark = Double.parseDouble(studentDetails[1]);
                List1.add(Stu_no, Stu_mark);
            }
            
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("<--------Data Set #1-------->");
        List1.printList();                   
        System.out.println(List1.findMedian());
        
        System.out.println("<--------Data Set #2-------->");
        try{
           
        	Scanner sc = new Scanner(new File("/Users/apple/Documents/AlgomaU_CS/SEM2/COSC2006/ASS3/Dataset2.txt"));
            while (sc.hasNextLine()){
                String [] studentDetails2= sc.nextLine().split(" ");
                int Stu_no = Integer.parseInt(studentDetails2[0]);  
                double Stu_mark = Double.parseDouble(studentDetails2[1]);      
                List2.add(Stu_no, Stu_mark);                 
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();   
        }
        
        List2.printList();                   
        System.out.println(List2.findMedian()); 
    }

}
