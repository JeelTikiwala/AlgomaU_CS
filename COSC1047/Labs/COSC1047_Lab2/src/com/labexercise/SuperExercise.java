/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab2*/
package com.labexercise; //package
 
import com.labexercise.Exercise.LabExercise;

public class SuperExercise { //this is the main class
	
	String name;
    int duration;
    
	public SuperExercise(String name, int duration) {
		this.name = name;
        this.duration = duration;
	}

	public void start() {
        System.out.println("The starting exercise is: " + name  + ".");
        System.out.println("The Duration of the exercise is: " + duration + " minutes.");
        
    }
	
	
		static class LabExercise extends SuperExercise { //This is child class or inherited class from parent class Exercise
			String labName;
			
			public LabExercise(String name, int duration, String labName) { //constructor of parent class
			     super(name, duration);
			     this.labName = labName;
			 }
			
			public void startLab() {
		        super.start(); // start() method from the parent class using super
		        System.out.println("Starting lab is: " + labName);
		        System.out.println("The Lab exercise: " + labName + " has been started.");
		    }

		}
		
		
	public static void main(String[] args) { //main method, without main method the result can't be displayed
		SuperExercise exercise = new SuperExercise("Cycling", 60); //instance of parent class
        exercise.start(); // Calling start() method of Exercise

        System.out.println();

        LabExercise labExercise = new LabExercise("History", 47, "Rural Areas"); //instance of child class
        labExercise.startLab(); // calling the startLab() method of LabExercise
        

	}

}
