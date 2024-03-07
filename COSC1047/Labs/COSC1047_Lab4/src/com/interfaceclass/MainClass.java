package com.interfaceclass;

public class MainClass implements A{

	   public void meth1() {
	      System.out.println("Meth1.");
	   }

	   public void meth2() {
	      System.out.println("Meth2.");
	   }

	   public static void main(String args[]) {
		  MainClass c = new MainClass();
	      c.meth1();
	      c.meth2();
	   }
}