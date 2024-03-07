package Q2;
/* author @jtikiwala
 * name: Jeel Tikiwala
 * Student id: 239659420
 * COSC1047_Assignment6*/

public class TestProgram {
    public static void main(String[] args) {
        GeometricObject[] squares = {new Square(3.5), new Square(11),
                new Square(9.6), new Square(17), new Square(2)};

        for (int i = 0; i < squares.length; i++) {
            System.out.println("\nSquare #" + (i + 1));
            System.out.println("The Area is: " + squares[i].getArea());
            if (squares[i] instanceof Colorable) {
                System.out.println("How to color the Square: " + ((Colorable) squares[i]).howToColor());
            }
        }
    }
}