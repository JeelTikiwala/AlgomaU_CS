/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_lab7*/
package lab7;

/**
 * @author jtikiwala
 *
 */
class Q1 implements Runnable{

	Thread t;
	
	Q1(){
		t = new Thread(this, "Demo thread");
		System.out.println("Demo thread is: " + t);
		t.start();
	}
	

	public void run() {
		try {
			for(int i=5; i<0; i--) {
				System.out.println("Demo thread is: " + i);
				Thread.sleep(15000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("Exception... ");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Q1 i = new Q1();
		try {
			for(int j=5; j>0; j--) {
				System.out.println("Main thread is: " + j);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			System.out.println("Closing...");
		}

	}

}
