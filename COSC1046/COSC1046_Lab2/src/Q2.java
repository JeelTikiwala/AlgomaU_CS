import java.util.*; //Import explicit class
public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the side : ");
		double sidehex = sc.nextDouble(); //sidehex = length of side
		
		double areahex;
		double mathfn = 4 * Math.tan(Math.PI/6);
		
		areahex = 6 * sidehex * sidehex / (mathfn);
		
		System.out.println("The Area of Hexagon is:" + areahex);
	}

}
