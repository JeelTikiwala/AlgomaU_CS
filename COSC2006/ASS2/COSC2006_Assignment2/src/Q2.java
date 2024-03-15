/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass2: Recursion - Q2
 * Any and All work in this file is my.
 **/
import javax.swing.JOptionPane;

public class Q2
	{
		
		public static void main(String[] args)
		{
			//user input
			String inputN = JOptionPane.showInputDialog("Enter a value for N: ");
			
			int N = Integer.parseInt(inputN);

			if(Math.log(N)/Math.log(2) == Math.floor(Math.log(N)/Math.log(2)))
			{
				System.out.print("0");
				//call the recursive function for height n
				recursiveHeight(N);
				
				System.out.print("0");
				System.out.println();
				
				for(int i = 0; i <= N; i++)
				{
					System.out.print(i%10);
				}	
				System.out.println();
			}
		}
		
		 // recursive function to generate the pattern
		public static void recursiveHeight(int N)
		{
			if(N < 2)
			{
				return;
			}
			
			int Half = N/2;

			recursiveHeight(Half);

			// displays the value
			System.out.print(((int)(Math.log(N)/Math.log(2)))%10);

			recursiveHeight(Half);
		}
	}
		