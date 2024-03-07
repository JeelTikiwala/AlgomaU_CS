/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab2*/
package com.labexercise; //package 

class Exercise { //this is the main class
	String name;
    int duration;
    
	public Exercise(String name, int duration) {
		this.name = name;
        this.duration = duration;
	}
	
	public void start() {
        System.out.println("The starting exercise is " + name + ".");
        System.out.println("The Duration of the exercise is: " + duration + " minutes");
    }
	
	//This is child class or inherited class from parent class Exercise
	static class LabExercise extends Exercise {
		String labName;
		
		public LabExercise(String name, int duration, String labName) {
		     super(name, duration);
		     this.labName = labName;
		 }
		
		public void startLab() {
			 System.out.println("Starting lab is: " + labName);
		     System.out.println("The Starting lab exercise is: " + labName);
		     start(); // Calling start() method from the parent class
		 }
	}
	
	
	public static void main(String[] args) {
		Exercise exercise = new Exercise("Cardio", 45); //instance of parent class
        exercise.start(); // Calling start() method of Exercise

        System.out.println();

        LabExercise labExercise = new LabExercise("Java", 60, "OOP"); //instance of child class
        labExercise.startLab(); // Calling startLab() method of LabExercise
        
        

	}

}
